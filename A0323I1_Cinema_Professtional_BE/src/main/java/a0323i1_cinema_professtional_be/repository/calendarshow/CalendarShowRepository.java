package a0323i1_cinema_professtional_be.repository.calendarshow;

import a0323i1_cinema_professtional_be.dto.calendarshow.CalendarShowDTO;
import a0323i1_cinema_professtional_be.entity.CalendarShow;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.sql.Time;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public interface CalendarShowRepository extends JpaRepository<CalendarShow, Integer> {

}
