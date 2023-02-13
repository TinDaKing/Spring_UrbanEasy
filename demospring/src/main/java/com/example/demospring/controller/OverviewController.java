package com.example.demospring.controller;

import com.example.demospring.model.BookingStatisticInterface;
import com.example.demospring.model.CategoryStatisticInterface;
import com.example.demospring.model.OverviewInterface;
import com.example.demospring.repository.OverviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class OverviewController {
    @Autowired
    private OverviewRepository  overviewRepository;

    @GetMapping("/overview")
    public OverviewInterface getOverviewData(){
        return overviewRepository.selectOverviewData();
    }

    @GetMapping("/overview/booking-chart")
    public List<BookingStatisticInterface> getBookingData(){
        return overviewRepository.selectBookingStatistic();
    }

    @GetMapping("/overview/category-chart")
    public List<CategoryStatisticInterface> getCategoryData(){
        return overviewRepository.selectCategoryStatistic();
    }
}
