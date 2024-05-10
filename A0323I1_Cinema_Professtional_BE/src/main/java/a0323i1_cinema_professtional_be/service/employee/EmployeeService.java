package a0323i1_cinema_professtional_be.service.employee;

import a0323i1_cinema_professtional_be.entity.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface EmployeeService {
    Page<Employee> findAll(String fullname, String phone,Pageable pageable);
    void deleteEmployee(int id);


}
