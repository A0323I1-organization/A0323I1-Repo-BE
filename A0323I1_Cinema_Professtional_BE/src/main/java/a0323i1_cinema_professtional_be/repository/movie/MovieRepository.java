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

@Repository
@Transactional
public interface MovieRepository extends JpaRepository<Movie, Integer> {
//    void saveMovie();


    //Xóa
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
}
