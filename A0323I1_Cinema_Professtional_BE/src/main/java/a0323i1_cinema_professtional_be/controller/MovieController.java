package a0323i1_cinema_professtional_be.controller;


import a0323i1_cinema_professtional_be.dto.movie.AllMovieDTO;
import a0323i1_cinema_professtional_be.dto.movie.GetMovieDTO;
import a0323i1_cinema_professtional_be.service.movie.MovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * @author LongNHB
 */

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class MovieController {

    private final MovieService movieService;

    /**
     * get all moving is showing
     *
     * @return list movie is showing
     */
    @GetMapping("/get-all-movie-is-showing")
    public ResponseEntity<List<AllMovieDTO>> findAllMovieIsShowing() {
        List<AllMovieDTO> movies = movieService.findAllMovieIsShowing();
        if (movies.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(movies, HttpStatus.OK);
        }
    }

    /**
     * @param id: id movie
     * @return information of movie with movieId = id
     */

    @GetMapping("/get-movie-by-id/{id}")
    public ResponseEntity<GetMovieDTO> getMovieById(@PathVariable("id") int id) {
        GetMovieDTO movie = movieService.getMovieDTOById(id);
        if (movie == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(movie, HttpStatus.OK);
        }
    }

}
