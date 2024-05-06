package a0323i1_cinema_professtional_be.service.customer;

import a0323i1_cinema_professtional_be.entity.Customer;
import a0323i1_cinema_professtional_be.repository.customer.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService{
    @Autowired
    private CustomerRepository customerRepository;
    @Override
    public Customer findCustomerByAccountId(Integer accountId) {
        return (Customer) customerRepository.findCustomerByAccountId(accountId);
    }
}
