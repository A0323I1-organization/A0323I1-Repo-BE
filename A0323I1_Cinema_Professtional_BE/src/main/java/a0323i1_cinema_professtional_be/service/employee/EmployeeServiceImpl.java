import a0323i1_cinema_professtional_be.exception.ResourceNotFoundException;
import a0323i1_cinema_professtional_be.repository.employee.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    EmployeeRepository employeeRepository;

    @Override
    public Page<Employee> findAll(String fullname,String phone,Pageable pageable) {
        return employeeRepository.findAll(fullname,phone,pageable);
    }

    @Override
    @Transactional
    public void deleteEmployee(int id) {
           Employee employeeDelete = employeeRepository.findEmployeeById(id);
           if(employeeDelete== null){
               throw new ResourceNotFoundException("Employee", " Id ", id);
           }else{
               employeeRepository.deleteEmployeeById(id);
           }
    }
  @Transactional
    @Override
    public void create(Employee employee) {
     employeeRepository.save(employee);
    }

    @Override
    public void update(Employee employee) {
        employeeRepository.save(employee);
    }

    @Override
    public Employee findById(int id) {
        return employeeRepository.findById(id).orElse(null );
    }
}
