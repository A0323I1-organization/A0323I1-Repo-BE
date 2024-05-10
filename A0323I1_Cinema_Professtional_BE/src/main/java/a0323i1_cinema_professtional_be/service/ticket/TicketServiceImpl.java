package a0323i1_cinema_professtional_be.service.ticket;


import a0323i1_cinema_professtional_be.dto.ticket.TicketDetailDTO;
import a0323i1_cinema_professtional_be.repository.ticket.TicketRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * @author LongNHB
 */


@Service
@RequiredArgsConstructor
public class TicketServiceImpl implements TicketService {

    private final TicketRepository ticketRepository;


    /**
     * this method use to create ticket
     *
     * @param invoiceId
     * @param seatIds
     */
    @Override
    public void createTicketService(int invoiceId, String seatIds) {
            ticketRepository.createTicket(invoiceId, seatIds);
    }

    /**
     * this method use to get ticke by invoice and seat id
     *
     * @param invoiceId
     * @return list ticket
     */
    @Override
    public TicketDetailDTO getTicket(int invoiceId) {
            TicketDetailDTO tickets = ticketRepository.getTicketDetail(invoiceId);
        return tickets;
    }
}
