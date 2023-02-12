package com.example.demospring.repository;

import com.example.demospring.entity.Property;
import com.example.demospring.model.CategoryStatisticInterface;
import com.example.demospring.model.PropertyInterface;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PropertyReposity extends JpaRepository<Property, Long> {

    @Query(
            value="select p.id, a.url, p.name, p.city, p.country, p.default_price as price, p.view\n" +
                    "from property p join asset a on p.id =a.property_id\n" +
                    "where a.name='1'\n" +
                    "order by p.id desc;",
            nativeQuery = true
    )
    @Transactional
    List<PropertyInterface> selectAllProperty();

    @Modifying
    @Query(
            value="UPDATE property\n" +
                    "SET name=:name , city=:city, country=:country , price=:price\n" +
                    "WHERE id=:id",
            nativeQuery = true
    )
    @Transactional
    void updateProperty(String id, String name, String city, String country, double price);
}
