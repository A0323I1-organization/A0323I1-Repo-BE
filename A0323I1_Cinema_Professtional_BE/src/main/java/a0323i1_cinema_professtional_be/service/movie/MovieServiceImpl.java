package a0323i1_cinema_professtional_be.service.movie;

import a0323i1_cinema_professtional_be.entity.Movie;
import a0323i1_cinema_professtional_be.repository.movie.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class MovieServiceImpl implements MovieService{
    @Autowired
    private MovieRepository movieRepository;

    @Override
    public Movie getMovieByID(int id) {

        return movieRepository.getMovieById(id);
    }

    @Override
    public List<Movie> getShowingMovie() {
        return movieRepository.getShowingMovie();
    }



}
