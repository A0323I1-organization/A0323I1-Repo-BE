package a0323i1_cinema_professtional_be.service.statistic;

import a0323i1_cinema_professtional_be.dto.statistics.CustomerTop;
import a0323i1_cinema_professtional_be.dto.statistics.MovieSales;
import a0323i1_cinema_professtional_be.dto.statistics.MovieTopType;
import a0323i1_cinema_professtional_be.dto.statistics.ShowTimeTop;
import a0323i1_cinema_professtional_be.repository.statistic.StatisticRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class StatisticServiceImpl implements StatisticService{

    private final StatisticRepository repository;

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

    @Override
    public Page<MovieSales> getAllMovieSalesPages(Integer pageNo, Integer pageSize, String sortBy, boolean sortDirection) {
        Pageable paging = (sortDirection) ? PageRequest.of(pageNo, pageSize, Sort.by(sortBy).ascending()) : PageRequest.of(pageNo, pageSize, Sort.by(sortBy).descending());
        return repository.getMovieSalesPage(paging);
    }

    @Override
    public Page<CustomerTop> getAllCustomerTopPages(Integer pageNo, Integer pageSize, String sortBy) {
        Pageable paging = PageRequest.of(pageNo, pageSize, Sort.by(Sort.Direction.DESC,sortBy));
        return repository.getTopCustomersPage(paging);
    }
    @Override
    public Page<MovieTopType> getAllTopMovieTypePages(Integer pageNo, Integer pageSize, String sortBy, boolean sortDirection) {
        Pageable paging = (sortDirection) ? PageRequest.of(pageNo, pageSize, Sort.by(sortBy).ascending()) : PageRequest.of(pageNo, pageSize, Sort.by(sortBy).descending());
        return repository.getTopTypeMoviePage(paging);
    }
    @Override
    public Page<ShowTimeTop> getAllTopShowTimePages(Integer pageNo, Integer pageSize, String sortBy, boolean sortDirection) {
        Pageable paging = (sortDirection) ? PageRequest.of(pageNo, pageSize, Sort.by(sortBy).ascending()) : PageRequest.of(pageNo, pageSize, Sort.by(sortBy).descending());
        return repository.getTopShowTimePage(paging);
    }

    @Override
    public List<MovieSales> getMovieSaleDate(String filterDate) {
        if("date".equals(filterDate)) {
            return repository.findMovieSalesByDate();
        } else if("month".equals(filterDate)) {
            return repository.findMovieSalesByMonth();
        } else if("year".equals(filterDate)) {
            return repository.findMovieSalesByYear();
        } else
            return repository.getMovieSales();
    }

    @Override
    public List<CustomerTop> getCustomerTopDate(String filterDate) {
        if("date".equals(filterDate)) {
            return repository.getTopCustomersByDate();
        } else if("month".equals(filterDate)) {
            return repository.getTopCustomersByMonth();
        } else if("year".equals(filterDate)) {
            return repository.getTopCustomersByYear();
        } else
            return repository.getTopCustomers();
    }

    @Override
    public List<MovieTopType> getMovieTypeDate(String filterDate) {
        if("date".equals(filterDate)) {
            return repository.getTopTypeMovieByDate();
        } else if("month".equals(filterDate)) {
            return repository.getTopTypeMovieByMonth();
        } else if("year".equals(filterDate)) {
            return repository.getTopTypeMovieByYear();
        } else
            return repository.getTopTypeMovie();
    }

    @Override
    public List<ShowTimeTop> getShowTimeDate(String filterDate) {
        if("date".equals(filterDate)) {
            return repository.getTopShowTimeByDate();
        } else if("month".equals(filterDate)) {
            return repository.getTopShowTimeByMonth();
        } else if("year".equals(filterDate)) {
            return repository.getTopShowTimeByYear();
        } else
            return repository.getTopShowTimeByDate();
    }

}
