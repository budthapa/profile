package pro.budthapa.service;

import java.util.List;

import pro.budthapa.domain.Category;

public interface CategoryService {
	public Category saveCategory(Category category);

	public Category checkDuplicateCategory(String name);

	public List<Category> findAllCategory();
}
