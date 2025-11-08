package com.example.airline.DTO;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AirlineDTO {
    private Long airlineId;

    @NotBlank(message = "Airline name is required")
    private String name;

    private String basedIn;
    private String email;
    private String contact;
    private String address;
}
