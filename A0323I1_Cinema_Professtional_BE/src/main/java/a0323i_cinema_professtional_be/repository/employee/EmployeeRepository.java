package a0323i_cinema_professtional_be.repository.employee;

import a0323i_cinema_professtional_be.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface EmployeeRepository extends JpaRepository<Employee,Integer> {
    @Query(value = "SELECT * FROM account WHERE username=?1", nativeQuery = true)
    Employee findAccountByUsername(String username);
}
