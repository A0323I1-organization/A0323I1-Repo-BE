package a0323i1_cinema_professtional_be.repository.seat;

import a0323i1_cinema_professtional_be.dto.Seat.AllSeatDTO;
import a0323i1_cinema_professtional_be.entity.Seat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.sql.Time;
import java.util.Date;
import java.util.List;

public interface SeatRepository extends JpaRepository<Seat, Integer> {
    @Query(value = "select s.seatId as seatId, s.seatName as seatName, s.typeSeat.typeSeatName as typeSeatName," +
            " s.typeSeat.typeSeatPrice as typeSeatPrice, s.checkSeat as checkSeat from Seat as s " +
            " join CalendarShow as cs on cs.calendarShowId = s.calendarShow.calendarShowId" +
            " join  ShowTime as st on st.showTimeId = cs.showTime.showTimeId" +
            " where st.showDate = :date and st.movieTime= :time and cs.movie.movieId = :movieId")
    List<AllSeatDTO> findAllSeatByCalendarShow(@Param("date") Date date, @Param("time") Time time, @Param("movieId") int movieId);

    @Query(value = "select * from seat where seat_id =:id", nativeQuery = true)
    Seat getSeatById(@Param("id") int id);

    @Modifying
    @Transactional
    @Query(value = "update seat set check_seat= :checked where seat_id= :id", nativeQuery = true)
    void bookSeat(@Param("checked") boolean checked, @Param("id") int id);

}

