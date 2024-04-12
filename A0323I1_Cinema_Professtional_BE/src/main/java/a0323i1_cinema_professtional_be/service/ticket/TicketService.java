package a0323i1_cinema_professtional_be.service.ticket;

import a0323i1_cinema_professtional_be.dto.TicketProjection;
import a0323i1_cinema_professtional_be.entity.Ticket;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface TicketService {
    List<TicketProjection> finAllTicket();
    List<TicketProjection> searchTicketList(String keyword);
    TicketProjection findById(int id);
    Page<TicketProjection> findAllTicketPages(int currentPage);

}
