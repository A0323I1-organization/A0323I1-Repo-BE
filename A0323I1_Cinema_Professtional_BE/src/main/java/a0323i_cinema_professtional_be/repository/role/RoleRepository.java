package a0323i_cinema_professtional_be.repository.role;

import a0323i_cinema_professtional_be.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role,Integer> {
}
