package a0323i_cinema_professtional_be.repository.customer;

import a0323i_cinema_professtional_be.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface CustomerRepository extends JpaRepository<Customer,Integer> {
    Customer findByEmail(String email);
    @Query(value = "SELECT * FROM customer WHERE customer_account_id =?1", nativeQuery = true)
    Customer findCustomerByAccountId(Integer accountId);}
