package a0323i1_cinema_professtional_be.service.ticket;


import a0323i1_cinema_professtional_be.dto.ticket.TicketDetail;
import a0323i1_cinema_professtional_be.repository.ticket.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author LongNHB
 */

import a0323i1_cinema_professtional_be.dto.ticket.TicketProjection;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;


@Service
public class TicketServiceImpl implements TicketService {
    @Autowired
    private TicketRepository ticketRepository;


    /**
     * this method use to create ticke
     *
     * @param invoiceId
     * @param seatId
     */
    @Override
    public void createTicket(int invoiceId, List<Integer> seatId) {
        for (int i = 0; i < seatId.size(); i++) {
            ticketRepository.createTicket(invoiceId, seatId.get(i));
        }
    }

    /**
     * this method use to get ticke by invoice and seat id
     *
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
//=======


        @Override
        public List<TicketProjection> finAllTicket () {
            return ticketRepository.findAllTicket();
        }

        @Override
        public List<TicketProjection> searchTicketList (String keyword){
            return ticketRepository.searchTicketList(keyword);
        }

        @Override
        public TicketProjection findById ( int id){

            return ticketRepository.findById(id);
        }

        @Override
        public Page<TicketProjection> findAllTicketPages ( int currentPage){
            Pageable pageable = PageRequest.of(currentPage, 5);
            List<TicketProjection> ticketProjections = ticketRepository.findAllTicket();
            Page<TicketProjection> ticketPages = toPage(ticketProjections, pageable);
            return ticketPages;
        }

    @Override
    public Page<TicketProjection> searchForStartAndEndDates(String startDate, String endDate, int currentPage) {
        Pageable pageable = PageRequest.of(currentPage,5);
        if (startDate.isEmpty() || endDate.isEmpty()){

             List<TicketProjection> ticketProjections = ticketRepository.findAllTicket();
                return toPage(ticketProjections,pageable);

        }else{
            Date start ;
            Date end ;
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            try{
                start = dateFormat.parse(startDate);
                end = dateFormat.parse(endDate);
            }catch (ParseException e){
                e.printStackTrace();
                return Page.empty();
            }
            List<TicketProjection> ticketProjections = ticketRepository.searchForStartAndEndDates(start,end);
            return toPage(ticketProjections,pageable);
        }


    }

    private Page toPage (List < TicketProjection > ticketList, Pageable pageable){
            if (pageable.getOffset() >= ticketList.size()) {
                return Page.empty();
            }
            int startIndex = (int) pageable.getOffset();
            int endIndex = ((pageable.getOffset() + pageable.getPageSize()) > ticketList.size()) ?
                    ticketList.size() : (int) (pageable.getOffset() + pageable.getPageSize());
            List<TicketProjection> subList = ticketList.subList(startIndex, endIndex);
            return new PageImpl(subList, pageable, ticketList.size());

        }
    }