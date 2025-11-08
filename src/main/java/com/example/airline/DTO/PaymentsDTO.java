package com.example.airline.DTO;

import java.time.LocalDate;
import java.time.LocalTime;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PaymentsDTO {
    private Long payId;

    @NotNull(message = "Amount is required")
    private Double amount;

    private String mode;
    private LocalDate date;
    private LocalTime time;
    private Long customerId;
    private Long flightId;
}
