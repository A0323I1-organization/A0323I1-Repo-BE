package a0323i1_cinema_professtional_be.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "ticket")
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ticket_id")
    private int ticketId;

    @ManyToOne
    @JoinColumn(name = "invoice_id",referencedColumnName = "invoice_id")
    private Invoice invoice;


    @ManyToOne
    @JoinColumn(name = "seat_id",referencedColumnName = "seat_id")
    private Seat seat;


}
