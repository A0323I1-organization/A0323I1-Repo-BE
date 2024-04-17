package a0323i1_cinema_professtional_be.controller;

import a0323i1_cinema_professtional_be.dto.Seat.AllSeatDTO;
import a0323i1_cinema_professtional_be.service.calendarshow.CalendarShowService;
import a0323i1_cinema_professtional_be.service.seat.SeatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpCookie;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * @author LongNHB
 */
@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/")
public class SeatController {
    @Autowired
    private SeatService seatService;
    @Autowired
    private CalendarShowService calendarShowService;

    /**
     *this method ues to get all seat by date, time and movieId
     * @param date: dd/MM/yyyy
     * @param time: HH:mm:ss
     * @param movieId: int
     * @return list of seat
     */
    @GetMapping("/seat/{date}/{time}/{movieId}")
    public ResponseEntity<List<AllSeatDTO>> findAllSeatByCalendarShowId(
            @PathVariable("date") String date,
            @PathVariable("time") String time,
            @PathVariable("movieId") String movieId) {
        List<AllSeatDTO> seats = seatService.findAllSeatByCalendarShow(date, time, movieId);
        if (seats.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(seats, HttpStatus.OK);
        }
    }

    /**
     * this method use to set checkSeat true
     * @param seatId
     * @param response
     * @return  HttpStatus.OK if success
     */
    @PostMapping("/book-seat/{seatId}")
    public ResponseEntity<Boolean> bookSeat(@PathVariable("seatId") List<Integer> seatId, HttpServletResponse response) {
        String seatIdString = seatId.stream().map(Objects::toString).collect(Collectors.joining(","));
        Cookie cookie = new Cookie("listSeat", seatIdString);
        cookie.setMaxAge(60 * 60 * 5);
        cookie.setPath("/");
        response.addCookie(cookie);

        for (Integer id : seatId) {
            seatService.bookSeat(true, id);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
