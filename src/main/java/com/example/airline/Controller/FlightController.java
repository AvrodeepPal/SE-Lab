package com.example.airline.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.airline.Entities.Flight;
import com.example.airline.Repository.FlightRepository;

@RestController
@RequestMapping("/api/flights")
public class FlightController {
    @Autowired private FlightRepository flightRepository;

    @GetMapping
    public List<Flight> getAllFlights() {
        return flightRepository.findAll();
    }

    @PostMapping
    public Flight createFlight(@RequestBody Flight flight) {
        return flightRepository.save(flight);
    }
}
