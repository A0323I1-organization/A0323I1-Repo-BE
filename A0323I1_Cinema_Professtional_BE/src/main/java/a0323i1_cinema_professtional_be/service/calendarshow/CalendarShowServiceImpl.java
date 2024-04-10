package a0323i1_cinema_professtional_be.service.calendarshow;


import a0323i1_cinema_professtional_be.dto.calendarshow.CalendarShowDTO;
import a0323i1_cinema_professtional_be.entity.CalendarShow;
import a0323i1_cinema_professtional_be.repository.calendarshow.CalendarShowRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


@Service
public class CalendarShowServiceImpl implements CalendarShowService{
    @Autowired
    private CalendarShowRepository calendarShowRepository;
    @Override
    public List<CalendarShowDTO> findAllCalendarShowByMovie(int id) {
        List<CalendarShowDTO> calendarShows = calendarShowRepository.findAllCalendarShowByMovieId(id);
        return calendarShows;
    }


    @Override
    public CalendarShow getCalendarShowById(int id) {
        return calendarShowRepository.getCalendarShowById(id);
    }
}
