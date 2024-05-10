package a0323i1_cinema_professtional_be.service.customer;

import a0323i1_cinema_professtional_be.entity.Customer;
import a0323i1_cinema_professtional_be.repository.customer.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService{
    private final CustomerRepository customerRepository;
    @Override
    public Customer getCustomerById(int id) {
        return customerRepository.getCustomerById(id);
    }
}
