package a0323i1_cinema_professtional_be.repository.showtime;

import a0323i1_cinema_professtional_be.dto.showtime.ShowDateDTO;
import a0323i1_cinema_professtional_be.dto.showtime.ShowMovieTimeDTO;
import a0323i1_cinema_professtional_be.entity.ShowTime;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

public interface ShowTimeRepository extends JpaRepository<ShowTime,Integer> {

    @Query("select distinct st.showDate as showDate from ShowTime as st" +
            " join CalendarShow cs on st.showTimeId = cs.showTime.showTimeId " +
            " where st.showDate >= (current_date()) and st.showDate <= (current_date() + 07) and cs.movie.movieId= :id" +
            " ORDER BY st.showDate ASC ")
    List<ShowDateDTO> findAllShowDateByMovie(@Param("id") int id);

    @Query("SELECT st.movieTime AS movieTime, st.showTimeId AS showTimeId " +
            "FROM ShowTime AS st " +
            "JOIN CalendarShow cs ON st.showTimeId = cs.showTime.showTimeId " +
            "WHERE cs.movie.movieId =:movieId and (st.showDate = :date AND st.showDate = current_date() AND st.movieTime >= current_time()) " +
            "OR (cs.movie.movieId =:movieId and st.showDate = :date) " +
            "ORDER BY st.movieTime ASC")
    List<ShowMovieTimeDTO> findAllShowTime(@Param("date") Date date, @Param("movieId") int movieId);



}
