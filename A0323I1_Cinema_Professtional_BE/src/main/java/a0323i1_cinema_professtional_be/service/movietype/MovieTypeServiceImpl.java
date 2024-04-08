package a0323i1_cinema_professtional_be.service.movietype;

import a0323i1_cinema_professtional_be.entity.MovieType;
import a0323i1_cinema_professtional_be.repository.movietype.MovieTypeRepository;

import java.util.List;

public class MovieTypeServiceImpl implements MovieTypeService{
    private MovieTypeRepository movieTypeRepository;
    @Override
    public List<MovieType> findAllMovieType() {
        return movieTypeRepository.findAllMovieType();
    }

    @Override
    public MovieType findAllMovieTypeById(int id) {
        return movieTypeRepository.findAllMovieTypeById(id);
    }

    @Override
    public MovieType findAllMovieTypeByName(String name) {
        return movieTypeRepository.findAllMovieTypeByName(name);
    }
}
