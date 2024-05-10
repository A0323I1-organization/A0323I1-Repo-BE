package a0323i1_cinema_professtional_be.service.showtime;

import a0323i1_cinema_professtional_be.dto.showtime.ShowDateDTO;
import a0323i1_cinema_professtional_be.dto.showtime.ShowMovieTimeDTO;
import a0323i1_cinema_professtional_be.repository.showtime.ShowTimeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Date;
import java.util.List;

/**
 * @author LongNHB
 */
@Service
@RequiredArgsConstructor
public class ShowTimeServiceImpl implements ShowTimeService{

    private final ShowTimeRepository showTimeRepository;

    /**
     * this method use to get all show date in 7 day with movie id
     * @param movieId
     * @return list show date in 7 day with movie id
     */
    @Override
    public List<ShowDateDTO> findAllShowDateByMovie(int movieId) {
        List<ShowDateDTO> showDates = showTimeRepository.findAllShowDateByMovie(movieId);
        return showDates;

    }

    /**
     * this method use to get all show time by date
     *
     * @param date
     * @param movieId
     * @return list show time
     */
    @Override
    public List<ShowMovieTimeDTO> findAllShowTime(String date, int movieId) {
        try {
            SimpleDateFormat inputFormatter = new SimpleDateFormat("yyyy-MM-dd");
            Date parsedDate = new Date(inputFormatter.parse(date).getTime());
            return showTimeRepository.findAllShowTime(parsedDate, movieId);
        } catch (ParseException e) {
            e.printStackTrace();
            return Collections.emptyList();
        }
    }
}
