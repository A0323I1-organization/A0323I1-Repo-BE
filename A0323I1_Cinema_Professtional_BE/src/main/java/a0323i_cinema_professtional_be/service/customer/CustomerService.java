package a0323i_cinema_professtional_be.service.customer;

import a0323i_cinema_professtional_be.dto.CustomerDto;
import a0323i_cinema_professtional_be.entity.Customer;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface CustomerService {
    UserDetailsService userDetailsService();
    Customer findCustomerByAccountId(Integer accountId);
    Customer addCustomer(Customer customer);
    List<Customer> getCustomers();
    Customer updateCustomer(Customer customer, int id);
    Customer getCustomerById(int id);
    void deleteCustomer(int id);
    Customer save(CustomerDto customerDto);

}
