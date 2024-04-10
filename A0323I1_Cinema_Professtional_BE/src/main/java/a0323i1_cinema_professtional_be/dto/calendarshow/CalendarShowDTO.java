package a0323i1_cinema_professtional_be.dto.calendarshow;

import a0323i1_cinema_professtional_be.entity.CalendarShow;
import a0323i1_cinema_professtional_be.entity.Movie;
import a0323i1_cinema_professtional_be.entity.ShowTime;
import lombok.Data;

import java.sql.Time;
import java.util.Date;
import java.util.List;

public interface CalendarShowDTO {

    String getMovieName();

    Integer getMovieId();

    Date getMovieStartDay();

    String getMovieActor();

    String getMovieManufacturer();

    String getMovieDirector();

    Integer getMovieDuration();

    String getMovieTrailer();

    String getMovieImage();

    String getMovieDetail();

    Integer getShowTimeId();

    Date getShowDate();

    Time getMovieTime();

}

