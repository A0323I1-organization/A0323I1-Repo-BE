package a0323i1_cinema_professtional_be.controller;

import a0323i1_cinema_professtional_be.dto.showtime.ShowDateDTO;
import a0323i1_cinema_professtional_be.dto.showtime.ShowMovieTimeDTO;
import a0323i1_cinema_professtional_be.service.showtime.ShowTimeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author LongNHB
 */
@RestController
@RequestMapping("/api/")
@CrossOrigin(origins = "http://localhost:3000")
@RequiredArgsConstructor
public class ShowTimeController {

    private final ShowTimeService showTimeService;

    /**
     * this method use to find all show date by movie id
     * @param movieId
     * @return list of show date
     */
    @GetMapping("/find-all-show-date/{movieId}")
    public ResponseEntity<List<ShowDateDTO>> findAllShowDateByMovie(@PathVariable("movieId") int movieId) {
        List<ShowDateDTO> showDateDTOS = showTimeService.findAllShowDateByMovie(movieId);
        if (showDateDTOS.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(showDateDTOS, HttpStatus.OK);
        }
    }

    /**
     * this method use to show time by date
     * @param date
     * @return list of show time
     */
    @GetMapping("/find-all-show-time/{date}/{movieId}")
    public ResponseEntity<List<ShowMovieTimeDTO>> findAllShowTime(@PathVariable("date") String date,
                                                                  @PathVariable("movieId")int movieId) {
        List<ShowMovieTimeDTO> showMovieTimeDTOS = showTimeService.findAllShowTime(date, movieId );
        if ( showMovieTimeDTOS.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(showMovieTimeDTOS, HttpStatus.OK);
        }
    }


}
