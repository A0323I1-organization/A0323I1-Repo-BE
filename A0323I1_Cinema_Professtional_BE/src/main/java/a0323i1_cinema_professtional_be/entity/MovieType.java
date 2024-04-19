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
@Table(name = "movie_type")
public class MovieType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "movie_type_id")

    private int movieType;

    @Column(name = "movie_type_name")
    private String movieTypeName;

    @ManyToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @JoinTable(name = "movie_type_detail",joinColumns = @JoinColumn(name = "movie_type_id", referencedColumnName = "movie_type_id"),
            inverseJoinColumns = @JoinColumn(name = "movie_id",referencedColumnName = "movie_id"))
    private List<Movie> movies;
}