package a0323i1_cinema_professtional_be.repository.movie;

import a0323i1_cinema_professtional_be.dto.MovieProjection;
import a0323i1_cinema_professtional_be.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MovieRepository extends JpaRepository<Movie, Integer> {
    @Query(value = "select m.movieId as movieId, m.movieName as movieName, m.movieImage as movieImage from Movie as m")
    List<MovieProjection> findAllMovie();

    @Query(value = "select m.movieId as movieId, m.movieName as movieName, m.movieImage as movieImage from Movie as m where m.movieName like :movie_name")
    List<MovieProjection> findMovieByMovieName(@Param("movie_name") String movieName);

}

