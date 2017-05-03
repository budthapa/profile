package pro.budthapa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pro.budthapa.domain.Contact;

@Repository
public interface ContactRepository extends JpaRepository<Contact, Long>{
	public List<Contact> findAllByOrderByDateDesc();
}
