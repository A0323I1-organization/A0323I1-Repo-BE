package a0323i1_cinema_professtional_be.entity;


import com.fasterxml.jackson.annotation.JsonBackReference;
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
@Table(name = "seat")
public class Seat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "seat_id")
    private int seatId;

    @Column(name = "name")
    private String seatName;

    private boolean checkSeat;

    @ManyToOne
    @JoinColumn(name = "type_seat_id", referencedColumnName = "type_seat_id")
    private TypeSeat typeSeat;

    @ManyToOne
    @JoinColumn(name = "calendar_show_id", referencedColumnName = "calendar_show_id")
    @JoinColumn(name = "calendar_show_id",referencedColumnName = "calendar_show_id")

    private CalendarShow calendarShow;

    @OneToMany(mappedBy = "seat")
    private List<Ticket> ticketList;

    public boolean getCheckSeat() {
        return checkSeat;
    }

    public void setCheckSeat(boolean checkSeat) {
        this.checkSeat = checkSeat;
    }
}
