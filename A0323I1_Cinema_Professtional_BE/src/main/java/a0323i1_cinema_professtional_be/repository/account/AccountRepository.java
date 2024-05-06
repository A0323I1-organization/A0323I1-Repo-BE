package a0323i1_cinema_professtional_be.repository.account;

import a0323i1_cinema_professtional_be.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface AccountRepository extends JpaRepository<Account,Integer> {
    @Query(value = "SELECT * FROM Account WHERE fullname=?1", nativeQuery = true)
    Account findAccountByFullname(String fullname);
}
