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
@Table(name = "room")
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "room_id")
    private int roomId;
    @Column(name = "room_name")
    private String roomName;
    @Column(name = "room_payload")
    private int roomPayload;
    @Column(name = "room_detail")
    private String roomDetail;


    @OneToMany(mappedBy = "room")
    private List<CalendarShow> calendarShows;
}
