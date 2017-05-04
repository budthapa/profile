package pro.budthapa.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import pro.budthapa.domain.Blog;
import pro.budthapa.domain.Category;
import pro.budthapa.service.BlogService;
import pro.budthapa.service.CategoryService;

@Controller
public class BlogController {
	private static final String ADD_NEW_BLOG = "blog/addBlog";
	private static final String INDEX_PAGE = "blog/index";

	
	@Autowired
	private CategoryService categoryService;
	
	@Autowired
	private BlogService blogService; 
	
	@GetMapping("/blog/new")
	public String index(Model model){
		model.addAttribute("categories", categoryService.findAllCategory());
		model.addAttribute("blog", new Blog());
		return ADD_NEW_BLOG;
	}
	
	@PostMapping("/blog/new")
	public String index(@Valid Blog blog, BindingResult result, Model model){
		model.addAttribute("categories", categoryService.findAllCategory());
		model.addAttribute("blog", blog);
		if(!result.hasErrors()){			
			blogService.saveBlog(blog);
			model.addAttribute("blogSaved", true);
			return ADD_NEW_BLOG;
		}
		return ADD_NEW_BLOG;
	}
	
	@GetMapping("/blog/all")
	public String findAllBlog(Model model){
		model.addAttribute("blogs",blogService.findAllBlogs());
		return INDEX_PAGE;
	}
}
