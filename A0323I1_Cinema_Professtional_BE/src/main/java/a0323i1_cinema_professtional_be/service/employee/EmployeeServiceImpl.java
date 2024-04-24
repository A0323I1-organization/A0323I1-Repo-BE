package a0323i1_cinema_professtional_be.service.employee;

import a0323i1_cinema_professtional_be.entity.Employee;
import a0323i1_cinema_professtional_be.repository.account.AccountRepository;
import a0323i1_cinema_professtional_be.repository.employee.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;

@Service
public class EmployeeServiceImpl implements EmployeeService{
    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private AccountRepository accountRepository;
    @Transactional
    @Override
    public void create(String address, Date birthday, boolean gender, String fullname, String idCard, String email, String phone, String employeeImage, int accountId) {
     employeeRepository.createEmployee(address, birthday, gender, fullname, idCard, email, phone, employeeImage, accountId);
    }

    @Override
    public void update( String address, Date birthday, boolean gender, String fullname, String idCard, String email, String phone, String employeeImage, int accountId,int id) {
        employeeRepository.updateEmployee(address,birthday,gender,fullname,idCard,email,phone,employeeImage,accountId,id);
    }


}
