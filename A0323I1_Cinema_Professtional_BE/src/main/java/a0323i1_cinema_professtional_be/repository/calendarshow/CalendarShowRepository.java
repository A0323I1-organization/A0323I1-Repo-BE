package a0323i1_cinema_professtional_be.repository.calendarshow;

import a0323i1_cinema_professtional_be.entity.CalendarShow;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CalendarShowRepository extends JpaRepository<CalendarShow,Integer> {
    @Query(value = "SELECT " +
            "show_time.show_date, " +
            "show_time.movie_time, " +
            "room.room_name " +
            "FROM calendar_show " +
            "INNER JOIN show_time ON calendar_show.show_time_id = show_time.show_time_id " +
            "INNER JOIN room ON calendar_show.room_id = room.room_id " +
            "WHERE calendar_show.movie_id = :id AND " +
            "show_time.show_date BETWEEN CURDATE() AND DATE_ADD(CURDATE(), INTERVAL 7 DAY)", nativeQuery = true)
    List<CalendarShow> getCalendarShowNext7Day(@Param("id") int id);

}
