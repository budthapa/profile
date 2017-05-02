package pro.budthapa.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageController {

	private static final String INDEX_PAGE = "index";

	@GetMapping("/")
	public String index(){
		return INDEX_PAGE;
	}
}
