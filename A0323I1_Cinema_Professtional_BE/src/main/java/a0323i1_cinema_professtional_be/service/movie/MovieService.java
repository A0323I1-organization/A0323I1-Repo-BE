package a0323i1_cinema_professtional_be.service.movie;

import a0323i1_cinema_professtional_be.dto.movie.MovieDTO;
import a0323i1_cinema_professtional_be.entity.Movie;
import org.springframework.stereotype.Service;

import java.util.List;

public interface MovieService {
    Movie getMovieById(int id);
    List<MovieDTO> findAllMovieIsShowing();
}
