package a0323i1_cinema_professtional_be.service.employee;

import a0323i1_cinema_professtional_be.entity.Employee;
import a0323i1_cinema_professtional_be.repository.employee.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    EmployeeRepository employeeRepository;

    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public void deleteEmployee(int id) {
        employeeRepository.deleteEmployee(id);
    }

}
