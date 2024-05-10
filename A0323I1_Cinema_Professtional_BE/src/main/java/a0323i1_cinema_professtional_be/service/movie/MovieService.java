package a0323i1_cinema_professtional_be.service.movie;


import a0323i1_cinema_professtional_be.dto.movie.AllMovieDTO;
import a0323i1_cinema_professtional_be.dto.movie.GetMovieDTO;

import java.util.List;

public interface MovieService {
    GetMovieDTO getMovieDTOById(int id);
    List<AllMovieDTO> findAllMovieIsShowing();


}
