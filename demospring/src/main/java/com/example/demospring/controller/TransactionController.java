package com.example.demospring.controller;

import com.example.demospring.model.TransactionInterface;
import com.example.demospring.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class TransactionController {
    @Autowired
    TransactionRepository transactionRepository;

    @GetMapping("/transaction")
    List<TransactionInterface> getDetails() {

        return transactionRepository.getTransactionDetail();
    }
}
