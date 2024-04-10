package a0323i1_cinema_professtional_be.service.movietype;

import a0323i1_cinema_professtional_be.entity.MovieType;

import java.util.List;

public interface MovieTypeService {
    List<MovieType> findAllMovieType();
    MovieType findAllMovieTypeById(int id);
    MovieType findAllMovieTypeByName(String name);
}
