package pro.budthapa.controller;

import java.io.UnsupportedEncodingException;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.apache.commons.lang.RandomStringUtils;
import org.apache.commons.validator.routines.EmailValidator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import pro.budthapa.domain.Contact;
import pro.budthapa.domain.Register;
import pro.budthapa.domain.User;
import pro.budthapa.service.EmailHelperService;
import pro.budthapa.service.UserService;

@Controller
public class PageController {
	private final String HTTP_SCHEME = "http://";
	private final String VERIFY = "/verify/";
	Logger log = LoggerFactory.getLogger(PageController.class);
	
	private static final String INDEX_PAGE = "index";
	private static final String RESUME_PAGE = "resume";
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
	public String index() {
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
		return LOGIN_PAGE;
	}

	@GetMapping("/register")
	public String registration(Model model) {
		model.addAttribute("register", new Register());
		return REGISTRATION_PAGE;
	}

	@PostMapping("/register")
	public String registration(@Valid Register register, BindingResult result, Model model, HttpServletRequest request) throws Exception{
		model.addAttribute("register", register);
		if(!result.hasErrors()){
			EmailValidator emailValidator = EmailValidator.getInstance();
			String registeredEmail = register.getEmail();
			if(emailValidator.isValid(registeredEmail)){				
				User registeredUser = userService.findUserByEmail(registeredEmail);

				if(registeredUser!=null){
					model.addAttribute("accountExists",true);
					return REGISTRATION_PAGE;
				}else{
					//TODO: send registration email 
					User user = new User();
					user.setEmail(register.getEmail());
					String randomPassword = RandomStringUtils.randomAlphanumeric(10); //send this password in email
					log.info("Password is "+randomPassword);
					user.setName("your name");
					String hashedPassword = bCryptPasswordEncoder.encode(randomPassword);
					user.setPassword(hashedPassword); 
					user.setPlainPassword(randomPassword);
					user.setActive(false);
					
					String uuid = UUID.randomUUID().toString();
					user.setAuthenticationCode(uuid);
					
					String url = createUrl(uuid, request);

					log.info(url);
					
					emailHelper.sendEmailWithoutTemplating(registeredEmail, url);
					
					//userService.saveUser(user);

					model.addAttribute("registrationSuccess",true);
					return REGISTRATION_PAGE;
				}
			
			}
		}
		model.addAttribute("invalidEmail",true);
		return REGISTRATION_PAGE;

	}

	private String createUrl(String uuid, HttpServletRequest request) {
		String address = request.getLocalName(); 
		String url = HTTP_SCHEME + address + VERIFY + uuid;
		return url;
	}
}