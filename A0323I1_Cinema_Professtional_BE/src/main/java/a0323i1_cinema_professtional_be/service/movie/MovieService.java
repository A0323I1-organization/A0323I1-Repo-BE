package a0323i1_cinema_professtional_be.service.movie;

import a0323i1_cinema_professtional_be.dto.MovieDto;
import a0323i1_cinema_professtional_be.entity.Movie;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface MovieService{
//    void saveMovie(MovieDto movieDto);
//    void updateMovie(MovieDto movieDto);
    void deleteMovieById(int id);
    Page<Movie> findAllMovie(String find, Pageable pageable);
    Movie getMovieById(int id);
}
