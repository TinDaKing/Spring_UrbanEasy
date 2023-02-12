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
            value = "SELECT booking.id as bookingId, property.name as propertyName, user.user_name as userName, property.default_price as price, booking.date as dateBooked FROM Booking JOIN Property ON booking.property_id = property.id JOIN user ON user.id = booking.user_id",
            nativeQuery = true)
    List<TransactionInterface> getTransactionDetail();
}
