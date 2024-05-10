package a0323i_cinema_professtional_be.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "type_seat")
public class TypeSeat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "type_seat_id")
    private int typeSeatId;
    @Column(name = "type_seat_name")
    private String typeSeatName;
    @Column(name = "type_seat_price")
    private String typeSeatPrice;

    @OneToMany(mappedBy = "typeSeat")
    private List<Seat> seats;
}
