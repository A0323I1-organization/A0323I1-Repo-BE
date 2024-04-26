package a0323i1_cinema_professtional_be.service.employee;

import a0323i1_cinema_professtional_be.entity.Employee;
import a0323i1_cinema_professtional_be.exception.ResourceNotFoundException;
import a0323i1_cinema_professtional_be.repository.employee.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;


@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    EmployeeRepository employeeRepository;

    @Transactional
    @Override
    public void create(String address, Date birthday, boolean gender, String fullname, String idCard, String email, String phone, String employeeImage, int accountId,boolean status) {
        employeeRepository.createEmployee(address, birthday, gender, fullname, idCard, email, phone, employeeImage, accountId,status);
    }

    @Override
    public void update(String address, Date birthday, boolean gender, String fullname, String idCard, String email, String phone, String employeeImage, int accountId, int id) {
        employeeRepository.updateEmployee(address, birthday, gender, fullname, idCard, email, phone, employeeImage, accountId, id);

    }


}
