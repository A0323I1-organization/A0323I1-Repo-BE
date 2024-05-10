package a0323i_cinema_professtional_be.service.customer;

import a0323i_cinema_professtional_be.dto.CustomerDto;
import a0323i_cinema_professtional_be.entity.Customer;
import a0323i_cinema_professtional_be.exception.CustomerAlreadyExistsException;
import a0323i_cinema_professtional_be.exception.CustomerNotFoundException;
import a0323i_cinema_professtional_be.repository.customer.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepository customerRepository;
    private PasswordEncoder passwordEncoder;

    @Override
    public Customer save(CustomerDto customerDto){
        Customer customer = new Customer(customerDto.getEmail(), passwordEncoder.encode(customerDto.getPassword()), customerDto.getFullname(), customerDto.getAddress(), customerDto.getBirthday(), customerDto.getPhone(), customerDto.getGender(), customerDto.getIdCard());
        return customerRepository.save(customer);
    }


    @Override
    public UserDetailsService userDetailsService() {
        return null;
    }

    @Override
    public Customer findCustomerByAccountId(Integer accountId) {
        return customerRepository.findCustomerByAccountId(accountId);
    }

    @Override
    public Customer addCustomer(Customer customer) {
        if (customerAlreadyExists(customer.getEmail())) {
            throw new CustomerAlreadyExistsException(customer.getEmail() + "Already exists!");
        }
        return customerRepository.save(customer);
    }

    @Override
    public List< Customer > getCustomers() {
        return customerRepository.findAll();
    }

    @Override
    public Customer updateCustomer(Customer customer, int id) {
        return customerRepository.findById(id).map(st -> {
            st.setFullname(customer.getFullname());
            st.setBirthday(customer.getBirthday());
            st.setEmail(customer.getEmail());
            st.setIdCard(customer.getIdCard());
            st.setGender(customer.isGender());
            st.setPhone(customer.getPhone());
            st.setAddress(customer.getAddress());
            return customerRepository.save(st);
        }).orElseThrow(() -> new CustomerNotFoundException("Sorry, this customer could not be found !"));
    }

    @Override
    public Customer getCustomerById(int id) {
        return customerRepository.findById(id).orElseThrow(() -> new CustomerNotFoundException("Sorry, no customer found with the Id :" + id));
    }

    @Override
    public void deleteCustomer(int id) {
        if (!customerRepository.existsById(id)) {
            throw new CustomerNotFoundException("Sorry, customer not found!");
        }
        customerRepository.deleteById(id);
    }

    private boolean customerAlreadyExists(String email) {
        return Objects.isNull(customerRepository.findByEmail(email));
    }

}
