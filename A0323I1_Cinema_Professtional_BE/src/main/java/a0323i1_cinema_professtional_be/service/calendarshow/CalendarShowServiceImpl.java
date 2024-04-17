package a0323i1_cinema_professtional_be.service.calendarshow;

import a0323i1_cinema_professtional_be.entity.CalendarShow;
import a0323i1_cinema_professtional_be.repository.calendarshow.CalendarShowRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CalendarShowServiceImpl implements CalendarShowService{
    @Autowired
    private CalendarShowRepository calendarShowRepository;
    @Override
    public List<CalendarShow> getCalendarShowNext7Day(@Param("id") int id) {
        return calendarShowRepository.getCalendarShowNext7Day(id);
    }
}
