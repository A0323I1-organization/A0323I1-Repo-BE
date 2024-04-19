package a0323i1_cinema_professtional_be.service.statistic;

import a0323i1_cinema_professtional_be.dto.statistics.CustomerTop;
import a0323i1_cinema_professtional_be.dto.statistics.MovieSales;
import a0323i1_cinema_professtional_be.dto.statistics.MovieTopType;
import a0323i1_cinema_professtional_be.dto.statistics.ShowTimeTop;
import a0323i1_cinema_professtional_be.repository.statistic.StatisticRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StatisticServiceImpl implements StatisticService{
    @Autowired
    private StatisticRepository repository;

    @Override
    public List<MovieSales> getMovieSales() {
        return repository.getMovieSales();
    }

    @Override
    public List<CustomerTop> getTopCustomers() {
        return repository.getTopCustomers();
    }

    @Override
    public List<MovieTopType> getTopTypeMovie() {
        return repository.getTopTypeMovie();
    }

    @Override
    public List<ShowTimeTop> getTopShowTime() {
        return repository.getTopShowTime();
    }
}
