package pro.budthapa.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pro.budthapa.domain.Category;
import pro.budthapa.repository.CategoryRepository;
import pro.budthapa.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService{

	@Autowired
	CategoryRepository categoryRepository;
	
	public Category saveCategory(Category category){
		return categoryRepository.save(category);
	}

	@Override
	public Category checkDuplicateCategory(String name) {
		return categoryRepository.findByName(name);
	}

	@Override
	public List<Category> findAllCategory() {
		return (List<Category>)categoryRepository.findAll();
	}
}
