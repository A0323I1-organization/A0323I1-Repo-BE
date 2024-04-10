package a0323i1_cinema_professtional_be.service.calendarshow;


import a0323i1_cinema_professtional_be.dto.calendarshow.CalendarShowDTO;
import a0323i1_cinema_professtional_be.entity.CalendarShow;

import java.util.List;


public interface CalendarShowService {
    List<CalendarShowDTO> findAllCalendarShowByMovie(int id);
    CalendarShow getCalendarShowById(int id);
}
