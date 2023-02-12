package com.example.demospring.entity;

import jakarta.persistence.*;

@Entity
public class BookingChart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long month;
    private long year;
    @Column(name = "bookAmount")
    private long propertyId;

    public long getMonth() {
        return month;
    }

    public void setMonth(long month) {
        this.month = month;
    }

    public long getYear() {
        return year;
    }

    public void setYear(long year) {
        this.year = year;
    }

    public long getPropertyId() {
        return propertyId;
    }

    public void setPropertyId(long propertyId) {
        this.propertyId = propertyId;
    }
}
