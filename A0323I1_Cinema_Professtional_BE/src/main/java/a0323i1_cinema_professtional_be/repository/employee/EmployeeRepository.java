package a0323i1_cinema_professtional_be.repository.employee;

import a0323i1_cinema_professtional_be.entity.Employee;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties;
import org.springframework.data.domain.Page;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import javax.transaction.Transactional;
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    @Query("SELECT e FROM Employee e JOIN e.account a WHERE a.status = 1 AND e.fullname LIKE :fullname AND e.phone LIKE :phone")
    Page<Employee> findAll(@Param("fullname")String fullname, @Param("phone")String phone, Pageable pageable);
    @Modifying
    @Transactional
    @Query("DELETE FROM Employee e WHERE e.id = :id")
    void deleteEmployeeById(@Param("id") int id);

    @Query("SELECT e FROM Employee e WHERE e.id = :id")
    Employee findEmployeeById(@Param("id") int id);




}
