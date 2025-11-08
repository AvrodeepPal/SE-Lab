package com.example.airline.Service;

import java.util.List;

import com.example.airline.DTO.PaymentsDTO;

public interface PaymentsService {
    List<PaymentsDTO> getAllPayments();
    PaymentsDTO createPayment(PaymentsDTO paymentsDTO);
    PaymentsDTO getPaymentById(Long id);
    void deletePayment(Long id);
}
