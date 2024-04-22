

import javax.transaction.Transactional;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;


@Transactional
public interface MovieRepository extends JpaRepository<Movie,Integer> {


    @Modifying
    @Query(value = "insert INTO movie (movie_name, movie_start_day, movie_end_day, movie_actor, movie_manufacturer, movie_director, movie_duration, movie_trailer, movie_image, movie_detail, movie_version) VALUES(?,?,?,?,?,?,?,?,?,?,?)",nativeQuery = true)
    void saveMovie(String movieName, Date movieStartDay, Date movieEndDay, String movieActor, String movieManufacturer, String movieDirector, int movieDuration, String movieTrailer, String movieImage, String movieDetail, boolean movieVersion);
//    @Modifying
//    @Query(nativeQuery = true, value = "")
//    void updateMovieById(String movieName, Date movieStartDay, Date movieEndDay, String movieActor, String movieManufacturer, String movieDirector, int movieDuration, String movieTrailer, String movieImage, String movieDetail, boolean movieVersion, int movie_id);
    @Modifying
    @Query(value = "DELETE FROM calendar_show where calender_show_id = :calender_show_id", nativeQuery = true)
    void deleteMovie(@Param("calender_show_id") int id);


    //Tìm kiếm
    @Query(value = "select m.movie_id , m.movie_name ,m.start_day , m.studio , m.movie_duration from movie m " +
            "join calendar_show c on c.movie_id = m.movie_id " +
            "join employee e on m.employee_id = e.employee_id " +
            "join movie_type_detail t on t.category_id = m.category_id  " +
            "where  m.movie_id = ?;", nativeQuery = true)
    Movie getMovieById(@Param("id") int id);


    //List
    @Query(value = "select m.movie_id, m.movie_name, m.movie_start_day, m.movie_duration from movie m " +
            "join calendar_show c on c.movie_id = m.movie_id " +
            "join employe_movie e on e.movie_id = m.movie_id " +
            "join employee epl on epl.employee_id = e.employee_id "+
            "join movie_type_detail t on t.movie_id = m.movie_id "+
            "join movie_type mt on mt.movie_type_id = t.movie_type_id", nativeQuery = true)
    Page<Movie> findAllMovie(Pageable pageable);

    @Query(value = "select m.movieId as movieId, m.movieName as movieName, m.movieImage as movieImage from Movie as m")
    List<MovieProjection> findAllMovieProjection();

    @Query(value = "select m.movieId as movieId, m.movieName as movieName, m.movieImage as movieImage from Movie as m where m.movieName like :movie_name")
    List<MovieProjection> findMovieByMovieName(@Param("movie_name") String movieName);


}
