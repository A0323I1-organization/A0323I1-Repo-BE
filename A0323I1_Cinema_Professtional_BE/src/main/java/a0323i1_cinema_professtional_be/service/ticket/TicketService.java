package a0323i1_cinema_professtional_be.service.ticket;


import a0323i1_cinema_professtional_be.dto.ticket.TicketDetail;

import a0323i1_cinema_professtional_be.dto.ticket.TicketProjection;
import org.springframework.data.domain.Page;


import java.util.List;

public interface TicketService {

    void createTicket(int invoiceId, List<Integer> seatId);

    List<TicketDetail> getTicket(int invoiceId, List<Integer> seatId);
//=======
    List<TicketProjection> finAllTicket();
    List<TicketProjection> searchTicketList(String keyword);
    TicketProjection findById(int id);
    Page<TicketProjection> findAllTicketPages(int currentPage);
    Page<TicketProjection> searchForStartAndEndDates(String startDate, String endDate, int currentPage);


}
