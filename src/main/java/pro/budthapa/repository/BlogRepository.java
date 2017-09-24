package pro.budthapa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pro.budthapa.domain.Blog;
import pro.budthapa.domain.Category;

@Repository
public interface BlogRepository extends JpaRepository<Blog, Long>{
	public List<Blog> findFirst2ByOrderByCreateDateDesc();
	public List<Blog> findBlogByCategory(Category category);
}
