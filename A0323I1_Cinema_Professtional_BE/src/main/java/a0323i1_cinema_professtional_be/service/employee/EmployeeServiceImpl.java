package a0323i1_cinema_professtional_be.service.employee;

import a0323i1_cinema_professtional_be.entity.Account;
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
    public void create(String address, Date birthday, String email, String fullname, boolean gender, String idCard, String image, String phone, int account, String username, String password) {
        // Save the account first
        accountRepository.create(username, password);

        // Retrieve the persisted account
        Account persistedAccount = accountRepository.findByUsername(username);
        employeeRepository.create(address,birthday,email,fullname,gender,idCard,image,phone,persistedAccount);
    }
}
