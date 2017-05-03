package pro.budthapa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pro.budthapa.domain.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long>{
	public Category findByName(String name);
	public Category findById(Long id);
}
