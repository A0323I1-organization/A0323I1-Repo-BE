package a0323i1_cinema_professtional_be.controller;

import a0323i1_cinema_professtional_be.entity.Employee;
import a0323i1_cinema_professtional_be.exception.ApiException;
import a0323i1_cinema_professtional_be.exception.ApiRequestException;
import a0323i1_cinema_professtional_be.service.employee.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;
    @GetMapping("")
    public ResponseEntity<List<Employee>> findAll(){
        try {
            List<Employee> list = employeeService.findAll();
            return ResponseEntity.ok(list);
        }catch(Exception e){
            throw new ApiRequestException("Không thể get dữ liệu từ db");
        }
    }
    @DeleteMapping("/delete/{id}")
    public void deleteEmployee(@PathVariable int id){
        try {
            employeeService.deleteEmployee(id);
        }catch(Exception e){
            throw new ApiRequestException("Không tìm thấy id ");
        }
    }
}

