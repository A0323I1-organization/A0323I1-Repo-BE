package a0323i1_cinema_professtional_be.controller;

import a0323i1_cinema_professtional_be.entity.Ticket;
import a0323i1_cinema_professtional_be.service.ticket.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tickets")
public class TicketController {
    @Autowired
    private  TicketService ticketService;

    @GetMapping("/customer/{id}/")
    public ResponseEntity<List<Ticket>> getAllBookedTickets(@PathVariable("id") int id) {
        List<Ticket> tickets = ticketService.getBookedTicketsByCustomerId(id);
        return new ResponseEntity<>(tickets, HttpStatus.OK);
    }

}

