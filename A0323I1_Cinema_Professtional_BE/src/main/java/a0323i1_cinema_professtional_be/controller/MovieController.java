package a0323i1_cinema_professtional_be.controller;

import a0323i1_cinema_professtional_be.entity.Movie;
import a0323i1_cinema_professtional_be.service.movie.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/movie")
public class MovieController {
    @Autowired
    private MovieService movieService;
    @GetMapping
    public ResponseEntity<Iterable<Movie>> findAll() {
        List<Movie> movies = movieService.findAll();
        if (movies.isEmpty()) {
            return new ResponseEntity<>(movies, HttpStatus.OK);
        }
        return new ResponseEntity<>(movies, HttpStatus.OK);

}}
