package a0323i1_cinema_professtional_be.repository.employee;


import a0323i1_cinema_professtional_be.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Integer> {
}
