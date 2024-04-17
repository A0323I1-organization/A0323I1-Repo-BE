package a0323i1_cinema_professtional_be.entity;


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
    private String seatName;
    private boolean checkSeat;
    @ManyToOne
    @JoinColumn(name = "type_seat_id",referencedColumnName = "type_seat_id")
    private TypeSeat typeSeat;
    @ManyToOne
    @JoinColumn(name = "room_id",referencedColumnName = "room_id")
    private Room room;
    @OneToMany(mappedBy = "seat")
    private List<Ticket> ticketList;
}
