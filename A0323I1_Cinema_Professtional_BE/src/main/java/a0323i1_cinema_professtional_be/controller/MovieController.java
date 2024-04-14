package a0323i1_cinema_professtional_be.controller;

import a0323i1_cinema_professtional_be.dto.MovieProjection;
import a0323i1_cinema_professtional_be.entity.Movie;
import a0323i1_cinema_professtional_be.service.movie.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@CrossOrigin(origins = "http://localhost:3000", allowedHeaders = "**")
@RequestMapping("/api/movie")
public class MovieController {
    @Autowired
    private MovieService movieService ;

    @GetMapping()
    public ResponseEntity<?> getAllMovie(@RequestParam(defaultValue = "") String find,
                                            @RequestParam(value = "page", defaultValue = "0") Integer page,
                                            @RequestParam(value = "size", defaultValue = "3") Integer size) {
        Page<Movie> movies = movieService.findAllMovie(find, PageRequest.of(page, size));
        return new ResponseEntity<>(movies, HttpStatus.OK);
    }

    @GetMapping("")
    public ResponseEntity<List<MovieProjection>> getAll() {
        List<MovieProjection> movieList = movieService.findAllMovieProjection();
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
