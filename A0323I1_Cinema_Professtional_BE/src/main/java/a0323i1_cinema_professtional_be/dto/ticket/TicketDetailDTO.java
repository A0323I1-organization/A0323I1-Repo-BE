package a0323i1_cinema_professtional_be.dto.ticket;

import java.sql.Time;
import java.util.Date;

public interface TicketDetailDTO {
    String getFullname();

    String getEmail();

    String getPhone();

    Date getShowDate();
    Time getMovieTime();

    String getMovieName();

}
