package a0323i1_cinema_professtional_be.controller;


import a0323i1_cinema_professtional_be.dto.movie.MovieDTO;
import a0323i1_cinema_professtional_be.entity.Movie;
import a0323i1_cinema_professtional_be.service.movie.MovieService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class MovieController {
    @Autowired
    private MovieService movieService;

    @GetMapping("/getAllMovieIsShowing")
    public ResponseEntity<List<MovieDTO>> findAllMovieIsShowing() {
        List<MovieDTO> movies = movieService.findAllMovieIsShowing();
        if (movies.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(movies, HttpStatus.OK);
        }
    }

}
