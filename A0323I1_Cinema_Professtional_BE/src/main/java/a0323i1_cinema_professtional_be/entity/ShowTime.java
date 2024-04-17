package a0323i1_cinema_professtional_be.entity;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Time;
import java.util.Date;
import java.util.List;
import java.util.Timer;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "show_time")
public class ShowTime {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "show_time_id")
    private int showTimeId;

    @Column(name = "show_date",columnDefinition = "DATE")
    private Date showDate;

    @Column(name = "movie_time")
    private Time movieTime;


    @OneToMany(mappedBy = "showTime")
    private List<CalendarShow> calendarShows;

}
