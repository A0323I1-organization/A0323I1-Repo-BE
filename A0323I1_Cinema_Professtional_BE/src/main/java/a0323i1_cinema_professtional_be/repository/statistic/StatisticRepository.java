package a0323i1_cinema_professtional_be.repository.statistic;

import a0323i1_cinema_professtional_be.dto.statistics.MovieSales;
import a0323i1_cinema_professtional_be.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface StatisticRepository extends JpaRepository<Movie,Integer> {
    @Query("SELECT m.movieName as movieName, COUNT(t.ticketId) AS countTicket, SUM(ts.typeSeatPrice) AS totalPriceTicket FROM Movie m JOIN CalendarShow cs ON m.movieId = cs.movie.movieId JOIN Seat s ON cs.calendarShowId = s.calendarShow.calendarShowId JOIN TypeSeat ts ON s.typeSeat.typeSeatId = ts.typeSeatId JOIN Ticket t ON s.seatId = t.seat.seatId GROUP BY m.movieId")
    List<MovieSales> getMovieSales();
}
