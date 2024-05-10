package a0323i_cinema_professtional_be.security;

import a0323i_cinema_professtional_be.entity.Customer;
import a0323i_cinema_professtional_be.repository.customer.CustomerRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class CustomUserDetailsService implements UserDetailsService {
    private CustomerRepository customerRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Customer customer = customerRepository.findByEmail(username);
        if (customer == null){
            throw new UsernameNotFoundException("User not found !");
        }
        return new CustomUserDetail(customer);
    }
}
