package a0323i1_cinema_professtional_be.service.movie;

import a0323i1_cinema_professtional_be.entity.Movie;

import java.time.LocalDate;
import java.util.List;


public interface MovieService {
    Movie getMovieByID(int id);
    List<Movie> getShowingMovie();
}