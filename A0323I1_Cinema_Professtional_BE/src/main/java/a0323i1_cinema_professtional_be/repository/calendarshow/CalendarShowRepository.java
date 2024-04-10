package a0323i1_cinema_professtional_be.repository.calendarshow;

import a0323i1_cinema_professtional_be.dto.calendarshow.CalendarShowDTO;
import a0323i1_cinema_professtional_be.entity.CalendarShow;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CalendarShowRepository extends JpaRepository<CalendarShow, Integer> {

    @Query("select cs.movie.movieName as movieName, cs.movie.movieId as movieId, cs.movie.movieActor as movieActor" +
            ",cs.movie.movieDetail as movieDetail, cs.movie.movieDuration as movieDuration, cs.movie.movieStartDay as movieStartDay" +
            ",cs.movie.movieManufacturer as movieManufacturer, cs.movie.movieDirector as movieDirector, cs.movie.movieTrailer as movieTrailer"+
            ",cs.movie.movieImage as movieImage, cs.showTime.showTimeId as showTimeId, cs.showTime.movieTime as movieTime, cs.showTime.showDate as showDate"+
            " from CalendarShow as cs where cs.movie.movieId= :id")
    List<CalendarShowDTO> findAllCalendarShowByMovieId(@Param("id") int id);


    @Query(value = "SELECT * FROM calendar_show WHERE calendar_show_id = :id", nativeQuery = true)
    CalendarShow getCalendarShowById(@Param("id") int id);
}
