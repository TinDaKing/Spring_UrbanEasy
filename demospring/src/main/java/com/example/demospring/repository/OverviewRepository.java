package com.example.demospring.repository;

import com.example.demospring.entity.Property;
import com.example.demospring.model.BookingStatisticInterface;
import com.example.demospring.model.CategoryStatisticInterface;
import com.example.demospring.model.OverviewInterface;
import com.example.demospring.model.UserInterface;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface OverviewRepository extends JpaRepository<Property,Long> {

    @Query(
            value="select v.totalVolumne, u.totalUser, p.totalProperty, b.totalBooking, r.totalReview\n" +
                    "from (SELECT sum(DATEDIFF(b.date_end, b.date_start)*p.default_price) as totalVolumne\n" +
                    "from booking b \n" +
                    "join property p on b.property_id = p.id) v, \n" +
                    "(select count(id) as totalUser \n" +
                    "from user) as u,\n" +
                    "(select count(id) as totalProperty\n" +
                    "from property) as p,\n" +
                    "(select count(id) as totalBooking\n" +
                    "from booking) as b,\n" +
                    "(select count(*) as totalReview\n" +
                    "from review) as r",
            nativeQuery = true
    )
    @Transactional
    OverviewInterface selectOverviewData();

    @Query(
            value="select c.Month, c.Year, count(b.date) as bookAmount from booking b join (SELECT MONTH(CURDATE()) AS 'Month', YEAR(CURDATE()) AS 'Year') as c\n" +
                    "where month(b.date) = c.Month and year(b.date) = c.Year\n" +
                    "group by c.Month, c.Year\n" +
                    "UNION\n" +
                    "select c.Month, c.Year, count(b.date) as bookAmount from booking b join (SELECT MONTH(DATE_SUB(CURDATE(), INTERVAL 1 MONTH)) AS 'Month', YEAR(DATE_SUB(CURDATE(), INTERVAL 1 MONTH)) AS 'Year') as c\n" +
                    "where month(b.date) = c.Month and year(b.date) = c.Year\n" +
                    "group by c.Month, c.Year\n" +
                    "UNION\n" +
                    "select c.Month, c.Year, count(b.date) as bookAmount from booking b join (SELECT MONTH(DATE_SUB(CURDATE(), INTERVAL 2 MONTH)) AS 'Month', YEAR(DATE_SUB(CURDATE(), INTERVAL 2 MONTH)) AS 'Year') as c\n" +
                    "where month(b.date) = c.Month and year(b.date) = c.Year\n" +
                    "group by c.Month, c.Year\n" +
                    "UNION\n" +
                    "select c.Month, c.Year, count(b.date) as bookAmount from booking b join (SELECT MONTH(DATE_SUB(CURDATE(), INTERVAL 3 MONTH)) AS 'Month', YEAR(DATE_SUB(CURDATE(), INTERVAL 3 MONTH)) AS 'Year') as c\n" +
                    "where month(b.date) = c.Month and year(b.date) = c.Year\n" +
                    "group by c.Month, c.Year\n" +
                    "UNION\n" +
                    "select c.Month, c.Year, count(b.date) as bookAmount from booking b join (SELECT MONTH(DATE_SUB(CURDATE(), INTERVAL 4 MONTH)) AS 'Month', YEAR(DATE_SUB(CURDATE(), INTERVAL 4 MONTH)) AS 'Year') as c\n" +
                    "where month(b.date) = c.Month and year(b.date) = c.Year\n" +
                    "group by c.Month, c.Year",
            nativeQuery = true
    )
    @Transactional
    List<BookingStatisticInterface> selectBookingStatistic();

    @Query(
            value="SELECT category_id as categoryId, c.name, COUNT(category_id)*100.0 / (SELECT COUNT(*) FROM Property) AS percentCategory\n" +
                    "FROM property join category c on category_id = c.id\n" +
                    "GROUP BY category_id\n" +
                    "order by category_id;",
            nativeQuery = true
    )
    @Transactional
    List<CategoryStatisticInterface> selectCategoryStatistic();
}
