package a0323i1_cinema_professtional_be.service.invoice;

import a0323i1_cinema_professtional_be.entity.Invoice;

import java.time.LocalDateTime;

public interface InvoiceService {
    void createInvoice(LocalDateTime dayPay, int customerId);

    Invoice getInvoiceByCustomerId(LocalDateTime dayPay, int customerId);
    void updateInvoice(int id);
}
