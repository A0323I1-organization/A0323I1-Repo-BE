package a0323i1_cinema_professtional_be.service.seat;

import a0323i1_cinema_professtional_be.dto.Seat.AllSeatDTO;
import a0323i1_cinema_professtional_be.dto.Seat.SeatDTO;

import java.util.List;

public interface SeatService {
    List<AllSeatDTO> findAllSeatByCalendarShow(String date, String time, String movieId);
    List<SeatDTO> getSeatById(List<Integer> seatId);

    void bookSeat(Boolean checked, int seatId);


}
