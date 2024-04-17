package a0323i1_cinema_professtional_be.controller;

import a0323i1_cinema_professtional_be.entity.Employee;
import a0323i1_cinema_professtional_be.exception.ApiResponse;
import a0323i1_cinema_professtional_be.service.employee.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.NoHandlerFoundException;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000", allowedHeaders = "**")
@RequestMapping("/api/employee")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @GetMapping("")
    public ResponseEntity<Page<Employee>> findAll(@PageableDefault(page = 0, size = 5) Pageable pageable,
                                                  @RequestParam(required = false, defaultValue = "") String fullname,
                                                  @RequestParam(required = false, defaultValue = "") String phone, @RequestParam(defaultValue = "employeeId") String sort
    ) {
        Sort sort1 = Sort.by(Sort.Direction.ASC, sort);
        Pageable pageableWithSort = PageRequest.of(pageable.getPageNumber(), pageable.getPageSize(), sort1);
        Page<Employee> list = employeeService.findAll("%" + fullname + "%", "%" + phone + "%", pageableWithSort);
        System.out.println(list);
        return new ResponseEntity<Page<Employee>>(list, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse> deleteById(@PathVariable("id") int id) {
        if (id <= 0) {
            return new ResponseEntity<>(new ApiResponse("Invalid id", false), HttpStatus.BAD_REQUEST);
        } else {
            employeeService.deleteEmployee(id);
            return new ResponseEntity<>(new ApiResponse("Employee with ID " + id + " has been deleted successfully.", true), HttpStatus.OK);
        }
    }
}

