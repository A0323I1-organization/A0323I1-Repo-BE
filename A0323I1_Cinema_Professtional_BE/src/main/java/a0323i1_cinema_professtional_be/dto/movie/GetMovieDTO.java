package a0323i1_cinema_professtional_be.dto.movie;

import java.util.Date;

public interface GetMovieDTO {
    Boolean getMovieVersion();

    String getMovieName();

    Integer getMovieId();

    Date getMovieStartDay();

    String getMovieActor();

    String getMovieManufacturer();

    String getMovieDirector();

    Integer getMovieDuration();

    String getMovieTrailer();

    String getMovieImage();

    String getMovieDetail();
}
