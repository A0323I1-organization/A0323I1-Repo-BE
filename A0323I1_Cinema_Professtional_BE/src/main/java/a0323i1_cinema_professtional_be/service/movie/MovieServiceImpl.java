package a0323i1_cinema_professtional_be.service.movie;

import a0323i1_cinema_professtional_be.dto.movie.AllMovieDTO;
import a0323i1_cinema_professtional_be.dto.movie.GetMovieDTO;
import a0323i1_cinema_professtional_be.repository.movie.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author LongNHB
 */
@Service
public class MovieServiceImpl implements MovieService{
    @Autowired
    private MovieRepository movieRepository;

    /**
     * this method use to get movie by id
     * @param id movie id
     * @return movie
     */
    @Override
    public GetMovieDTO getMovieById(int id) {
        return movieRepository.getMovieById(id);
    }

    /**
     * this method use to get all movie is showing
     * @return list movie is showing
     */
    @Override
    public List<AllMovieDTO> findAllMovieIsShowing() {
        return movieRepository.findAllMovieIsShowing();
    }
}
