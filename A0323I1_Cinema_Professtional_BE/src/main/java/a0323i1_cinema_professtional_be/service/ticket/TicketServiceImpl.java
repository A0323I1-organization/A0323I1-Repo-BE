package a0323i1_cinema_professtional_be.service.ticket;

import a0323i1_cinema_professtional_be.dto.ticket.TicketDetail;
import a0323i1_cinema_professtional_be.repository.ticket.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author LongNHB
 */
@Service
public class TicketServiceImpl implements TicketService{
    @Autowired
    private TicketRepository ticketRepository;

    /**
     * this method use to create ticke
     * @param invoiceId
     * @param seatId
     */
    @Override
    public void createTicket(int invoiceId, List<Integer> seatId) {
        for (int i = 0; i < seatId.size(); i++) {
            ticketRepository.createTicket(invoiceId,seatId.get(i));
        }
    }

    /**
     * this method use to get ticke by invoice and seat id
     * @param invoiceId
     * @param seatId
     * @return list ticket
     */
    @Override
    public List<TicketDetail> getTicket(int invoiceId, List<Integer> seatId) {
        List<TicketDetail> list = new ArrayList<>();
        for (int i = 0; i < seatId.size(); i++) {
            List<TicketDetail> tickets = ticketRepository.getTicket(invoiceId, seatId.get(i));
            list.addAll(tickets);
        }
        return list;
    }
}
