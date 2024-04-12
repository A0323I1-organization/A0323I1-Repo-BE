package a0323i1_cinema_professtional_be.service.statistic;

import a0323i1_cinema_professtional_be.dto.statistics.MovieSales;

import java.util.List;

public interface StatisticService {
    List<MovieSales> getMovieSales();
}
