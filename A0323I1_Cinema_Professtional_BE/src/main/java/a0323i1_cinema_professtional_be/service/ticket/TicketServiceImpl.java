package a0323i1_cinema_professtional_be.service.ticket;

import a0323i1_cinema_professtional_be.entity.Ticket;
import a0323i1_cinema_professtional_be.repository.ticket.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TicketServiceImpl implements TicketService{
    @Autowired
   TicketRepository ticketRepository;

    @Override
    public List<Ticket> getBookedTicketsByCustomerId(int customerId) {
        return ticketRepository.getBookedTicketsByCustomerId(customerId);
    }
}
