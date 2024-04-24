package a0323i1_cinema_professtional_be.controller;

import a0323i1_cinema_professtional_be.entity.Employee;
import a0323i1_cinema_professtional_be.service.employee.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@CrossOrigin("http://localhost:3000/create")
@RequestMapping("/api/employee")
@RestController
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @PostMapping
    public ResponseEntity<?> createEmployee(@RequestBody Employee employee) {
        employeeService.create(employee.getAddress(), employee.getBirthday(), employee.isGender(), employee.getFullname(),
                employee.getIdCard(), employee.getEmail(), employee.getPhone(),
                employee.getEmployeeImage(), employee.getAccount().getAccountId());
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateEmployee(@RequestBody Employee employee, @PathVariable int id) {
        if (employee == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        employeeService.update( employee.getAddress(), employee.getBirthday(),employee.isGender(),employee.getFullname(),employee.getIdCard(),employee.getEmail(),
                employee.getPhone(),employee.getEmployeeImage(),employee.getAccount().getAccountId(),id);
        return new ResponseEntity<>("Update Success", HttpStatus.OK);
    }
}
