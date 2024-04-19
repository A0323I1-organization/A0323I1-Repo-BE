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
import java.util.List;

@Repository
@Transactional
public interface MovieRepository extends JpaRepository<Movie,Integer> {
    @Query(value = "select * from movie m " +
            "join calendar_show c on c.movie_id = m.movie_id " +
            "join employe_movie e on e.movie_id = m.movie_id " +
            "join employee epl on epl.employee_id = e.employee_id " +
            "join movie_type_detail t on t.movie_id = m.movie_id " +
            "join movie_type mt on mt.movie_type_id = t.movie_type_id", nativeQuery = true)
    List<Movie> findAllMovie();
}
