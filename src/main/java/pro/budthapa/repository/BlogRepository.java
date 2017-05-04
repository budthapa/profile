package pro.budthapa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pro.budthapa.domain.Blog;

@Repository
public interface BlogRepository extends JpaRepository<Blog, Long>{

}
