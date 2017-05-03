package pro.budthapa.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import pro.budthapa.domain.Blog;
import pro.budthapa.domain.Category;

@Controller
public class BlogController {
	private static final String ADD_NEW_BLOG = "blog/addBlog";
	
	@GetMapping("/blog/new")
	public String index(Model model, Blog blog, Category category){
		model.addAttribute("category", category);
		model.addAttribute("blog", blog);
		return ADD_NEW_BLOG;
	}
	
	@PostMapping("/blog/new")
	public String index(Model model, Blog blog, Category category, BindingResult result){
		
		model.addAttribute("category", category);
		model.addAttribute("blog", blog);
		if(result.hasErrors()){
			model.addAttribute("invalidField", true);
			
		}
		return ADD_NEW_BLOG;
	}
}
