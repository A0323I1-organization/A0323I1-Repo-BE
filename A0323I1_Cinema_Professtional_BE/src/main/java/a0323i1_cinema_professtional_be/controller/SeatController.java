package a0323i1_cinema_professtional_be.controller;

import a0323i1_cinema_professtional_be.dto.Seat.AllSeatDTO;
import a0323i1_cinema_professtional_be.dto.Seat.SeatDTO;
import a0323i1_cinema_professtional_be.service.calendarshow.CalendarShowService;
import a0323i1_cinema_professtional_be.service.seat.SeatService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.util.List;

/**
 * @author LongNHB
 */
@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api")
@RequiredArgsConstructor
public class SeatController {

    private final SeatService seatService;

    private final CalendarShowService calendarShowService;

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
     * @return  HttpStatus.OK if success
     */
    @PostMapping("/book-seat/{seatId}")
    public ResponseEntity<Boolean> bookSeat(@PathVariable("seatId") List<Integer> seatId) {

        for (Integer id : seatId) {
            seatService.bookSeat(true, id);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/get-seat-by-id")
    public ResponseEntity<List<SeatDTO>> getSeatById ( @RequestParam("listId") String encodedListId) {
        String listIdString = URLDecoder.decode(encodedListId, StandardCharsets.UTF_8);

        String cleanedString = listIdString.replaceAll("[\\[\\]\" ]", "");

        String[] stringArray = cleanedString.split(",");
        Integer[] integerArray = new Integer[stringArray.length];
        for (int i = 0; i < stringArray.length; i++) {
            integerArray[i] = Integer.parseInt(stringArray[i].trim());
        }

          List<SeatDTO> list = seatService.getSeatById(List.of(integerArray));
        if (list != null) {
            return new ResponseEntity<>(list, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
