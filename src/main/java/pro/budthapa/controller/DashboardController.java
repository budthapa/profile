package pro.budthapa.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DashboardController {
	Logger log = LoggerFactory.getLogger(DashboardController.class);
	public static final String INDEX_PAGE = "dashboard/index";
	
	@GetMapping("/dashboard")
	public String index(){
		return INDEX_PAGE;
	}
}
