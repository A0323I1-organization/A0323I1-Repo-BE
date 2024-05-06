package a0323i1_cinema_professtional_be.repository.customer;

import a0323i1_cinema_professtional_be.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface CustomerRepository extends JpaRepository<Customer,Integer> {
    @Query(value = "SELECT * FROM Customer WHERE customer_account_id = ?1", nativeQuery = true)
    List<Customer> findCustomerByAccountId(Integer accountId);
}
