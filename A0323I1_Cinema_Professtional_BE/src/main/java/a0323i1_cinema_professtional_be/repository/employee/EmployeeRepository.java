package a0323i1_cinema_professtional_be.repository.employee;

import a0323i1_cinema_professtional_be.entity.Employee;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    @Query(value = "select * from employee e join account a on a.account_id = e.employee_account_id where a.status = 1", nativeQuery = true)
    List<Employee>findAll();
    @Modifying
    @Query(value = "delete from employee e where e.employee_id = :id", nativeQuery = true)
    @Transactional
    void deleteEmployee(@Param("id")int id);



}
