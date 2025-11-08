package com.example.airline.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.airline.Entities.Payments;
import com.example.airline.Repository.PaymentsRepository;

@RestController
@RequestMapping("/api/payments")
public class PaymentsController {
    @Autowired private PaymentsRepository paymentsRepository;

    @GetMapping
    public List<Payments> getAllPayments() {
        return paymentsRepository.findAll();
    }

    @PostMapping
    public Payments createPayment(@RequestBody Payments payment) {
        return paymentsRepository.save(payment);
    }
}

