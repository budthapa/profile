package pro.budthapa.controller;

import java.security.Principal;
import java.time.LocalDate;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import pro.budthapa.domain.User;
import pro.budthapa.helper.PasswordHelper;
import pro.budthapa.service.UserService;

@Controller
public class DashboardController {
	Logger log = LoggerFactory.getLogger(DashboardController.class);
	public static final String INDEX_PAGE = "dashboard/index";
	public static final String PROFILE_PAGE = "dashboard/profile";
	private static final String REDIRECT_TO_DASHBOARD = "redirect:/dashboard";
	private static final String CHANGE_PASSWORD = "dashboard/changePassword";

	@Autowired
	private UserService userService;

	@Autowired
	RedisTemplate<String, Object> template;

	@Autowired
	private PasswordHelper passwordHelper;

	@GetMapping("/dashboard")
	public String index(Model model, Principal principal) {
		if (principal != null) {
			User user = userService.findUserByEmail(principal.getName());
			model.addAttribute("userId", user.getId());
			/*
			 * Jedis jedis = new Jedis("localhost", 6379); jedis.set("userId",
			 * String.valueOf(user.getId())); jedis.set("email",
			 * user.getEmail()); jedis.close();
			 */
			template.opsForValue().set("userId", user.getId());
			template.opsForValue().set("email", user.getEmail());
			return INDEX_PAGE;
		}

		return "redirect:/login";
	}

	@GetMapping("/settings/user/{id}/profile")
	public String settings(@PathVariable Long id, Principal principal, Model model) {
		String userId = (String) template.opsForValue().get("userId");
		String email = (String) template.opsForValue().get("email");

		if (id == Integer.parseInt(userId) && email.equals(principal.getName())) {
			User user = new User();
			user.setId(id);
			user.setEmail(email);
			model.addAttribute("user", user);
			return PROFILE_PAGE;
		}

		log.info("Trying to access invalid user id, redirecting now to dashboard.");
		return REDIRECT_TO_DASHBOARD;
		/*
		 * if(id != Long.parseLong(jedis.get("userId")) && jedis.get("email") !=
		 * principal.getName()){ return REDIRECT; }
		 */
	}

	@GetMapping("/settings/user/profile/change-password")
	public String changePassword(HttpServletRequest request, Principal principal, Model model) {
		User user = userService.findUserByEmail(principal.getName());

		model.addAttribute("loggedInEmail", principal.getName());
		model.addAttribute("user", user);

		return CHANGE_PASSWORD;
	}

	@PostMapping("/settings/user/profile/change-password")
	public String changePassword(@Valid User user, BindingResult result, Model model, Principal principal) {
		User userDb = userService.findUserByEmail(principal.getName());
		model.addAttribute("user", user);
		if (!result.hasErrors()) {

			boolean passwordMatches = passwordHelper.decryptPassword(user.getPassword(), userDb.getPassword());
			if (passwordMatches) {
				String newPassword = user.getPlainPassword();
				String retypePassword = user.getRetypePassword();
				if (!newPassword.matches(retypePassword)) {
					model.addAttribute("passwordMismatch", true);
					return CHANGE_PASSWORD;
				}

				String hashedPassword = passwordHelper.hashPassword(user.getPlainPassword());
				System.out.println(hashedPassword);

				userDb.setPassword(hashedPassword);
				userDb.setUpdateDate(LocalDate.now());

				userService.updateUser(userDb);
				model.addAttribute("passwordChanged", true);

			} else {
				model.addAttribute("passwordMatches", passwordMatches);
			}

		}

		return CHANGE_PASSWORD;
	}
}
