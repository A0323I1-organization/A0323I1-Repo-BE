package a0323i1_cinema_professtional_be.repository.account;

import a0323i1_cinema_professtional_be.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<Account,Integer> {
    @Modifying
    @Query(value = "INSERT INTO account (`username`, `password`,`status`) VALUES (:username, :password,true)", nativeQuery = true)
    void create(@Param("username") String username, @Param("password") String password);
    Account findByUsername(String username);
}
