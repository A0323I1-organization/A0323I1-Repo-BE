package a0323i1_cinema_professtional_be.repository.ticket;


import a0323i1_cinema_professtional_be.dto.ticket.TicketDetail;

import a0323i1_cinema_professtional_be.dto.ticket.TicketProjection;

import a0323i1_cinema_professtional_be.entity.Ticket;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;

@Repository
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

    @Query(value = "select t.ticket_id as ticketId ,c.customer_id as customerId,c.fullname as fullName,c.id_card as idCard,c.phone as phoneNumber,m.movie_name as movieName, st.show_date as showDate,st.movie_time as movieTime,s.seat_name as seatName,ts.type_seat_price as seatPrice,i.data_payment as datePayment, r.room_name as roomName from ticket t " +
            " join invoice i on t.invoice_id = i.invoice_id " +
            " join customer c on c.customer_id = i.customer_id " +
            " join seat s on s.seat_id = t.seat_id " +
            " join type_seat ts on s.type_seat_id = ts.type_seat_id" +
            " join calendar_show cs  on cs.calendar_show_id = s.calendar_show_id " +
            " join room r on r.room_id = cs.room_id "+
            " join show_time st on st.show_time_id = cs.show_time_id " +
            " join movie m on m.movie_id = cs.movie_id",nativeQuery = true)
    List<TicketProjection> findAllTicket();
    @Query(value = "select t.ticket_id as ticketId ,c.customer_id as customerId,c.fullname as fullName,c.id_card as idCard,c.phone as phoneNumber,m.movie_name as movieName, st.show_date as showDate,st.movie_time as movieTime,s.seat_name as seatName,ts.type_seat_price as seatPrice,i.data_payment as datePayment, r.room_name as roomName from ticket t " +
            " join invoice i on t.invoice_id = i.invoice_id " +
            " join customer c on c.customer_id = i.customer_id " +
            " join seat s on s.seat_id = t.seat_id " +
            " join type_seat ts on s.type_seat_id = ts.type_seat_id" +
            " join calendar_show cs  on cs.calendar_show_id = s.calendar_show_id " +
            " join room r on r.room_id = cs.room_id "+
            " join show_time st on st.show_time_id = cs.show_time_id " +
            " join movie m on m.movie_id = cs.movie_id",nativeQuery = true)
    Page<TicketProjection> findAllTicketPages(Pageable pageable);


    @Query(value = "select t.ticket_id as ticketId ,c.customer_id as customerId,c.fullname as fullName,c.id_card as idCard,c.phone as phoneNumber,m.movie_name as movieName, st.show_date as showDate,st.movie_time as movieTime,s.seat_name as seatName,ts.type_seat_price as seatPrice,i.data_payment as datePayment, r.room_name as roomName from ticket t " +
            " join invoice i on t.invoice_id = i.invoice_id " +
            " join customer c on c.customer_id = i.customer_id " +
            " join seat s on s.seat_id = t.seat_id " +
            " join type_seat ts on s.type_seat_id = ts.type_seat_id" +
            " join calendar_show cs  on cs.calendar_show_id = s.calendar_show_id " +
            " join room r on r.room_id = cs.room_id "+
            " join show_time st on st.show_time_id = cs.show_time_id " +
            " join movie m on m.movie_id = cs.movie_id " +
            " where t.ticket_id = ?1  or c.customer_id =?1 or c.phone like ?1% or c.id_card like ?1%",nativeQuery = true)
    List<TicketProjection> searchTicketList(String keyword);

    @Query(value = "select t.ticket_id as ticketId ,c.customer_id as customerId,c.fullname as fullName,c.id_card as idCard,c.phone as phoneNumber,m.movie_name as movieName, st.show_date as showDate,st.movie_time as movieTime,s.seat_name as seatName,ts.type_seat_price as seatPrice,i.data_payment as datePayment, r.room_name as roomName from ticket t " +
            " join invoice i on t.invoice_id = i.invoice_id " +
            " join customer c on c.customer_id = i.customer_id " +
            " join seat s on s.seat_id = t.seat_id " +
            " join type_seat ts on s.type_seat_id = ts.type_seat_id" +
            " join calendar_show cs  on cs.calendar_show_id = s.calendar_show_id " +
            " join room r on r.room_id = cs.room_id "+
            " join show_time st on st.show_time_id = cs.show_time_id " +
            " join movie m on m.movie_id = cs.movie_id " +
            " where t.ticket_id = ?1",nativeQuery = true)
    TicketProjection findById(int id);

    @Query(value = "select t.ticket_id as ticketId ,c.customer_id as customerId,c.fullname as fullName,c.id_card as idCard,c.phone as phoneNumber,m.movie_name as movieName, st.show_date as showDate,st.movie_time as movieTime,s.seat_name as seatName,ts.type_seat_price as seatPrice,i.data_payment as datePayment, r.room_name as roomName from ticket t " +
            " join invoice i on t.invoice_id = i.invoice_id " +
            " join customer c on c.customer_id = i.customer_id " +
            " join seat s on s.seat_id = t.seat_id " +
            " join type_seat ts on s.type_seat_id = ts.type_seat_id " +
            " join calendar_show cs  on cs.calendar_show_id = s.calendar_show_id " +
            " join room r on r.room_id = cs.room_id " +
            " join show_time st on st.show_time_id = cs.show_time_id " +
            " join movie m on m.movie_id = cs.movie_id " +
            " where st.show_date between ?1 and ?2 ",nativeQuery = true)
    List<TicketProjection> searchForStartAndEndDates(Date startDate, Date endDate);
}
