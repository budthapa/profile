package pro.budthapa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pro.budthapa.domain.Blog;

@Repository
public interface BlogRepository extends JpaRepository<Blog, Long>{
	public List<Blog> findFirst2ByOrderByCreateDateDesc();
}
