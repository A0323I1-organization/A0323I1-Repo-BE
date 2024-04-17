package a0323i1_cinema_professtional_be.service.invoice;

import a0323i1_cinema_professtional_be.entity.Invoice;
import a0323i1_cinema_professtional_be.repository.invoice.InvoiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

/**
 * @author LongNHB
 */

@Service
public class InvoiceServiceImpl implements InvoiceService{
    @Autowired
    private InvoiceRepository invoiceRepository;

    /**
     * this method use to create invoice
     * @param dayPay
     * @param customerId
     * @param employeeId
     */
    @Override
    public void createInvoice(LocalDateTime dayPay, int customerId, int employeeId) {
     invoiceRepository.createInvoice(dayPay,customerId,employeeId);

    }

    /**
     * this method use toi get invoice by customer id and day payment
     * @param dayPay
     * @param customerId
     * @return invoice
     */
    @Override
    public Invoice getInvoiceByCustomerId(LocalDateTime dayPay, int customerId) {
        return invoiceRepository.getInvoiceByCustomerId(dayPay, customerId);
    }
}
