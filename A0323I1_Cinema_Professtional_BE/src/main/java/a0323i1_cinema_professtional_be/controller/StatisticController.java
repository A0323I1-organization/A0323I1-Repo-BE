package a0323i1_cinema_professtional_be.controller;

import a0323i1_cinema_professtional_be.dto.statistics.CustomerTop;
import a0323i1_cinema_professtional_be.dto.statistics.MovieSales;
import a0323i1_cinema_professtional_be.dto.statistics.MovieTopType;
import a0323i1_cinema_professtional_be.dto.statistics.ShowTimeTop;
import a0323i1_cinema_professtional_be.service.statistic.StatisticService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

/**
 * Statistics data of movie
 *
 * @author kietVH
 * @version 1.0
 * @since 2024-04-17
 */

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:3000")
@RequiredArgsConstructor
public class StatisticController {
    private final StatisticService statisticService;

    /**
     * join from table movie to table ticket and room type to get top movie
     *
     * @return movie name, total ticket sell and revenue
     */
    @GetMapping("/movie-sale")
    public ResponseEntity<Page<MovieSales>> getAllMovieSalePaging(
            @RequestParam(defaultValue = "0") Integer pageNo,
            @RequestParam(defaultValue = "10") Integer pageSize,
            @RequestParam(defaultValue = "movie_id") String sortBy,
            @RequestParam(defaultValue = "true") boolean sortDirection)  {
        return ResponseEntity.ok(statisticService.getAllMovieSalesPages(pageNo, pageSize, sortBy, sortDirection));
    }

    /**
     * join from table customer to ticket and room type to get top customer
     *
     * @return customer id, customer name, total ticket sell, revenue and point of customer
     */
    @GetMapping("/top-customer")
    public ResponseEntity<Page<CustomerTop>> getAllTopCustomerPaging(
            @RequestParam(defaultValue = "0") Integer pageNo,
            @RequestParam(defaultValue = "10") Integer pageSize,
            @RequestParam(defaultValue = "point") String sortBy)  {
        return ResponseEntity.ok(statisticService.getAllCustomerTopPages(pageNo, pageSize, sortBy));
    }

    /**
     * join table movie type to ticket to get top movie type
     *
     * @return top movie type
     */
    @GetMapping("/top-movie-type")
    public ResponseEntity<Page<MovieTopType>> getAllMovieTopTypePaging(
            @RequestParam(defaultValue = "0") Integer pageNo,
            @RequestParam(defaultValue = "10") Integer pageSize,
            @RequestParam(defaultValue = "movieType") String sortBy,
            @RequestParam(defaultValue = "true") boolean sortDirection)  {
        return ResponseEntity.ok(statisticService.getAllTopMovieTypePages(pageNo, pageSize, sortBy,sortDirection));
    }

    /**
     * join table showtime and ticket to return total top showtime
     *
     * @return top show time and total ticket
     */
    @GetMapping("/top-show-time")
    public ResponseEntity<Page<ShowTimeTop>> getAllShowTimeTopPaging(
            @RequestParam(defaultValue = "0") Integer pageNo,
            @RequestParam(defaultValue = "10") Integer pageSize,
            @RequestParam(defaultValue = "showTimeTotalTicket") String sortBy,
            @RequestParam(defaultValue = "true") boolean sortDirection)  {
        return ResponseEntity.ok(statisticService.getAllTopShowTimePages(pageNo, pageSize, sortBy,sortDirection));
    }
    @GetMapping("/movie-sale-date")
    public ResponseEntity<List<MovieSales>> getAllMovieSaleDate(
            @RequestParam(defaultValue = "year") String filterDate)  {
        return ResponseEntity.ok(statisticService.getMovieSaleDate(filterDate));
    }
    @GetMapping("/top-customer-date")
    public ResponseEntity<List<CustomerTop>> getAllTopCustomerTopDate(
            @RequestParam(defaultValue = "year") String filterDate)  {
        return ResponseEntity.ok(statisticService.getCustomerTopDate(filterDate));
    }@GetMapping("/top-movie-type-date")
    public ResponseEntity<List<MovieTopType>> getAllMovieTopTypeDate(
            @RequestParam(defaultValue = "year") String filterDate)  {
        return ResponseEntity.ok(statisticService.getMovieTypeDate(filterDate));
    }@GetMapping("/top-show-time-date")
    public ResponseEntity<List<ShowTimeTop>> getAllShowTimeTopDate(
            @RequestParam(defaultValue = "year") String filterDate)  {
        return ResponseEntity.ok(statisticService.getShowTimeDate(filterDate));
    }
}
