package com.example.demospring.repository;

import com.example.demospring.entity.Booking;
import com.example.demospring.model.TransactionInterface;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface TransactionRepository extends JpaRepository<Booking, Long> {
    @Query(
            value = "SELECT a.url as productImage, b.id as bookingId, p.name as propertyName, u.user_name as userName, p.default_price as price, b.date as dateBooked \n" +
                    "FROM booking b JOIN property p ON b.property_id = p.id \n" +
                    "JOIN user u ON u.id = b.user_id \n" +
                    "JOIN asset a ON a.property_id = p.id \n" +
                    "WHERE a.name = 1",
            nativeQuery = true)
    List<TransactionInterface> getTransactionDetail();
}
