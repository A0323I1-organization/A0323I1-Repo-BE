package a0323i1_cinema_professtional_be.controller;

import a0323i1_cinema_professtional_be.entity.Employee;
import a0323i1_cinema_professtional_be.service.employee.EmployeeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api/employee")
@RestController
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;
    @PostMapping
    public ResponseEntity<?> createEmployee(@RequestBody Employee employee){
        employeeService.create(employee);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @PutMapping("/{id}")
    public ResponseEntity<?> updateEmployee(@PathVariable int id,@RequestBody Employee employee){

        if(employee == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        employeeService.update(employee);
        return new ResponseEntity<>("Update Success",HttpStatus.OK);
    }
}
