package a0323i1_cinema_professtional_be.repository.invoice;

import a0323i1_cinema_professtional_be.entity.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.time.LocalDateTime;

public interface InvoiceRepository extends JpaRepository<Invoice,Integer> {
    @Transactional
    @Modifying
    @Query(value = "insert into invoice (date_payment,customer_id) values (:datePayment, :customerId)",
            nativeQuery = true)
    void createInvoice(@Param("datePayment") LocalDateTime datePayment, @Param("customerId") int customerId);

    @Query(value = "select * from invoice where date_payment= :datePayment and customer_id= :id", nativeQuery = true)
    Invoice getInvoiceByCustomerId(@Param("datePayment") LocalDateTime datePayment, @Param("id") int id);

    @Transactional
    @Modifying
    @Query(value = "update Invoice as i set i.employee_id = null  where i.employee_id = :id",nativeQuery = true)
    void updateInvoice(@Param("id") int id);
}
