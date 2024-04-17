package a0323i1_cinema_professtional_be.service.seat;

import a0323i1_cinema_professtional_be.dto.Seat.AllSeatDTO;

import java.util.List;

public interface SeatService {
    List<AllSeatDTO> findAllSeatByCalendarShow(String date, String time, String movieId);

    void bookSeat(Boolean checked, int seatId);
}
