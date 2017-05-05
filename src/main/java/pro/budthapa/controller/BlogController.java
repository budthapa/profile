package pro.budthapa.controller;

import java.time.LocalDate;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import pro.budthapa.domain.Blog;
import pro.budthapa.service.BlogService;
import pro.budthapa.service.CategoryService;

@Controller
public class BlogController {
	private static final String ADD_NEW_BLOG = "blog/addBlog";
	private static final String INDEX_PAGE = "blog/index";
	private static final String SHOW_BLOG_PAGE = "blog/showBlog";
	private static final String EDIT_BLOG_PAGE = "blog/editBlog";

	@Autowired
	private CategoryService categoryService;

	@Autowired
	private BlogService blogService;

	@GetMapping("/blog/new")
	public String index(Model model) {
		model.addAttribute("categories", categoryService.findAllCategory());
		model.addAttribute("blog", new Blog());
		return ADD_NEW_BLOG;
	}

	@PostMapping("/blog/new")
	public String index(@Valid Blog blog, BindingResult result, Model model) {
		model.addAttribute("categories", categoryService.findAllCategory());
		model.addAttribute("blog", blog);
		if (!result.hasErrors()) {
			blogService.saveBlog(blog);
			model.addAttribute("blogSaved", true);
			return ADD_NEW_BLOG;
		}

		return ADD_NEW_BLOG;
	}

	@GetMapping("/blog/all")
	public String findAllBlog(Model model) {
		model.addAttribute("blogs", blogService.findAllBlogs());
		return INDEX_PAGE;
	}

	@GetMapping("/blog/show/{id}")
	public String findAllBlog(@PathVariable Long id, Model model) {
		Blog blog = blogService.findBlogById(id);
		if (blog != null) {
			model.addAttribute("blog", blog);
			return SHOW_BLOG_PAGE;
		}
		model.addAttribute("blogNotFound", true);
		model.addAttribute("blogs", blogService.findAllBlogs());
		return INDEX_PAGE;
	}

	@GetMapping("/blog/edit/{id}")
	public String editBlog(@PathVariable Long id, Model model, Blog blog) {
		blog = blogService.findBlogById(id);
		model.addAttribute("categories", categoryService.findAllCategory());
		if (blog != null) {
			model.addAttribute("blog", blog);
			return EDIT_BLOG_PAGE;
		}
		model.addAttribute("blogNotFound", true);
		return EDIT_BLOG_PAGE;
	}

	@PostMapping("/blog/edit/{id}")
	public String updateBlog(@PathVariable Long id, @Valid Blog blog, BindingResult result, Model model) {
		model.addAttribute("categories", categoryService.findAllCategory());
		model.addAttribute("blog", blog);
		if (!result.hasErrors()) {
			blog.setId(id);
			blog.setUpdateDate(LocalDate.now());
			blogService.updateBlog(blog);
			model.addAttribute("blogUpdated", true);
			return EDIT_BLOG_PAGE;
		}

		return EDIT_BLOG_PAGE;
	}

	@PostMapping("/blog/delete/{id}")
	public String deleteBlog(@PathVariable Long id, Model model, Blog blog) {
		System.out.println("blog id: "+id);
//		blogService.deleteBlog(id);
		model.addAttribute("blogDeleted", true);
		model.addAttribute("blogs", blogService.findAllBlogs());
		return "redirect:/blog/all";
	}

}
