package a0323i1_cinema_professtional_be.controller;

import a0323i1_cinema_professtional_be.entity.Customer;
import a0323i1_cinema_professtional_be.service.customer.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("api/customer")
public class CustomerController {
    @Autowired
    private CustomerService CustomerService;

        @GetMapping(".getCustomerByAccount")
        public ResponseEntity< Customer > findCustomerByAccountId(@RequestParam("accountId") Integer accountId){
            Customer customer = this.CustomerService.findCustomerByAccountId(accountId);
            return new ResponseEntity<>(customer, HttpStatus.OK);
        }
}
