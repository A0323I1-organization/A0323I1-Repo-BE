package a0323i1_cinema_professtional_be.controller;

import a0323i1_cinema_professtional_be.entity.Employee;
import a0323i1_cinema_professtional_be.service.employee.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("employee")
@Controller
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;
    @GetMapping("create")
    public String showCreate(Model model){
        model.addAttribute("employee",new Employee());
        return "/create";
    }
    @PostMapping("create")
    public String doCreate(@ModelAttribute("employee") Employee employee){
        employeeService.create(employee.getAddress(),employee.getBirthday(),employee.getEmail(),employee.getFullname(),employee.isGender(),employee.getIdCard(),employee.getEmployeeImage(),employee.getPhone(),employee.getAccount().getAccountId(),employee.getAccount().getUsername(),employee.getAccount().getPassword());
        return "/list";
    }
}
