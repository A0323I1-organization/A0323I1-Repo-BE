package a0323i1_cinema_professtional_be.repository.ticket;

import a0323i1_cinema_professtional_be.dto.TicketProjection;
import a0323i1_cinema_professtional_be.entity.Ticket;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TicketRepository extends JpaRepository<Ticket,Integer> {
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
}
