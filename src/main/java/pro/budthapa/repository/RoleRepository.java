package pro.budthapa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pro.budthapa.domain.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long>{
	Role findByRole(String role);
}
