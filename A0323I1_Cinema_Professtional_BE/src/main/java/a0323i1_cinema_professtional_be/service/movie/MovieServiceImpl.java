package a0323i1_cinema_professtional_be.service.movie;

import a0323i1_cinema_professtional_be.dto.MovieProjection;
import a0323i1_cinema_professtional_be.repository.movie.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieServiceImpl implements MovieService{

    @Autowired
    private MovieRepository movieRepository;

    @Override
    public List<MovieProjection> findAllMovie() {
        return movieRepository.findAllMovie();
    }

    @Override
    public List<MovieProjection> findMovieByMovieName(String movieName) {
        return movieRepository.findMovieByMovieName("%" + movieName + "%");
    }

}
