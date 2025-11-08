package com.example.airline.ServiceImp;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.airline.DTO.PaymentsDTO;
import com.example.airline.Entities.Payments;
import com.example.airline.Repository.PaymentsRepository;
import com.example.airline.Service.PaymentsService;

@Service
public class PaymentServiceImpl implements PaymentsService{
    private final PaymentsRepository repository;

    public PaymentServiceImpl(PaymentsRepository repository) {
        this.repository = repository;
    }

    private PaymentsDTO convertToDTO(Payments payment) {
        PaymentsDTO dto = new PaymentsDTO();
        dto.setPayId(payment.getPayId());
        dto.setAmount(payment.getAmount());
        dto.setMode(payment.getMode());
        dto.setDate(payment.getDate() != null ? payment.getDate() : null);
        dto.setTime(payment.getTime() != null ? payment.getTime() : null);  // LocalTime to String
        dto.setCustomerId(payment.getCustomer() != null ? payment.getCustomer().getCustomerId() : null);
        dto.setFlightId(payment.getFlight() != null ? payment.getFlight().getFlightId() : null);
        return dto;
    }

    private void updateEntityFromDTO(Payments payment, PaymentsDTO dto) {
        payment.setAmount(dto.getAmount());
        payment.setMode(dto.getMode());
        if (dto.getDate() != null) {
            payment.setDate(dto.getDate());
        }
        if (dto.getTime() != null) {
            payment.setTime(dto.getTime()); 
        }
    }

    @Override
    public List<PaymentsDTO> getAllPayments() {
        return repository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public PaymentsDTO getPaymentById(Long id) {
        Payments payment = repository.findById(id).orElseThrow();
        return convertToDTO(payment);
    }

    @Override
    public PaymentsDTO createPayment(PaymentsDTO dto) {
        Payments payment = new Payments();
        updateEntityFromDTO(payment, dto);
        repository.save(payment);
        return convertToDTO(payment);
    }

    @Override
    public void deletePayment(Long id) {
        repository.deleteById(id);
    }
}
