package a0323i1_cinema_professtional_be.controller;



import a0323i1_cinema_professtional_be.entity.CalendarShow;
import a0323i1_cinema_professtional_be.entity.Movie;
import a0323i1_cinema_professtional_be.service.calendarshow.CalendarShowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/calendar")
public class CalendarShowController {
    @Autowired
    private CalendarShowService calendarShowService;


@GetMapping("/{id}")
public ResponseEntity<List<CalendarShow>> viewCalendarShow(@PathVariable("id") int id){
    List<CalendarShow> calendarShows=calendarShowService.getCalendarShowNext7Day(id);
    if(calendarShows!=null){
        return new ResponseEntity<>(calendarShows, HttpStatus.OK);
    } else{
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);

    }
}


}
