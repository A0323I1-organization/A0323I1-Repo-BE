<<<<<<< HEAD
package a0323i1_cinema_professtional_be.service.movie;
public interface MovieService{
=======


import a0323i1_cinema_professtional_be.dto.movie.AllMovieDTO;
import a0323i1_cinema_professtional_be.dto.movie.GetMovieDTO;
import a0323i1_cinema_professtional_be.dto.ticket.MovieDto;
import a0323i1_cinema_professtional_be.dto.ticket.MovieProjection;

import a0323i1_cinema_professtional_be.entity.Movie;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;


public interface MovieService {
    GetMovieDTO getMovieById(int id);
    List<AllMovieDTO> findAllMovieIsShowing();

    void deleteMovieById(int id);
//    Page<Movie> findAllMovie(String find, Pageable pageable);
//    Movie getMovieById(int id);

    List<MovieProjection> findAllMovieProjection();
    List<MovieProjection> findMovieByMovieName(String movieName);


>>>>>>> 5d0c8c911dc2197b895e70732c6165f28301874a
}
