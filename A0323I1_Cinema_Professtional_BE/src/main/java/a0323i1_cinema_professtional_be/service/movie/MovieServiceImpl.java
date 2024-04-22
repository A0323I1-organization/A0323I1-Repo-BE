package a0323i1_cinema_professtional_be.service.movie;



@Service
public class MovieServiceImpl implements MovieService{


/**
 * @author LongNHB
 */

@Service
public class MovieServiceImpl implements MovieService{
    @Autowired
    private MovieRepository movieRepository;


    /**
     * this method use to get movie by id
     * @param id movie id
     * @return movie
     */
    @Override
    public GetMovieDTO getMovieById(int id) {
        return movieRepository.getMovieById(id);
    }

    /**
     * this method use to get all movie is showing
     * @return list movie is showing
     */
    @Override
    public List<AllMovieDTO> findAllMovieIsShowing() {
        return movieRepository.findAllMovieIsShowing();


//    @Override
//    public void saveMovie(MovieDto movieDto) {
//        movieRepository.saveMovie();
//    }

//    @Override
//    public void updateMovie(MovieDto movieDto) {
//        movieRepository.saveMovie();
//    }

    @Override
    public void deleteMovieById(int id) {
        movieRepository.deleteMovie(id);
    }

    @Override
    public Page<Movie> findAllMovie(String find, Pageable pageable) {
        return movieRepository.findAllMovie(pageable);
    }

    @Override
    public Movie getMovieById(int id) {
        return movieRepository.getMovieById(id);
    }

    @Override
    public List<MovieProjection> findAllMovieProjection() {
        return movieRepository.findAllMovieProjection();
    }

    @Override
    public List<MovieProjection> findMovieByMovieName(String movieName) {
        return movieRepository.findMovieByMovieName("%" + movieName + "%");

    }

}
