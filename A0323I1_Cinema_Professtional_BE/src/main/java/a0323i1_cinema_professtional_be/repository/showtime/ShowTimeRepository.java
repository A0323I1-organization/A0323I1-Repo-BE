package a0323i1_cinema_professtional_be.repository.showtime;

import a0323i1_cinema_professtional_be.dto.showtime.ShowDateDTO;
import a0323i1_cinema_professtional_be.dto.showtime.ShowMovieTimeDTO;
import a0323i1_cinema_professtional_be.entity.ShowTime;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Date;
import java.util.List;

public interface ShowTimeRepository extends JpaRepository<ShowTime,Integer> {

    @Query("select st.showDate as showDate, st.showTimeId as showTimeId from ShowTime as st" +
            " join CalendarShow cs on st.showTimeId = cs.showTime.showTimeId " +
            " where st.showDate >= current_date() + INTERVAL (7)  and cs.movie.movieId= :id" +
            " ORDER BY st.showDate ASC ")
    List<ShowDateDTO> findAllShowDateByMovie(@Param("id") int id);

    @Query("select st.movieTime as movieTime, st.showTimeId as showTimeId from ShowTime as st " +
            " join CalendarShow cs on  st.showTimeId = cs.showTime.showTimeId" +
            " where st.showDate = :date and st.movieTime >= current_time()" +
            " ORDER BY st.movieTime ASC")
    List<ShowMovieTimeDTO> findAllShowTime(@Param("date") Date date);



}
