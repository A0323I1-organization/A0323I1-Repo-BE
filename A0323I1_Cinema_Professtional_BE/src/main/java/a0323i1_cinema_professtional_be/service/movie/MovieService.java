package a0323i1_cinema_professtional_be.service.movie;

import a0323i1_cinema_professtional_be.dto.MovieDto;
import a0323i1_cinema_professtional_be.entity.Movie;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface MovieService{
    List<Movie> findAll();
}
