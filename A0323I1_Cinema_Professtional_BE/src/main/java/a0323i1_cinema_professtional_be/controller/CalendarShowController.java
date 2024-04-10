package a0323i1_cinema_professtional_be.controller;

import a0323i1_cinema_professtional_be.dto.calendarshow.CalendarShowDTO;
import a0323i1_cinema_professtional_be.service.calendarshow.CalendarShowService;
import a0323i1_cinema_professtional_be.service.movie.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class CalendarShowController {
    @Autowired
    private CalendarShowService calendarShowService;
    @Autowired
    MovieService movieService;
    @GetMapping("/booking/{MovieId}")
    public ResponseEntity<List<CalendarShowDTO>> getCalendarShow(@PathVariable("MovieId") int movieId) {
        List<CalendarShowDTO> calendarShows = calendarShowService.findAllCalendarShowByMovie(movieId);
        if (calendarShows.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(calendarShows, HttpStatus.OK);
        }
    }





}
