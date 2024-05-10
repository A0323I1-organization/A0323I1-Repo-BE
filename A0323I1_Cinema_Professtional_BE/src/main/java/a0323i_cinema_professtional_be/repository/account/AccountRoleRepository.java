package a0323i_cinema_professtional_be.repository.account;

import a0323i_cinema_professtional_be.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRoleRepository extends JpaRepository< Account, Integer > {
}
