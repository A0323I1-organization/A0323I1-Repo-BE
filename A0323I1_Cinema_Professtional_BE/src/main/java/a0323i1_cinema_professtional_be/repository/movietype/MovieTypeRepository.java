package a0323i1_cinema_professtional_be.repository.movietype;

import a0323i1_cinema_professtional_be.entity.MovieType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
@Repository
@Transactional
public interface MovieTypeRepository extends JpaRepository<MovieType,Integer> {
//    List<MovieType> findAllMovieType();
//    MovieType findAllMovieTypeById(int id);
//    MovieType findAllMovieTypeByName(String name);
}
