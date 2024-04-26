package a0323i1_cinema_professtional_be.service.movie;


import a0323i1_cinema_professtional_be.dto.MovieProjection;

import java.util.List;

public interface MovieService {
    List<MovieProjection> findAllMovie();
    List<MovieProjection> findMovieByMovieName(String movieName);
    List<MovieProjection> findAllMovieIsShowing();
    List<MovieProjection> findAllUpcomingMovie();
}

//    GetMovieDTO getMovieById(int id);
//    List<AllMovieDTO> findAllMovieIsShowing();
//=======
//import a0323i1_cinema_professtional_be.dto.MovieDto;
//import a0323i1_cinema_professtional_be.dto.MovieProjection;
//import a0323i1_cinema_professtional_be.entity.Movie;
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.Pageable;
//
//import java.util.List;
//
//public interface MovieService{
////    void saveMovie(MovieDto movieDto);
////    void updateMovie(MovieDto movieDto);
//    void deleteMovieById(int id);
//    Page<Movie> findAllMovie(String find, Pageable pageable);
//    Movie getMovieById(int id);
//
//    List<MovieProjection> findAllMovieProjection();
//    List<MovieProjection> findMovieByMovieName(String movieName);

