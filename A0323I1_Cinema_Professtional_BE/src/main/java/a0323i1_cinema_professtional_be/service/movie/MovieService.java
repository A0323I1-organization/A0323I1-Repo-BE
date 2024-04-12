package a0323i1_cinema_professtional_be.service.movie;

import a0323i1_cinema_professtional_be.dto.MovieProjection;

import java.util.List;

public interface MovieService {
    List<MovieProjection> findAllMovie();
    List<MovieProjection> findMovieByMovieName(String movieName);
}
