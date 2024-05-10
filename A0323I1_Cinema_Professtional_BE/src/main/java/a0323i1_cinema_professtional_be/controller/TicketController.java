package a0323i1_cinema_professtional_be.controller;

import a0323i1_cinema_professtional_be.dto.ticket.TicketDetailDTO;
import a0323i1_cinema_professtional_be.entity.Invoice;
import a0323i1_cinema_professtional_be.service.invoice.InvoiceService;
import a0323i1_cinema_professtional_be.service.ticket.TicketService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:3000")
@RequiredArgsConstructor
public class TicketController {

    private final TicketService ticketService;

    private final InvoiceService invoiceService;


    @GetMapping("/ticket/{vnp_PayDate}")
    public ResponseEntity<TicketDetailDTO> createTicket(@PathVariable("vnp_PayDate") String date) {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
        LocalDateTime dateTime = LocalDateTime.parse(date, formatter);
        dateTime = dateTime.withSecond(0);
        Invoice invoice = invoiceService.getInvoiceByCustomerId(dateTime, 1);

       TicketDetailDTO ticket= ticketService.getTicket(invoice.getInvoiceId());
       if (ticket != null) {
           return new ResponseEntity<>(ticket, HttpStatus.OK);

       } else {
           return new ResponseEntity<>(HttpStatus.NO_CONTENT);
       }
    }

}
