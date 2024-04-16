package a0323i1_cinema_professtional_be.service.ticket;

import a0323i1_cinema_professtional_be.dto.ticket.TicketDetail;

import java.util.List;

public interface TicketService {
    void createTicket(int invoiceId, List<Integer> seatId);

    List<TicketDetail> getTicket(int invoiceId, List<Integer> seatId);
}
