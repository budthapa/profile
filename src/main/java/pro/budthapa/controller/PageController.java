package pro.budthapa.controller;

import java.io.IOException;
import java.security.Principal;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.apache.commons.lang.RandomStringUtils;
import org.apache.commons.validator.routines.EmailValidator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.maxmind.geoip2.exception.GeoIp2Exception;

import pro.budthapa.domain.Contact;
import pro.budthapa.domain.Register;
import pro.budthapa.domain.User;
import pro.budthapa.helper.GeoLocation;
import pro.budthapa.helper.GeoLocationHelper;
import pro.budthapa.service.EmailHelperService;
import pro.budthapa.service.UserService;

@Controller
public class PageController {
	private final String HTTP_SCHEME = "http://";
	private final String ADDRESS = "budthapa.pro";
	private final String VERIFY = "/verify/";
	Logger log = LoggerFactory.getLogger(PageController.class);

	private static final String INDEX_PAGE = "index";
	private static final String RESUME_PAGE = "resume/index";
	private static final String PROJECT_PAGE = "projects";
	private static final String BLOG_PAGE = "blog/index";
	private static final String CONTACT_PAGE = "contact";
	private static final String LOGIN_PAGE = "login";
	private static final String REGISTRATION_PAGE = "registration";

	@Autowired
	private UserService userService;

	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	@Autowired
	private EmailHelperService emailHelper;

	@GetMapping("/")
	public String index(Model model, HttpServletRequest request) throws IOException, GeoIp2Exception {
//		 String ip =request.getRemoteAddr();
		 String ip = "31.215.16.96"; //my public id
//		 String ip = "206.190.36.45";
//		String ip = "216.58.207.14"; // google.com
//		 String ip = "96.30.12.176"; //hamrobazar.com

		GeoLocation gl = new GeoLocation();
		GeoLocationHelper glHelper = gl.getLocation(ip);

		LocalTime localTime = glHelper.getCurrentUserTime();
		int hour = localTime.getHour();

		if (hour >= 5 && hour <= 11) {
			model.addAttribute("goodMorning", true);
		} else if (hour >= 12 && hour <= 17) {
			model.addAttribute("goodAfternoon", true);
		} else if (hour >= 18 && hour <= 20) {
			model.addAttribute("goodEvening", true);
		}else if (hour >=00 && hour <= 4){
			model.addAttribute("midNight", true);
		} else {
			model.addAttribute("goodNight", true);
		}

		model.addAttribute("currentUserTime", glHelper.getCurrentUserTime().getHour()
				+":"+glHelper.getCurrentUserTime().getMinute()
				+":"+glHelper.getCurrentUserTime().getSecond());

		return INDEX_PAGE;
	}

	@GetMapping("/resume")
	public String resume() {
		return RESUME_PAGE;
	}

	@GetMapping("/project")
	public String project() {
		return PROJECT_PAGE;
	}

	@GetMapping("/blog")
	public String blog() {
		return BLOG_PAGE;
	}

	@GetMapping(value = { "/contact", "/contact/new" })
	public String contact(Model model) {
		model.addAttribute("contact", new Contact());
		return CONTACT_PAGE;
	}

	@GetMapping("/login")
	public String login() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (auth != null && auth.isAuthenticated() && !(auth instanceof AnonymousAuthenticationToken)) {
			return "redirect:/";
		}
		return LOGIN_PAGE;
	}

	@GetMapping("/register")
	public String registration(Model model) {
		model.addAttribute("register", new Register());
		return REGISTRATION_PAGE;
	}

	@PostMapping("/register")
	public String registration(@Valid Register register, BindingResult result, Model model, HttpServletRequest request)
			throws Exception {
		model.addAttribute("register", register);
		if (!result.hasErrors()) {
			EmailValidator emailValidator = EmailValidator.getInstance();
			String registeredEmail = register.getEmail();
			if (emailValidator.isValid(registeredEmail)) {
				User registeredUser = userService.findUserByEmail(registeredEmail);

				if (registeredUser != null) {
					model.addAttribute("accountExists", true);
					return REGISTRATION_PAGE;
				} else {
					User user = new User();
					user.setEmail(register.getEmail());
					String randomPassword = RandomStringUtils.randomAlphanumeric(10); // send
																						// this
																						// password
																						// in
																						// email
					log.info("Password is " + randomPassword);
					user.setName("your name");
					String hashedPassword = bCryptPasswordEncoder.encode(randomPassword);
					user.setPassword(hashedPassword);
					user.setPlainPassword(randomPassword);
					user.setActive(false);

					String uuid = UUID.randomUUID().toString();
					user.setAuthenticationCode(uuid);

					String url = createUrl(uuid, request);

					log.info(url);

					emailHelper.sendEmailWithoutTemplating(registeredEmail, url, randomPassword);

					userService.saveUser(user);

					model.addAttribute("registrationSuccess", true);
					return REGISTRATION_PAGE;
				}

			}
		}
		model.addAttribute("invalidEmail", true);
		return REGISTRATION_PAGE;

	}

	@GetMapping("/verify/{authenticationCode}")
	public String verifyAccount(@PathVariable String authenticationCode, Model model) {
		User user = userService.findUserByAuthenticationCode(authenticationCode);
		if (user != null) {
			LocalDate joinDate = user.getJoinDate();
			LocalDate currentDate = LocalDate.now();
			long daysDiff = ChronoUnit.DAYS.between(joinDate, currentDate);
			if (user.isActive()) {
				model.addAttribute("accountAlreadyActivated", true);
				return LOGIN_PAGE;
			} else if (daysDiff == 0 && user.isActive() == false) {
				user.setActive(true);
				// don't remove this line, this is not persisted in db, escaping
				// validation
				user.setPlainPassword("12345678");
				userService.updateUser(user);
				model.addAttribute("accountActivated", true);
				return LOGIN_PAGE;
			} else if (daysDiff != 0 && user.isActive() == false) {
				// TODO: RESEND ACTIVATION LINK IF USER LINK IS EXPIRED BUT USER
				// IS NOT ACTIVATED
				model.addAttribute("resendActivationLink", true);
				return LOGIN_PAGE;
			}
		}
		model.addAttribute("linkExpired", true);
		return LOGIN_PAGE;
	}

	private String createUrl(String uuid, HttpServletRequest request) {
		String url = HTTP_SCHEME + ADDRESS + VERIFY + uuid;
		return url;
	}

	@GetMapping("/access-denied")
	public String accessDenied403(Principal principal, Model model) {
		model.addAttribute("name", principal.getName());
		return "error/403";
	}
}