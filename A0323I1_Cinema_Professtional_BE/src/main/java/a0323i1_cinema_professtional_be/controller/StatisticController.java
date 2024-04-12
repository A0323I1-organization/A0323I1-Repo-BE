package a0323i1_cinema_professtional_be.controller;

import a0323i1_cinema_professtional_be.dto.statistics.MovieSales;
import a0323i1_cinema_professtional_be.service.statistic.StatisticService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class StatisticController {
    @Autowired
    private StatisticService statisticService;
    @GetMapping
    public ResponseEntity<List<MovieSales>> findAllMovieSales() {
        return ResponseEntity.ok(statisticService.getMovieSales());
    }
}
