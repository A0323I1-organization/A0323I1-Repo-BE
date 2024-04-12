package a0323i1_cinema_professtional_be.service.ticket;

import a0323i1_cinema_professtional_be.dto.TicketProjection;
import a0323i1_cinema_professtional_be.entity.Ticket;
import a0323i1_cinema_professtional_be.repository.ticket.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TicketServiceImpl implements TicketService{
    @Autowired
    private TicketRepository ticketRepository;
    @Override
    public List<TicketProjection> finAllTicket() {
        return ticketRepository.findAllTicket();
    }

    @Override
    public List<TicketProjection> searchTicketList(String keyword) {
        return ticketRepository.searchTicketList(keyword);
    }

    @Override
    public TicketProjection findById(int id) {
        return ticketRepository.findById(id);
    }

    @Override
    public Page<TicketProjection> findAllTicketPages(int currentPage) {
        Pageable pageable = PageRequest.of(currentPage,5);
        List<TicketProjection> ticketProjections = ticketRepository.findAllTicket();
        Page<TicketProjection> ticketPages = toPage(ticketProjections,pageable);
        return ticketPages;
    }

    private Page toPage(List<TicketProjection> ticketList, Pageable pageable){
        if (pageable.getOffset() >= ticketList.size()){
            return Page.empty();
        }
        int startIndex =(int) pageable.getOffset();
        int endIndex = ((pageable.getOffset() + pageable.getPageSize()) > ticketList.size()) ?
                        ticketList.size() : (int) (pageable.getOffset() + pageable.getPageSize());
        List<TicketProjection> subList = ticketList.subList(startIndex,endIndex);
        return new PageImpl(subList,pageable,ticketList.size());
    }
}
