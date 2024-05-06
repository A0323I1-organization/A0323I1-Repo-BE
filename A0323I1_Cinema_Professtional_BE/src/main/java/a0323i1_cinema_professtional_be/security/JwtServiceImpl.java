package a0323i1_cinema_professtional_be.security;

import a0323i1_cinema_professtional_be.entity.Customer;
import a0323i1_cinema_professtional_be.entity.Employee;
import a0323i1_cinema_professtional_be.repository.employee.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class JwtServiceImpl {
    @Autowired
    private JwtUtils jwtUtils;

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private AuthenticationManager authenticationManager;

    public JwtResponse createJwtToken(LoginRequest account) throws Exception{
        String fullname = account.getUsername();
        String password = account.getPassword();

        UserDetails userDetails = loadUserByUsername(username);
        String newGeneratedToken = jwtUtils.generateToken(userDetails);

        Employee employee = employeeRepository.findAccountByUsername(fullname);
        return new JwtResponse(employee, newGeneratedToken);
    }


    @Override
    public UserDetails loadUserByUsername(String fullname) throws UsernameNotFoundException{
        Employee employee = employeeRepository.findAccountByUsername(fullname);
        if (employee != null){
            return new Customer(
                    employee.getFullname(),
                    employee.getEmail(),
                    employee.getBirthday(),
                    employee.isGender(),
                    employee.getIdCard(),
                    employee.getAddress(),
                    employee.getPhone(),
                    employee.getImage(),
                    employee.getEmployeeId(),
                    getAuthority(employee)
            );
        }else {
            throw new UsernameNotFoundException("Customer not found with fullname: " + fullname);
        }
    }

    private Set getAuthority(Employee employee){
        Set< SimpleGrantedAuthority > authorities = new HashSet<>();
        employee.getRole.forEach( role -> {
            authorities.add(new SimpleGrantedAuthority(role.getRoleName()));
        });
        return authorities;
    }

}
