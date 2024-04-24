package a0323i1_cinema_professtional_be.service.employee;

import a0323i1_cinema_professtional_be.entity.Employee;
import org.springframework.stereotype.Service;

import java.util.Date;
@Service
public interface EmployeeService {
    void create( String address,Date birthday, boolean gender, String fullname,
               String idCard, String email,
                String phone, String employeeImage, int accountId);

    void update( String address,Date birthday, boolean gender, String fullname,
                 String idCard, String email,
                 String phone, String employeeImage, int accountId,int id);
}
