package a0323i1_cinema_professtional_be.service.employee;


import org.springframework.stereotype.Service;

import java.util.Date;
@Service
public interface EmployeeService {


    void create(String address, Date birthday, boolean gender, String fullname,
                String idCard, String email,
                String phone, String employeeImage, int accountId,boolean status);

    void update(String address, Date birthday, boolean gender, String fullname,
                                  String idCard, String email,
                                  String phone, String employeeImage, int accountId, int id);


}
