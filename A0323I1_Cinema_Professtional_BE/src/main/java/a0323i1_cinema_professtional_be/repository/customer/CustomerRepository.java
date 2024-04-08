package a0323i1_cinema_professtional_be.repository.customer;

import a0323i1_cinema_professtional_be.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer,Integer> {
}
