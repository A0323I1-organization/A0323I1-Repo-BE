package a0323i1_cinema_professtional_be.service.employee;

import org.springframework.stereotype.Service;

import java.util.Date;
@Service
public interface EmployeeService {
    void create(String address, Date birthday, String email, String fullname,
                boolean gender, String idCard, String image, String phone, int account, String username, String password);
}
