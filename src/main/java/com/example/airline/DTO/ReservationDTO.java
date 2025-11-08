package com.example.airline.DTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ReservationDTO {
    private Long reservationId;
    private Long customerId;
    private String customerName;
    private Long flightId;
    private String flightName;
    private Long paymentId;
}
