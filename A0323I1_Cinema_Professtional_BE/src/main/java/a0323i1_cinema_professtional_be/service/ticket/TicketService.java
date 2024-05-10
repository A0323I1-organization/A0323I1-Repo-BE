package a0323i1_cinema_professtional_be.service.ticket;


import a0323i1_cinema_professtional_be.dto.ticket.TicketDetailDTO;

public interface TicketService {

    void createTicketService(int invoiceId, String seatId);

    TicketDetailDTO getTicket(int invoiceId);




}
