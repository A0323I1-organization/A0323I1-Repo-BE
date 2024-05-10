package a0323i1_cinema_professtional_be.repository.customer;

import a0323i1_cinema_professtional_be.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface CustomerRepository extends JpaRepository<Customer,Integer> {
    @Query(value = "SELECT * FROM customer where customer_id = :customerId", nativeQuery = true)
    Customer getCustomerById(@Param("customerId") int customerId);
}
