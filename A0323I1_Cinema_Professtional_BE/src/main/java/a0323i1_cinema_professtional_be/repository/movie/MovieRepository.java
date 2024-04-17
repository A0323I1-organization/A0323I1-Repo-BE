package a0323i1_cinema_professtional_be.repository.movie;

import a0323i1_cinema_professtional_be.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<Movie,Integer> {
}
