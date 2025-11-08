package com.example.airline.DTO;

import java.time.LocalDate;
import java.time.LocalTime;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FlightDTO {
    private Long flightId;

    @NotBlank(message = "Source is required")
    private String source;

    @NotBlank(message = "Destination is required")
    private String destination;

    private LocalDate date; // Use ISO string, or LocalDate with @DateTimeFormat
    private LocalTime time; // Use LocalTime/String
    private Long airlineId;
    private String airlineName;
}
