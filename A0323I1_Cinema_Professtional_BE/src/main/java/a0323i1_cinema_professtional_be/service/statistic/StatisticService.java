package a0323i1_cinema_professtional_be.service.statistic;

import a0323i1_cinema_professtional_be.dto.statistics.CustomerTop;
import a0323i1_cinema_professtional_be.dto.statistics.MovieSales;
import a0323i1_cinema_professtional_be.dto.statistics.MovieTopType;
import a0323i1_cinema_professtional_be.dto.statistics.ShowTimeTop;
import org.springframework.data.domain.Page;

import java.util.List;

public interface StatisticService {
    /**
     * join from table movie to table ticket and room type to get top movie
     * @return movie name, total ticket sell and revenue
     */
    Page<MovieSales> getAllMovieSalesPages(Integer pageNo, Integer pageSize, String sortBy,boolean sortDirection);
    /**
     * join from table customer to ticket and room type to get top customer
     * @return customer id, customer name, total ticket sell, revenue and point of customer
     */
    Page<CustomerTop> getAllCustomerTopPages(Integer pageNo, Integer pageSize, String sortBy);
    /**
     * join table movie type to ticket to get top movie type
     * @return top movie type
     */
    Page<MovieTopType> getAllTopMovieTypePages(Integer pageNo, Integer pageSize, String sortBy,boolean sortDirection);
    /**
     * join table showtime and ticket to return total top showtime
     * @return top show time and total ticket
     */
    Page<ShowTimeTop> getAllTopShowTimePages(Integer pageNo, Integer pageSize, String sortBy,boolean sortDirection);





}
