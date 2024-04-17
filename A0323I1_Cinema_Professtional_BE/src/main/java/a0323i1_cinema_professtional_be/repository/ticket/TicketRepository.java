package a0323i1_cinema_professtional_be.repository.ticket;

import a0323i1_cinema_professtional_be.entity.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TicketRepository extends JpaRepository<Ticket,Integer> {
    @Query(nativeQuery = true,value = "SELECT " +
            "    movie.movie_name, " +
            "    invoice.date_payment, " +
            "    SUM(type_seat.price) as total_amount, " +
            "    GROUP_CONCAT(seat.name) as seat_numbers" +
            "FROM" +
            "ticket" +
            "JOIN" +
            "    invoice ON ticket.invoice_id = invoice.invoice_id" +
            "JOIN" +
            "    customer ON invoice.customer_id = customer.customer_id" +
            "JOIN" +
            "    seat ON ticket.seat_id = seat.seat_id" +
            "JOIN" +
            "    type_seat ON seat.type_seat_id = type_seat.type_seat_id" +
            "JOIN" +
            "    calendar_show ON seat.calendar_show_id = calendar_show.calendar_show_id" +
            "JOIN" +
            "    movie ON calendar_show.movie_id = movie.movie_id" +
            "WHERE" +
            "    customer.customer_id = :id " +
            "GROUP BY" +
            "    invoice.invoice_id;")
    List<Ticket> getBookedTicketsByCustomerId(@Param("id") int customerId);
}
