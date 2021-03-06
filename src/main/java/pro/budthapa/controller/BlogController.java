package pro.budthapa.controller;

import java.security.Principal;
import java.time.LocalDate;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import pro.budthapa.domain.Blog;
import pro.budthapa.domain.Category;
import pro.budthapa.domain.User;
import pro.budthapa.helper.BlogHelper;
import pro.budthapa.service.BlogService;
import pro.budthapa.service.CategoryService;
import pro.budthapa.service.UserService;

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

	@Autowired
	private UserService userService;
	
	@GetMapping("/blog/new")
	public String index(Model model) {
		allCategories(model);
		model.addAttribute("blog", new Blog());
		return ADD_NEW_BLOG;
	}

	@PostMapping("/blog/new")
	public String index(@Valid Blog blog, BindingResult result, Model model, Principal principal) {
		allCategories(model);
		model.addAttribute("blog", blog);
		if (!result.hasErrors()) {
			User user = userService.findUserByEmail(principal.getName());
			blog.setUser(user);
			blogService.saveBlog(blog);
			model.addAttribute("blogSaved", true);
			return ADD_NEW_BLOG;
		}
		return ADD_NEW_BLOG;
	}

	@GetMapping("/blog/all")
	public String getAllBlog(Model model) {
		return findBlogs(model, new Category());
	}
	
	@Cacheable("showBlogById")
	@GetMapping("/blog/show/{id}/{blogTitle}")
	public String findAllBlog(@PathVariable Long id, @PathVariable String blogTitle, Model model) {
		Blog blog = blogService.findBlogById(id);
		recentBlogs(model);
		allCategories(model);
		if (blog != null) {
			model.addAttribute("blog", blog);
			return SHOW_BLOG_PAGE;
		}
		model.addAttribute("blogNotFound", true);
		allBlogs(model);
		return INDEX_PAGE;
	}

	@GetMapping("/blog/edit/{id}")
	public String editBlog(@PathVariable Long id, Model model, Blog blog) {
		blog = blogService.findBlogById(id);
		allCategories(model);
		
		if (blog != null) {
			model.addAttribute("blog", blog);
			return EDIT_BLOG_PAGE;
		}
		model.addAttribute("blogNotFound", true);
		return EDIT_BLOG_PAGE;
	}

	@PostMapping("/blog/edit/{id}")
	public String updateBlog(@PathVariable Long id, @Valid Blog blog, BindingResult result, Model model, Principal principal) {
		allCategories(model);
		
		model.addAttribute("blog", blog);
		if (!result.hasErrors()) {
			blog.setId(id);
			blog.setUpdateDate(LocalDate.now());
			User user = userService.findUserByEmail(principal.getName());
			blog.setUser(user);
			blogService.updateBlog(blog);
			model.addAttribute("blogUpdated", true);
			return EDIT_BLOG_PAGE;
		}

		return EDIT_BLOG_PAGE;
	}

	@PostMapping("/blog/delete/{id}")
	public String deleteBlog(@PathVariable Long id, Model model, Blog blog) {
		System.out.println("blog id: " + id);
		// blogService.deleteBlog(id);
		model.addAttribute("blogDeleted", true);
		allBlogs(model);
		return "redirect:/blog/all";
	}

	@GetMapping("/blog/category/{id}/{name}")
	public String getBlogByCategory(@PathVariable(name = "id") Long categoryId, @PathVariable String name, Category category, Model model) {
		List<Blog> blog = blogService.findAllBlogsByCategory(category);
		for(Blog b:blog) {
			System.out.println(b.getId()+" "+b.getTitle());
		}
		category.setBlog(blog);
		category.setName(name);
		return findBlogs(model, category);

	}

	private String findBlogs(Model model, Category category) {
		if (category.getId() != null) {
			model.addAttribute("blogCategory",true);
			model.addAttribute("blogCategoryName",category.getName());
			model.addAttribute("blogs", BlogHelper.replaceSpaceWithHypen(category.getBlog()));
		} else {
			model.addAttribute("blogAll",true);
			allBlogs(model);
		}
		recentBlogs(model);
		allCategories(model);
		return INDEX_PAGE;
	}
	
	private void recentBlogs(Model model) {
		List<Blog> blogs = blogService.findRecentBlog();
		model.addAttribute("recentBlogs", BlogHelper.replaceSpaceWithHypen(blogs));
	}
	
	private void allBlogs(Model model){
		List<Blog> blogs = blogService.findAllBlogs();
		model.addAttribute("blogs", BlogHelper.replaceSpaceWithHypen(blogs));
	}
	
	private void allCategories(Model model){
		model.addAttribute("categories", categoryService.findAllCategory());
	}
	/*
	private List<Blog> replaceSpaceWithHypen(List<Blog> blogList) {
		for(int i=0;i<blogList.size();i++) {
			blogList.get(i).setTitleWithHypen(blogList.get(i).getTitle().replace(" ", "-"));
		}
		return blogList;
	}
	*/
}