package a0323i1_cinema_professtional_be.service.employee;

import a0323i1_cinema_professtional_be.entity.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> findAll();
    void deleteEmployee(int id);


}
