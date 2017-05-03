package pro.budthapa.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import pro.budthapa.domain.Category;
import pro.budthapa.service.CategoryService;

@Controller
public class CategoryController {

	private static final String INDEX_PAGE = "category/index";
	private static final String ADD_CATEGORY = "category/addCategory";
	private static final String EDIT_CATEGORY = "category/editCategory";

	@Autowired
	CategoryService categoryService;

	@GetMapping("/category/all")
	public String index(Model model) {
		model.addAttribute("categories", categoryService.findAllCategory());
		return INDEX_PAGE;
	}

	@GetMapping("/category/new")
	public String addCategory(Model model, Category category) {
		return ADD_CATEGORY;
	}

	@PostMapping("/category/new")
	public String addCategory(@Valid Category category, BindingResult result, Model model) {
		model.addAttribute(category);
		if (result.hasErrors()) {
			model.addAttribute("invalidCategory", true);
			return ADD_CATEGORY;
		}

		Category name = categoryService.checkDuplicateCategory(category.getName());
		if (name != null) {
			model.addAttribute("categoryExists", "category.name.exists");
		} else {
			categoryService.saveCategory(category);
			model.addAttribute("categorySaved", "category.save.success");
		}
		return ADD_CATEGORY;
	}
	
	@GetMapping("/category/edit/{id}")
	public String editCategory(Model model, @PathVariable Long id){
		Category category=categoryService.findCategory(id);
		if(category!=null){
			model.addAttribute(category);
			return EDIT_CATEGORY;
		}
		model.addAttribute("categoryNotFound", true);
		model.addAttribute("categories", categoryService.findAllCategory());
		return INDEX_PAGE;
	}
	
	@PostMapping(value="/category/edit/{id}")
	public String editCategory(@Valid Category category, BindingResult result, Model model,
			@PathVariable Long id){
		category.setId(id);
		model.addAttribute(category);
		if (result.hasErrors()) {
			model.addAttribute("invalidCategory", true);
			return ADD_CATEGORY;
		}
		
		if(!result.hasErrors()){
			Category name=categoryService.checkDuplicateCategory(category.getName());
			if(name!=null){
				model.addAttribute(category);
				model.addAttribute("categoryExists","category.name.exists");
				return EDIT_CATEGORY;
			}else{
				categoryService.updateCategory(category);
				model.addAttribute("categoryUpdated", true);
			}
		}
		
		return EDIT_CATEGORY;
	}
}
