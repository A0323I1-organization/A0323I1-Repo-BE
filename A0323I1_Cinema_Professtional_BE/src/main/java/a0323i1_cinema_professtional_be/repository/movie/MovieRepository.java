package a0323i1_cinema_professtional_be.repository.movie;


import a0323i1_cinema_professtional_be.dto.movie.AllMovieDTO;
import a0323i1_cinema_professtional_be.dto.movie.GetMovieDTO;
import a0323i1_cinema_professtional_be.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface MovieRepository extends JpaRepository<Movie, Integer> {


    @Query(value = "select  m.movieName as movieName, m.movieId as movieId, m.movieActor as movieActor" +
            ",m.movieDetail as movieDetail, m.movieDuration as movieDuration, m.movieStartDay as movieStartDay" +
            ",m.movieManufacturer as movieManufacturer, m.movieDirector as movieDirector, m.movieTrailer as movieTrailer," +
            "m.movieImage as movieImage, m.movieVersion as movieVersion from Movie as m where m.movieId= :id")
    GetMovieDTO getMovieDTOById(@Param("id") int id);

    @Query(value = "select m.movieId as movieId, m.movieImage as movieImage, m.movieName as movieName from Movie as m " +
            " where m.movieStartDay <= current_date() and m.movieEndDay >= current_date()")
    List<AllMovieDTO> findTop3Movies();

}
