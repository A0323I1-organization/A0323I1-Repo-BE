package a0323i1_cinema_professtional_be.repository;

import a0323i1_cinema_professtional_be.entity.Account;
import a0323i1_cinema_professtional_be.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface IAccountRepository extends JpaRepository< Employee, Integer > {
}
