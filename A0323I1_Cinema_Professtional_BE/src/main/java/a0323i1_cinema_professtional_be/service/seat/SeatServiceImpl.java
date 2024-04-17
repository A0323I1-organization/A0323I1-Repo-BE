package a0323i1_cinema_professtional_be.service.seat;

import a0323i1_cinema_professtional_be.dto.Seat.AllSeatDTO;
import a0323i1_cinema_professtional_be.repository.seat.SeatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @author LongNhB
 */
@Service
public class SeatServiceImpl implements SeatService{
    @Autowired
    private SeatRepository seatRepository;

    /**
     * this method use to get all seat with date , time and movie id
     * @param date
     * @param time
     * @param movieId
     * @return list seat
     */

    @Override
    public List<AllSeatDTO> findAllSeatByCalendarShow(String date, String time, String movieId) {
        List<AllSeatDTO> listSeat ;
        try {
            SimpleDateFormat inputFormatter = new SimpleDateFormat("yyyy-MM-dd");
            Date parsedDate = new Date(inputFormatter.parse(date).getTime());
            listSeat = seatRepository.findAllSeatByCalendarShow(parsedDate, Time.valueOf(time), Integer.parseInt(movieId));
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        return listSeat;
    }

    /**
     * this method use to set checkSeat true
     * @param checked
     * @param seatId
     */
    @Override
    public void bookSeat(Boolean checked, int seatId) {
         seatRepository.bookSeat(checked, seatId);
    }
}
