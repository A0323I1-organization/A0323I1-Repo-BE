package a0323i1_cinema_professtional_be.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "movie")
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "movie_id")
    private int movieId;
    @Column(name = "movie_name")
    private String movieName;
    @Column(name = "movie_start_day", columnDefinition = "DATE")
    private Date movieStartDay;
    @Column(name = "movie_end_day",columnDefinition = "DATE")
    private Date movieEndDay;
    @Column(name = "movie_actor")
    private String movieActor;
    @Column(name = "movie_manufacturer")
    private String movieManufacturer;
    @Column(name = "movie_director")
    private String movieDirector;
    @Column(name = "movie_duration")
    private int movieDuration;
    @Column(name = "movie_trailer", columnDefinition = "TEXT")
    private String movieTrailer;
    @Column(name = "movie_image", columnDefinition = "TEXT")
    private String movieImage;
    @Column(name = "movie_detail",columnDefinition = "TEXT")
    private String movieDetail;
    @Column(name = "movie_version")
    private boolean movieVersion;

    @OneToMany(mappedBy = "movie")
    private List<CalendarShow> calendarShows;

    @ManyToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @JoinTable(name = "employe_movie",joinColumns = @JoinColumn(name = "movie_id",referencedColumnName = "movie_id"),
            inverseJoinColumns = @JoinColumn(name = "employee_id",referencedColumnName = "employee_id"))
    private List<Employee> employees;
}
