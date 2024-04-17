package a0323i1_cinema_professtional_be.controller;

import a0323i1_cinema_professtional_be.entity.Movie;
import a0323i1_cinema_professtional_be.service.movie.MovieService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("api/movies")
public class MovieController {

    @Autowired
    private MovieService movieService;

    @GetMapping("/{id}")
    public ResponseEntity<Movie> getMovieById(@PathVariable("id") int id) {
        Movie movie = movieService.getMovieByID(id);
        if (movie != null) {
            return new ResponseEntity<>(movie, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/showing")

    public ResponseEntity<List<Movie>> viewShowingMovie(){
        List<Movie> movieList=movieService.getShowingMovie();
        if(movieList!=null){
            return new ResponseEntity<>(movieList, HttpStatus.OK);
        } else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        }
    }

}
