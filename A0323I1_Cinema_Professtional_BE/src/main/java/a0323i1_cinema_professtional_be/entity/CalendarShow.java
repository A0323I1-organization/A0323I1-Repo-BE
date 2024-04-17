package a0323i1_cinema_professtional_be.entity;



import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "calendar_show")
public class CalendarShow {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "calendar_show_id")
    private int calendarShowId;

    @Column(name = "calendar_show_detail")
    private String calendarShowDetail;


    @ManyToOne
    @JoinColumn(name = "movie_id",referencedColumnName = "movie_id")
    private Movie movie;


    @ManyToOne
    @JoinColumn(name = "room_id",referencedColumnName = "room_id")
    private Room room;



    @OneToMany(mappedBy = "calendarShow")
    private List<Seat> seats;


    @ManyToOne
    @JoinColumn(name = "show_time_id",referencedColumnName = "show_time_id")
    private ShowTime showTime;



    @OneToMany(mappedBy = "calendarShow")
    private List<Seat> ticketList;

}
