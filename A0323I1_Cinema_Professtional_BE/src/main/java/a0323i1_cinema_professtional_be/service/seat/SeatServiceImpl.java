package a0323i1_cinema_professtional_be.service.seat;

import a0323i1_cinema_professtional_be.dto.Seat.AllSeatDTO;
import a0323i1_cinema_professtional_be.dto.Seat.SeatDTO;
import a0323i1_cinema_professtional_be.repository.seat.SeatRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author LongNhB
 */
@Service
@RequiredArgsConstructor
public class SeatServiceImpl implements SeatService{

    private final SeatRepository seatRepository;

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
            System.out.println(date);
            SimpleDateFormat inputFormatter = new SimpleDateFormat("yyyy-MM-dd");
            Date parsedDate = new Date(inputFormatter.parse(date).getTime());
            System.out.println(parsedDate);
            listSeat = seatRepository.findAllSeatByCalendarShow(parsedDate, Time.valueOf(time), Integer.parseInt(movieId));
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        return listSeat;
    }

    @Override
    public List<SeatDTO> getSeatById(List<Integer> seatId) {
        List<SeatDTO> list = new ArrayList<>();
        for (int i = 0; i < seatId.size(); i++) {
            list.addAll(seatRepository.getSeatById(seatId.get(i)));
        }
        return list;
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
