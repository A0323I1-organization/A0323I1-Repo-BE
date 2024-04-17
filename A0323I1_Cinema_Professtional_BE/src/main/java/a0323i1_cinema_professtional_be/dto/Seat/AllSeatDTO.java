package a0323i1_cinema_professtional_be.dto.Seat;

import a0323i1_cinema_professtional_be.entity.TypeSeat;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonProperty;

public interface AllSeatDTO {
    Integer getSeatId();

    String getSeatName();

    String getTypeSeatName();

    Double getTypeSeatPrice();

    Boolean getCheckSeat();



}
