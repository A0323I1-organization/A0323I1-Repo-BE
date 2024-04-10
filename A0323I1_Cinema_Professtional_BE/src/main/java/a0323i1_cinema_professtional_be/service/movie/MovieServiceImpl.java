package a0323i1_cinema_professtional_be.service.movie;

import a0323i1_cinema_professtional_be.dto.MovieDto;
import a0323i1_cinema_professtional_be.entity.Movie;
import a0323i1_cinema_professtional_be.repository.movie.MovieRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class MovieServiceImpl implements MovieService{
    private MovieRepository movieRepository;


    @Override
    public void saveMovie(MovieDto movieDto) {
        movieRepository.saveMovie();
    }

    @Override
    public void updateMovie(MovieDto movieDto) {
        movieRepository.saveMovie();
    }

    @Override
    public void deleteMovieById(int id) {
        movieRepository.deleteMovieById(id);
    }

    @Override
    public Page<Movie> findAllMovie(String find, Pageable pageable) {
        return movieRepository.findAllMovie(pageable);
    }

    @Override
    public Movie getMovieById(int id) {
        return movieRepository.getMovieById(id);
    }
}
