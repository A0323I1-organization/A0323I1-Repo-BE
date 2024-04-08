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
    void saveMovie();
    @Modifying
    void deleteMovieById(int id);
    @Query(value = "select * from movie where movie_id = :id ", nativeQuery = true)
    Movie getMovieById(@Param("id") int id);
    @Query(value = "select * from movie", nativeQuery = true)
    List<Movie> findAllMovie();
    Page<Movie> findAllMovie(Pageable pageable);
}
