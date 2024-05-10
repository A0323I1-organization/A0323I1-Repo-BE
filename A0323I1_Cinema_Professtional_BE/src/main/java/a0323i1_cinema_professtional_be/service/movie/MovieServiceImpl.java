package a0323i1_cinema_professtional_be.service.movie;


import a0323i1_cinema_professtional_be.dto.movie.AllMovieDTO;
import a0323i1_cinema_professtional_be.dto.movie.GetMovieDTO;
import a0323i1_cinema_professtional_be.repository.movie.MovieRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * @author LongNHB
 */

@Service
@RequiredArgsConstructor
public class MovieServiceImpl implements MovieService {

    private final MovieRepository movieRepository;


    /**
     * this method use to get movie by id
     *
     * @param id movie id
     * @return movie
     */
    @Override
    public GetMovieDTO getMovieDTOById(int id) {
        return movieRepository.getMovieDTOById(id);
    }

    /**
     * this method use to get all movie is showing
     *
     * @return list movie is showing
     */
    @Override
    public List<AllMovieDTO> findAllMovieIsShowing() {
        return movieRepository.findTop3Movies();
    }


}
