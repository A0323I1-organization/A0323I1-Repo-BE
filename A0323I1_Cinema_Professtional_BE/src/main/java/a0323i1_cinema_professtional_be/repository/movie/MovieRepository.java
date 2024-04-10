package a0323i1_cinema_professtional_be.repository.movie;

import a0323i1_cinema_professtional_be.dto.movie.MovieDTO;
import a0323i1_cinema_professtional_be.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MovieRepository extends JpaRepository<Movie,Integer> {
    @Query(value="select * from movie", nativeQuery = true)
    List<Movie> findAllMovie();

    @Query(value = "select * from movie where movie_id= :id",nativeQuery = true)
    Movie getMovieById(@Param("id") int id);

    @Query(value = "select m.movieId as movieId, m.movieImage as movieImage, m.movieName as movieName from Movie as m " +
            "where m.movieStartDay <= current_date() and m.movieEndDay >= current_date() ")
    List<MovieDTO> findAllMovieIsShowing();
}
