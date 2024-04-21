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

import java.util.ArrayList;
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
                                                  @RequestParam(required = false, defaultValue = "") String phone,
                                                  @RequestParam(required=false,defaultValue = "employeeId") String sort) {
        Sort sort1 = Sort.by(Sort.Direction.ASC, sort);
        Pageable pageableWithSort = PageRequest.of(pageable.getPageNumber(), pageable.getPageSize(), sort1);
        Page<Employee> list = employeeService.findAll("%" + fullname + "%", "%" + phone + "%", pageableWithSort);
        System.out.println(list);
        return new ResponseEntity<Page<Employee>>(list, HttpStatus.OK);
    }

    @DeleteMapping("/{ids}")
    public ResponseEntity<ApiResponse> deleteById(@PathVariable("ids") String ids) {
        String[] number = ids.split(",");
        List<String> result = new ArrayList<>();
        String mes = null;
        for (int i = 0; i < number.length; i++) {
            if (Integer.parseInt(number[i]) <= 0) {
                return new ResponseEntity<>(new ApiResponse("Invalid id", false), HttpStatus.BAD_REQUEST);
            } else {
                employeeService.deleteEmployee(Integer.parseInt(number[i]));
                result.add(number[i]);
            }
        }
        if (!result.isEmpty()) {
            mes="Employee with ID " + ids + " has been deleted successfully.";
        }
        return new ResponseEntity<>(new ApiResponse(mes, true), HttpStatus.OK);
    }
}

