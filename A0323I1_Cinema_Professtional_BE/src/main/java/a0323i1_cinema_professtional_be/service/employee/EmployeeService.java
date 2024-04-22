package a0323i1_cinema_professtional_be.service.employee;

import a0323i1_cinema_professtional_be.entity.Employee;

import org.springframework.stereotype.Service;

import java.util.Date;
@Service
public interface EmployeeService {
    void create(Employee employee);
    void update(Employee employee);
    Employee findById(int id);

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface EmployeeService {
    Page<Employee> findAll(String fullname, String phone,Pageable pageable);
    void deleteEmployee(int id);



}
