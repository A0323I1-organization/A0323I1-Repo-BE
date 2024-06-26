package a0323i1_cinema_professtional_be.dto;

import java.sql.Time;
import java.util.Date;

public interface TicketProjection {
    Integer getTicketId();
    Integer getCustomerId();
    String getFullName();
    String getIdCard();
    String getPhoneNumber();
    String getMovieName();
    Date getShowDate();
    Time getMovieTime();
    String getSeatName();
    String getSeatPrice();
    Date getDatePayment();
    String getRoomName();

}
