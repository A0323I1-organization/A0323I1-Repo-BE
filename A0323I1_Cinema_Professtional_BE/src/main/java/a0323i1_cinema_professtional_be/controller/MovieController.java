package a0323i1_cinema_professtional_be.controller;

import a0323i1_cinema_professtional_be.dto.MovieProjection;
import a0323i1_cinema_professtional_be.service.movie.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/movie")
public class MovieController {
    @Autowired
    private MovieService movieService;

    @GetMapping("")
    public ResponseEntity<List<MovieProjection>> getAll() {
        List<MovieProjection> movieList = movieService.findAllMovie();
        if(movieList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(movieList,HttpStatus.OK);
        }
    }

    @GetMapping("/search/{movieName}")
    public ResponseEntity<List<MovieProjection>> getAllMovieByMovieName(@PathVariable String movieName) {
        List<MovieProjection> movieList = movieService.findMovieByMovieName(movieName);
        if(movieList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(movieList,HttpStatus.OK);
        }
    }
}
