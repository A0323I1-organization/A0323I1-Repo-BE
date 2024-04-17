package a0323i1_cinema_professtional_be.dto.ticket;

import java.sql.Time;
import java.util.Date;
import java.util.List;

public interface TicketDetail {
    String getFullname();

    String getEmail();

    String getPhone();

    List<String> getSeatName();

    Date getShowDate();
    Time getMovieTime();

    String getMovieName();

}
