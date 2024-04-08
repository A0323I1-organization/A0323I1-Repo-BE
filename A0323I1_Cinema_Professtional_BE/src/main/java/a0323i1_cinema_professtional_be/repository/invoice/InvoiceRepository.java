package a0323i1_cinema_professtional_be.repository.invoice;

import a0323i1_cinema_professtional_be.entity.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InvoiceRepository extends JpaRepository<Invoice,Integer> {
}
