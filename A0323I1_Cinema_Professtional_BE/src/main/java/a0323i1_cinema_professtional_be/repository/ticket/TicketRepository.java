package a0323i1_cinema_professtional_be.repository.ticket;

import a0323i1_cinema_professtional_be.entity.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TicketRepository extends JpaRepository<Ticket,Integer> {


}
