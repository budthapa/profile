package pro.budthapa.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import pro.budthapa.domain.Resume;

@Repository
public interface ResumeRepository extends CrudRepository<Resume, Long>{
	Resume findByEmail(String email);
}
