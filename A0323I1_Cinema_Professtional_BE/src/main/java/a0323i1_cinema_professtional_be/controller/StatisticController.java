package a0323i1_cinema_professtional_be.controller;

import a0323i1_cinema_professtional_be.dto.statistics.CustomerTop;
import a0323i1_cinema_professtional_be.dto.statistics.MovieSales;
import a0323i1_cinema_professtional_be.dto.statistics.MovieTopType;
import a0323i1_cinema_professtional_be.dto.statistics.ShowTimeTop;
import a0323i1_cinema_professtional_be.service.statistic.StatisticService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Statistics data of movie
 * @author kietVH
 * @since 2024-04-17
 * @version 1.0
 */

@RestController
@RequestMapping("/api")
public class StatisticController {
    @Autowired
    private StatisticService statisticService;

    /**
     * join from table movie to table ticket and room type to get top movie
     * @return movie name, total ticket sell and revenue
     */
    @GetMapping("/movie-sale")
    public ResponseEntity<List<MovieSales>> findAllMovieSales() {
        return ResponseEntity.ok(statisticService.getMovieSales());
    }

    /**
     * join from table customer to ticket and room type to get top customer
     * @return customer id, customer name, total ticket sell, revenue and point of customer
     */
    @GetMapping("/top-customer")
    public ResponseEntity<List<CustomerTop>> findAllTopCustomer() {
        return ResponseEntity.ok(statisticService.getTopCustomers());
    }

    /**
     * join table movie type to ticket to get top movie type
     * @return top movie type
     */
    @GetMapping("/top-movie-type")
    public ResponseEntity<List<MovieTopType>> findAllTopMovieType() {
        return ResponseEntity.ok(statisticService.getTopTypeMovie());
    }

    /**
     * join table showtime and ticket to return total top showtime
     * @return top show time and total ticket
     */
    @GetMapping("/top-show-time")
    public ResponseEntity<List<ShowTimeTop>> findAllTopShowTime() {
        return ResponseEntity.ok(statisticService.getTopShowTime());
    }
}
