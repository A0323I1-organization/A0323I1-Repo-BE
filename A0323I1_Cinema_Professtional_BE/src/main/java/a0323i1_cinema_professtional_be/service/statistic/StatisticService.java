package a0323i1_cinema_professtional_be.service.statistic;

import a0323i1_cinema_professtional_be.dto.statistics.CustomerTop;
import a0323i1_cinema_professtional_be.dto.statistics.MovieSales;
import a0323i1_cinema_professtional_be.dto.statistics.MovieTopType;
import a0323i1_cinema_professtional_be.dto.statistics.ShowTimeTop;

import java.util.List;

public interface StatisticService {
    /**
     * join from table movie to table ticket and room type to get top movie
     * @return movie name, total ticket sell and revenue
     */
    List<MovieSales> getMovieSales();
    /**
     * join from table customer to ticket and room type to get top customer
     * @return customer id, customer name, total ticket sell, revenue and point of customer
     */
    List<CustomerTop> getTopCustomers();
    /**
     * join table movie type to ticket to get top movie type
     * @return top movie type
     */
    List<MovieTopType> getTopTypeMovie();
    /**
     * join table showtime and ticket to return total top showtime
     * @return top show time and total ticket
     */
    List<ShowTimeTop> getTopShowTime();
}
