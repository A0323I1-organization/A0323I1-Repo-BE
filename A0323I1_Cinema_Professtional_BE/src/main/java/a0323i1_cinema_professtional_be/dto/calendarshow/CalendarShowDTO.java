package a0323i1_cinema_professtional_be.dto.calendarshow;

import a0323i1_cinema_professtional_be.entity.CalendarShow;
import a0323i1_cinema_professtional_be.entity.Movie;
import a0323i1_cinema_professtional_be.entity.ShowTime;
import lombok.Data;

import java.sql.Time;
import java.util.Date;
import java.util.List;

public interface CalendarShowDTO {

    Integer getShowTimeId();
    Integer getCalendarShowId();
    Integer getMovieId();

}

