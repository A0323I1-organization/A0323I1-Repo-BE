package a0323i1_cinema_professtional_be.repository.statistic;

import a0323i1_cinema_professtional_be.dto.statistics.CustomerTop;
import a0323i1_cinema_professtional_be.dto.statistics.MovieSales;
import a0323i1_cinema_professtional_be.dto.statistics.MovieTopType;
import a0323i1_cinema_professtional_be.dto.statistics.ShowTimeTop;
import a0323i1_cinema_professtional_be.entity.Movie;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface StatisticRepository extends PagingAndSortingRepository<Movie, Integer> {
    @Query(value = "SELECT m.movie_name as movieName," +
            " COUNT(t.ticket_id) AS countTicket," +
            " SUM(ts.type_seat_price) AS totalPriceTicket " +
            "FROM movie m " +
            "JOIN calendar_show cs ON m.movie_id = cs.movie_id " +
            "JOIN seat s ON cs.calendar_show_id = s.calendar_show_id " +
            "JOIN type_seat ts ON s.type_seat_id = ts.type_seat_id " +
            "JOIN ticket t ON s.seat_id = t.seat_id " +
            "GROUP BY m.movie_id " +
            "ORDER BY totalPriceTicket DESC;", nativeQuery = true)
    List<MovieSales> getMovieSales();

    @Query(value = "select \n" +
            "\tc.customer_id as customerId,\n" +
            "\tc.fullname as customerName,\n" +
            "    COUNT(t.ticket_id) as customerTotalTicket,\n" +
            "    SUM(ts.type_seat_price) as customerTotalPrice,\n" +
            "    c.point as point\n" +
            "FROM\n" +
            "\tcustomer c \n" +
            "JOIN \n" +
            "\tinvoice i on c.customer_id = i.customer_id\n" +
            "JOIN\n" +
            "\tticket t on i.invoice_id = t.invoice_id\n" +
            "JOIN\n" +
            "\tseat s on t.seat_id = s.seat_id\n" +
            "JOIN\n" +
            "\ttype_seat ts on s.type_seat_id = ts.type_seat_id\n" +
            "group by\n" +
            "c.customer_id\n" +
            "ORDER BY\n" +
            "\tpoint DESC;", nativeQuery = true)
    List<CustomerTop> getTopCustomers();

    @Query(value = "select\n" +
            "\tmt.movie_type_name as movieType,\n" +
            "    COUNT(t.ticket_id) as movieTypeTotalTicket\n" +
            "FROM\n" +
            "\tmovie_type mt\n" +
            "LEFT JOIN\n" +
            "\tmovie_type_detail mtd on mt.movie_type_id = mtd.movie_type_id\n" +
            "LEFT JOIN \n" +
            "\tmovie m on mtd.movie_id = m.movie_id\n" +
            "LEFT JOIN\n" +
            "\tcalendar_show cs on m.movie_id = cs.movie_id\n" +
            "LEFT JOIN \n" +
            "\tseat s on cs.calendar_show_id = s.calendar_show_id\n" +
            "LEFT JOIN\n" +
            "\tticket t on s.seat_id = t.ticket_id\n" +
            "group by\n" +
            "\tmt.movie_type_id\n" +
            "ORDER BY \n" +
            "\tmovieTypeTotalTicket desc;", nativeQuery = true)
    List<MovieTopType> getTopTypeMovie();

    @Query(value = "select\n" +
            "\tst.movie_time as showTimeDetail,\n" +
            "    COUNT(t.ticket_id) as showTimeTotalTicket\n" +
            "from\n" +
            "\tshow_time st\n" +
            "join\n" +
            "\tcalendar_show cs on st.show_time_id = cs.show_time_id\n" +
            "join\n" +
            "\tseat s on cs.calendar_show_id = s.calendar_show_id\n" +
            "join \n" +
            "\tticket t on s.seat_id = t.seat_id\n" +
            "group by\n" +
            "st.show_time_id\n" +
            "ORDER BY\n" +
            "\tshowTimeTotalTicket DESC;", nativeQuery = true)
    List<ShowTimeTop> getTopShowTime();

    @Query(value = "SELECT m.movie_name as movieName, COUNT(t.ticket_id) AS countTicket, SUM(ts.type_seat_price) AS totalPriceTicket FROM movie m JOIN calendar_show cs ON m.movie_id = cs.movie_id JOIN seat s ON cs.calendar_show_id = s.calendar_show_id JOIN type_seat ts ON s.type_seat_id = ts.type_seat_id JOIN ticket t ON s.seat_id = t.seat_id GROUP BY m.movie_id\n",
            countQuery = "SELECT m.movie_name as movieName, COUNT(t.ticket_id) AS countTicket, SUM(ts.type_seat_price) AS totalPriceTicket FROM movie m JOIN calendar_show cs ON m.movie_id = cs.movie_id JOIN seat s ON cs.calendar_show_id = s.calendar_show_id JOIN type_seat ts ON s.type_seat_id = ts.type_seat_id JOIN ticket t ON s.seat_id = t.seat_id GROUP BY m.movie_id\n", nativeQuery = true)
    Page<MovieSales> getMovieSalesPage(Pageable pageable);

    @Query(value = "select \n" +
            "\tc.customer_id as customerId,\n" +
            "\tc.fullname as customerName,\n" +
            "    COUNT(t.ticket_id) as customerTotalTicket,\n" +
            "    SUM(ts.type_seat_price) as customerTotalPrice,\n" +
            "    c.point as point\n" +
            "FROM\n" +
            "\tcustomer c \n" +
            "JOIN \n" +
            "\tinvoice i on c.customer_id = i.customer_id\n" +
            "JOIN\n" +
            "\tticket t on i.invoice_id = t.invoice_id\n" +
            "JOIN\n" +
            "\tseat s on t.seat_id = s.seat_id\n" +
            "JOIN\n" +
            "\ttype_seat ts on s.type_seat_id = ts.type_seat_id\n" +
            "group by\n" +
            "c.customer_id\n",
            countQuery = "select \n" +
                    "\tc.customer_id as customerId,\n" +
                    "\tc.fullname as customerName,\n" +
                    "    COUNT(t.ticket_id) as customerTotalTicket,\n" +
                    "    SUM(ts.type_seat_price) as customerTotalPrice,\n" +
                    "    c.point as point\n" +
                    "FROM\n" +
                    "\tcustomer c \n" +
                    "JOIN \n" +
                    "\tinvoice i on c.customer_id = i.customer_id\n" +
                    "JOIN\n" +
                    "\tticket t on i.invoice_id = t.invoice_id\n" +
                    "JOIN\n" +
                    "\tseat s on t.seat_id = s.seat_id\n" +
                    "JOIN\n" +
                    "\ttype_seat ts on s.type_seat_id = ts.type_seat_id\n" +
                    "group by\n" +
                    "c.customer_id\n"
            , nativeQuery = true)
    Page<CustomerTop> getTopCustomersPage(Pageable pageable);

    @Query(value = "select\n" +
            "\tmt.movie_type_name as movieType,\n" +
            "    COUNT(t.ticket_id) as movieTypeTotalTicket\n" +
            "FROM\n" +
            "\tmovie_type mt\n" +
            "LEFT JOIN\n" +
            "\tmovie_type_detail mtd on mt.movie_type_id = mtd.movie_type_id\n" +
            "LEFT JOIN \n" +
            "\tmovie m on mtd.movie_id = m.movie_id\n" +
            "LEFT JOIN\n" +
            "\tcalendar_show cs on m.movie_id = cs.movie_id\n" +
            "LEFT JOIN \n" +
            "\tseat s on cs.calendar_show_id = s.calendar_show_id\n" +
            "LEFT JOIN\n" +
            "\tticket t on s.seat_id = t.seat_id\n" +
            "group by\n" +
            "\tmt.movie_type_id\n",
            countQuery = "select\n" +
                    "\tmt.movie_type_name as movieType,\n" +
                    "    COUNT(t.ticket_id) as movieTypeTotalTicket\n" +
                    "FROM\n" +
                    "\tmovie_type mt\n" +
                    "LEFT JOIN\n" +
                    "\tmovie_type_detail mtd on mt.movie_type_id = mtd.movie_type_id\n" +
                    "LEFT JOIN \n" +
                    "\tmovie m on mtd.movie_id = m.movie_id\n" +
                    "LEFT JOIN\n" +
                    "\tcalendar_show cs on m.movie_id = cs.movie_id\n" +
                    "LEFT JOIN \n" +
                    "\tseat s on cs.calendar_show_id = s.calendar_show_id\n" +
                    "LEFT JOIN\n" +
                    "\tticket t on s.seat_id = t.seat_id\n" +
                    "group by\n" +
                    "\tmt.movie_type_id\n"
            ,nativeQuery = true)
    Page<MovieTopType> getTopTypeMoviePage(Pageable pageable);

    @Query(value = "select\n" +
            "\tst.movie_time as showTimeDetail,\n" +
            "    COUNT(t.ticket_id) as showTimeTotalTicket\n" +
            "from\n" +
            "\tshow_time st\n" +
            "join\n" +
            "\tcalendar_show cs on st.show_time_id = cs.show_time_id\n" +
            "join\n" +
            "\tseat s on cs.calendar_show_id = s.calendar_show_id\n" +
            "join \n" +
            "\tticket t on s.seat_id = t.seat_id\n" +
            "group by\n" +
            "st.show_time_id\n",
            countQuery = "select\n" +
                    "\tst.movie_time as showTimeDetail,\n" +
                    "    COUNT(t.ticket_id) as showTimeTotalTicket\n" +
                    "from\n" +
                    "\tshow_time st\n" +
                    "join\n" +
                    "\tcalendar_show cs on st.show_time_id = cs.show_time_id\n" +
                    "join\n" +
                    "\tseat s on cs.calendar_show_id = s.calendar_show_id\n" +
                    "join \n" +
                    "\tticket t on s.seat_id = t.seat_id\n" +
                    "group by\n" +
                    "st.show_time_id\n"
            ,nativeQuery = true)
    Page<ShowTimeTop> getTopShowTimePage(Pageable pageable);

    @Query(value = "SELECT m.movie_name as movieName,\n" +
            " COUNT(t.ticket_id) AS countTicket,\n" +
            " SUM(ts.type_seat_price) AS totalPriceTicket\n" +
            " FROM movie m \n" +
            " JOIN calendar_show cs ON m.movie_id = cs.movie_id \n" +
            " JOIN seat s ON cs.calendar_show_id = s.calendar_show_id \n" +
            " JOIN type_seat ts ON s.type_seat_id = ts.type_seat_id \n" +
            " JOIN ticket t ON s.seat_id = t.seat_id \n" +
            " JOIN show_time st ON cs.show_time_id = st.show_time_id\n" +
            " join invoice iv on t.invoice_id = iv.invoice_id\n" +
            "\twhere date(iv.date_payment) = date(curdate())\n" +
            " GROUP BY m.movie_id ;", nativeQuery = true)
    List<MovieSales> findMovieSalesByDate();
    @Query(value = "SELECT m.movie_name as movieName,\n" +
            " COUNT(t.ticket_id) AS countTicket,\n" +
            " SUM(ts.type_seat_price) AS totalPriceTicket\n" +
            " FROM movie m \n" +
            " JOIN calendar_show cs ON m.movie_id = cs.movie_id \n" +
            " JOIN seat s ON cs.calendar_show_id = s.calendar_show_id \n" +
            " JOIN type_seat ts ON s.type_seat_id = ts.type_seat_id \n" +
            " JOIN ticket t ON s.seat_id = t.seat_id \n" +
            " JOIN show_time st ON cs.show_time_id = st.show_time_id\n" +
            " join invoice iv on t.invoice_id = iv.invoice_id\n" +
            "\twhere month(iv.date_payment) = month(curdate())\n" +
            " GROUP BY m.movie_id ;", nativeQuery = true)
    List<MovieSales> findMovieSalesByMonth();
    @Query(value = "SELECT m.movie_name as movieName,\n" +
            " COUNT(t.ticket_id) AS countTicket,\n" +
            " SUM(ts.type_seat_price) AS totalPriceTicket\n" +
            " FROM movie m \n" +
            " JOIN calendar_show cs ON m.movie_id = cs.movie_id \n" +
            " JOIN seat s ON cs.calendar_show_id = s.calendar_show_id \n" +
            " JOIN type_seat ts ON s.type_seat_id = ts.type_seat_id \n" +
            " JOIN ticket t ON s.seat_id = t.seat_id \n" +
            " JOIN show_time st ON cs.show_time_id = st.show_time_id\n" +
            " join invoice iv on t.invoice_id = iv.invoice_id\n" +
            "\twhere year(iv.date_payment) = year(curdate())\n" +
            " GROUP BY m.movie_id ;", nativeQuery = true)
    List<MovieSales> findMovieSalesByYear();

    @Query(value = "select \n" +
            "\tc.customer_id,\n" +
            "\tc.fullname,\n" +
            "    COUNT(t.ticket_id) as ticket_total,\n" +
            "    SUM(ts.type_seat_price) as total_pay,\n" +
            "    c.point\n" +
            "FROM\n" +
            "\tcustomer c \n" +
            "JOIN \n" +
            "\tinvoice i on c.customer_id = i.customer_id\n" +
            "JOIN\n" +
            "\tticket t on i.invoice_id = t.invoice_id\n" +
            "JOIN\n" +
            "\tseat s on t.seat_id = s.seat_id\n" +
            "JOIN\n" +
            "\tcalendar_show cs on s.calendar_show_id = cs.calendar_show_id\n" +
            "join\n" +
            "\tshow_time st ON cs.show_time_id = st.show_time_id\n" +
            "JOIN\n" +
            "\ttype_seat ts on s.type_seat_id = ts.type_seat_id\n" +
            "where date(st.show_date) = date(curdate())\n" +
            "group by\n" +
            "c.customer_id;", nativeQuery = true)
    List<CustomerTop> getTopCustomersByDate();
    @Query(value = "select \n" +
            "\tc.customer_id,\n" +
            "\tc.fullname,\n" +
            "    COUNT(t.ticket_id) as ticket_total,\n" +
            "    SUM(ts.type_seat_price) as total_pay,\n" +
            "    c.point\n" +
            "FROM\n" +
            "\tcustomer c \n" +
            "JOIN \n" +
            "\tinvoice i on c.customer_id = i.customer_id\n" +
            "JOIN\n" +
            "\tticket t on i.invoice_id = t.invoice_id\n" +
            "JOIN\n" +
            "\tseat s on t.seat_id = s.seat_id\n" +
            "JOIN\n" +
            "\tcalendar_show cs on s.calendar_show_id = cs.calendar_show_id\n" +
            "join\n" +
            "\tshow_time st ON cs.show_time_id = st.show_time_id\n" +
            "JOIN\n" +
            "\ttype_seat ts on s.type_seat_id = ts.type_seat_id\n" +
            "where month(st.show_date) = month(curdate())\n" +
            "group by\n" +
            "c.customer_id;", nativeQuery = true)
    List<CustomerTop> getTopCustomersByMonth();
    @Query(value = "select \n" +
            "c.customer_id,\n" +
            "c.fullname,\n" +
            "    COUNT(t.ticket_id) as ticket_total,\n" +
            "    SUM(ts.type_seat_price) as total_pay,\n" +
            "    c.point\n" +
            "FROM\n" +
            "\tcustomer c \n" +
            "JOIN \n" +
            "\tinvoice i on c.customer_id = i.customer_id\n" +
            "JOIN\n" +
            "\tticket t on i.invoice_id = t.invoice_id\n" +
            "JOIN\n" +
            "\tseat s on t.seat_id = s.seat_id\n" +
            "JOIN\n" +
            "\tcalendar_show cs on s.calendar_show_id = cs.calendar_show_id\n" +
            "join\n" +
            "\tshow_time st ON cs.show_time_id = st.show_time_id\n" +
            "JOIN\n" +
            "\ttype_seat ts on s.type_seat_id = ts.type_seat_id\n" +
            "where year(st.show_date) = year(curdate())\n" +
            "group by\n" +
            "c.customer_id;", nativeQuery = true)
    List<CustomerTop> getTopCustomersByYear();

    @Query(value = "select\n" +
            "\tmt.movie_type_name as movieType,\n" +
            "    COUNT(t.ticket_id) as movieTypeTotalTicket\n" +
            "FROM\n" +
            "\tmovie_type mt\n" +
            "LEFT JOIN\n" +
            "\tmovie_type_detail mtd on mt.movie_type_id = mtd.movie_type_id\n" +
            "LEFT JOIN \n" +
            "\tmovie m on mtd.movie_id = m.movie_id\n" +
            "LEFT JOIN\n" +
            "\tcalendar_show cs on m.movie_id = cs.movie_id\n" +
            "LEFT JOIN \n" +
            "\tseat s on cs.calendar_show_id = s.calendar_show_id\n" +
            "LEFT JOIN\n" +
            "\tticket t on s.seat_id = t.seat_id\n" +
            "LEFT JOIN\n" +
            "\tinvoice iv on t.invoice_id = iv.invoice_id\n" +
            "where date(iv.date_payment) = date(curdate())\n" +
            "group by\n" +
            "\tmt.movie_type_id;", nativeQuery = true)
    List<MovieTopType> getTopTypeMovieByDate();
    @Query(value = "select\n" +
            "\tmt.movie_type_name as movieType,\n" +
            "    COUNT(t.ticket_id) as movieTypeTotalTicket\n" +
            "FROM\n" +
            "\tmovie_type mt\n" +
            "LEFT JOIN\n" +
            "\tmovie_type_detail mtd on mt.movie_type_id = mtd.movie_type_id\n" +
            "LEFT JOIN \n" +
            "\tmovie m on mtd.movie_id = m.movie_id\n" +
            "LEFT JOIN\n" +
            "\tcalendar_show cs on m.movie_id = cs.movie_id\n" +
            "LEFT JOIN \n" +
            "\tseat s on cs.calendar_show_id = s.calendar_show_id\n" +
            "LEFT JOIN\n" +
            "\tticket t on s.seat_id = t.seat_id\n" +
            "LEFT JOIN\n" +
            "\tinvoice iv on t.invoice_id = iv.invoice_id\n" +
            "where month(iv.date_payment) = month(curdate())\n" +
            "group by\n" +
            "\tmt.movie_type_id;", nativeQuery = true)
    List<MovieTopType> getTopTypeMovieByMonth();
    @Query(value = "select\n" +
            "\tmt.movie_type_name as movieType,\n" +
            "    COUNT(t.ticket_id) as movieTypeTotalTicket\n" +
            "FROM\n" +
            "\tmovie_type mt\n" +
            "LEFT JOIN\n" +
            "\tmovie_type_detail mtd on mt.movie_type_id = mtd.movie_type_id\n" +
            "LEFT JOIN \n" +
            "\tmovie m on mtd.movie_id = m.movie_id\n" +
            "LEFT JOIN\n" +
            "\tcalendar_show cs on m.movie_id = cs.movie_id\n" +
            "LEFT JOIN \n" +
            "\tseat s on cs.calendar_show_id = s.calendar_show_id\n" +
            "LEFT JOIN\n" +
            "\tticket t on s.seat_id = t.seat_id\n" +
            "LEFT JOIN\n" +
            "\tinvoice iv on t.invoice_id = iv.invoice_id\n" +
            "where year(iv.date_payment) = year(curdate())\n" +
            "group by\n" +
            "\tmt.movie_type_id;", nativeQuery = true)
    List<MovieTopType> getTopTypeMovieByYear();

    @Query(value = "SELECT \n" +
            "    st.movie_time AS showTimeDetail,\n" +
            "    COUNT(t.ticket_id) AS showTimeTotalTicket\n" +
            "FROM\n" +
            "    show_time st\n" +
            "        JOIN\n" +
            "    calendar_show cs ON st.show_time_id = cs.show_time_id\n" +
            "        JOIN\n" +
            "    seat s ON cs.calendar_show_id = s.calendar_show_id\n" +
            "        JOIN\n" +
            "    ticket t ON s.seat_id = t.seat_id\n" +
            "        JOIN\n" +
            "    invoice iv ON t.invoice_id = iv.invoice_id\n" +
            "WHERE\n" +
            "    date(iv.date_payment) = date(CURDATE())\n" +
            "GROUP BY st.show_time_id;", nativeQuery = true)
    List<ShowTimeTop> getTopShowTimeByDate();
    @Query(value = "SELECT \n" +
            "    st.movie_time AS showTimeDetail,\n" +
            "    COUNT(t.ticket_id) AS showTimeTotalTicket\n" +
            "FROM\n" +
            "    show_time st\n" +
            "        JOIN\n" +
            "    calendar_show cs ON st.show_time_id = cs.show_time_id\n" +
            "        JOIN\n" +
            "    seat s ON cs.calendar_show_id = s.calendar_show_id\n" +
            "        JOIN\n" +
            "    ticket t ON s.seat_id = t.seat_id\n" +
            "        JOIN\n" +
            "    invoice iv ON t.invoice_id = iv.invoice_id\n" +
            "WHERE\n" +
            "    month(iv.date_payment) = month(CURDATE())\n" +
            "GROUP BY st.show_time_id;", nativeQuery = true)
    List<ShowTimeTop> getTopShowTimeByMonth();
    @Query(value = "SELECT \n" +
            "    st.movie_time AS showTimeDetail,\n" +
            "    COUNT(t.ticket_id) AS showTimeTotalTicket\n" +
            "FROM\n" +
            "    show_time st\n" +
            "        JOIN\n" +
            "    calendar_show cs ON st.show_time_id = cs.show_time_id\n" +
            "        JOIN\n" +
            "    seat s ON cs.calendar_show_id = s.calendar_show_id\n" +
            "        JOIN\n" +
            "    ticket t ON s.seat_id = t.seat_id\n" +
            "        JOIN\n" +
            "    invoice iv ON t.invoice_id = iv.invoice_id\n" +
            "WHERE\n" +
            "    year(iv.date_payment) = year(CURDATE())\n" +
            "GROUP BY st.show_time_id;", nativeQuery = true)
    List<ShowTimeTop> getTopShowTimeByYear();
}
