package a0323i1_cinema_professtional_be.service.calendarshow;

import a0323i1_cinema_professtional_be.entity.CalendarShow;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CalendarShowService {
    List<CalendarShow> getCalendarShowNext7Day(@Param("id") int id);

}
