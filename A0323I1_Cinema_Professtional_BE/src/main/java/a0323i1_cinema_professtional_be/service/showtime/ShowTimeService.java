package a0323i1_cinema_professtional_be.service.showtime;

import a0323i1_cinema_professtional_be.dto.showtime.ShowDateDTO;
import a0323i1_cinema_professtional_be.dto.showtime.ShowMovieTimeDTO;

import java.util.List;

public interface ShowTimeService {
    List<ShowDateDTO> findAllShowDateByMovie(int movieId);
    List<ShowMovieTimeDTO> findAllShowTime(String date, int movieId);


}
