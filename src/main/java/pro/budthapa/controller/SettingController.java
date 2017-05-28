package pro.budthapa.controller;

import java.security.Principal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SettingController {
	Logger log = LoggerFactory.getLogger(SettingController.class);
	
	private static final String INDEX_PAGE = "settings/index";
	@GetMapping("/settings/user")
	public String index(Principal principal){
		log.info(principal.getName());
		return INDEX_PAGE;
	}
}
