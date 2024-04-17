package a0323i1_cinema_professtional_be.service.ticket;

import a0323i1_cinema_professtional_be.entity.Ticket;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TicketService {
    List<Ticket> getBookedTicketsByCustomerId( int customerId);
}
