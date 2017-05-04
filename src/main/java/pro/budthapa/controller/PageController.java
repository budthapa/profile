package pro.budthapa.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import pro.budthapa.domain.Contact;

@Controller
public class PageController {

	private static final String INDEX_PAGE = "index";
	private static final String RESUME_PAGE = "resume";
	private static final String PROJECT_PAGE = "projects";
	private static final String BLOG_PAGE = "blog/index";
	private static final String CONTACT_PAGE = "contact";
	private static final String LOGIN_PAGE = "login";

	@GetMapping("/")
	public String index(){
		return INDEX_PAGE;
	}
	
	@GetMapping("/resume")
	public String resume(){
		return RESUME_PAGE;
	}
	
	@GetMapping("/project")
	public String project(){
		return PROJECT_PAGE;
	}
	
	@GetMapping("/blog")
	public String blog(){
		return BLOG_PAGE;
	}
	
	@GetMapping(value={"/contact", "/contact/new"})
	public String contact(Model model){
		model.addAttribute("contact", new Contact());
		return CONTACT_PAGE;
	}
	
	@GetMapping("/login")
	public String login(){
		return LOGIN_PAGE;
	}
}
