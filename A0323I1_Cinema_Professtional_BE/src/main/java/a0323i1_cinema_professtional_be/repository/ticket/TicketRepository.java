package a0323i1_cinema_professtional_be.repository.ticket;

import a0323i1_cinema_professtional_be.dto.ticket.TicketDetail;
import a0323i1_cinema_professtional_be.entity.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;


public interface TicketRepository extends JpaRepository<Ticket,Integer> {

    @Transactional
    @Modifying
    @Query(value = "insert into ticket (invoice_id, seat_id) values (:invoiceId, :seatId)", nativeQuery = true)
    void createTicket(@Param("invoiceId") int invoiceId, @Param("seatId") int seatId);


    @Query("select m.movieName as movieName , st.movieTime as movieTime, st.showDate as showDate, c.fullname as fullname," +
            " c.email as email , c.phone as phone, s.seatName as seatName from Customer as c" +
            " join Invoice as i on c.customerId = i.customer.customerId" +
            " join Ticket as t on t.invoice.invoiceId = i.invoiceId " +
            " join Seat as s on s.seatId = t.seat.seatId" +
            " join CalendarShow as cs on cs.calendarShowId = s.calendarShow.calendarShowId" +
            " join Movie as m on m.movieId = cs.movie.movieId" +
            " join ShowTime as st on st.showTimeId = cs.showTime.showTimeId" +
            " where s.seatId =:seatId and i.invoiceId = :invoiceId")
    List<TicketDetail> getTicket(@Param("invoiceId") int invoiceId, @Param("seatId") int seatId);
}
