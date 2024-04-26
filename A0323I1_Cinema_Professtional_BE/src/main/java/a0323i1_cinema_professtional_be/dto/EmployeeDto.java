package a0323i1_cinema_professtional_be.dto;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;


import java.util.Date;
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDto {

    private Date birthday;

    private boolean gender;

    private String fullname;


    private String idCard;


    private String email;

    private String phone;

    private String address;

    private String employeeImage;
}
