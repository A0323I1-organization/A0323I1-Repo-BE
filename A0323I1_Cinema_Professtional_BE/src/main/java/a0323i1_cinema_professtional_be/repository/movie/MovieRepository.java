package a0323i1_cinema_professtional_be.repository.movie;

import a0323i1_cinema_professtional_be.entity.Movie;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Repository
@Transactional
public interface MovieRepository extends JpaRepository<Movie,Integer> {
    @Modifying
    @Query(value = "insert INTO movie (movie_name, movie_start_day, movie_end_day, movie_actor, movie_manufacturer, movie_director, movie_duration, movie_trailer, movie_image, movie_detail, movie_version) VALUES(?,?,?,?,?,?,?,?,?,?,?)",nativeQuery = true)
    void saveMovie(String movieName, Date movieStartDay, Date movieEndDay, String movieActor, String movieManufacturer, String movieDirector, int movieDuration, String movieTrailer, String movieImage, String movieDetail, boolean movieVersion);
    @Modifying
    @Query(nativeQuery = true, value = "")
    void updateMovieById(String movieName, Date movieStartDay, Date movieEndDay, String movieActor, String movieManufacturer, String movieDirector, int movieDuration, String movieTrailer, String movieImage, String movieDetail, boolean movieVersion, int movie_id);
    @Modifying
    void deleteMovieById(int id);
    @Query(value = "select * from movie where movie_id = :id ", nativeQuery = true)
    Movie getMovieById(@Param("id") int id);
    @Query(value = "select * from movie", nativeQuery = true)
    List<Movie> findAllMovie();
    Page<Movie> findAllMovie(Pageable pageable);
}
