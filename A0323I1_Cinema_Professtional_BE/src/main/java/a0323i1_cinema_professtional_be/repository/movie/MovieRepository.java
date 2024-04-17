package a0323i1_cinema_professtional_be.repository.movie;

import a0323i1_cinema_professtional_be.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

import java.time.LocalDate;
import java.util.List;


@Repository

public interface MovieRepository extends JpaRepository<Movie,Integer> {
    @Query(value = "Select " +
            "movie.movie_id, " +
            "movie.movie_name, " +
            "movie.movie_start_day, " +
            "movie.movie_end_day, " +
            "movie.movie_actor, " +
            "movie.movie_manufacturer, " +
            "movie.movie_director, " +
            "movie.movie_duration, " +
            "movie.movie_trailer, " +
            "movie.movie_image, " +
            "movie.movie_detail, " +
            "movie.movie_version, " +
            "movie.status, " +
            "movie_type.movie_type_name " +
            "FROM movie " +
            "INNER JOIN movie_type_detail ON movie.movie_id = movie_type_detail.movie_id " +
            "INNER JOIN movie_type ON movie_type_detail.movie_type_id = movie_type.movie_type_id " +
            "WHERE movie.movie_id = :id", nativeQuery = true)
    Movie getMovieById( @Param("id") int id);
//    @Query(value = "SELECT "+"movie.movie_name, "+"movie.movie_image "+"FROM movie"+" WHERE CURDATE() "+"BETWEEN movie_start_day"+" AND movie_end_day", nativeQuery = true)
//    List<Movie> getShowingMovie();
    @Query(value = "select m.movieId as movieId, m.movieImage as movieImage, m.movieName as movieName from Movie as m " +"where m.movieStartDay <= current_date() and m.movieEndDay >= current_date()", nativeQuery = true)
    List<Movie> getShowingMovie();



}
