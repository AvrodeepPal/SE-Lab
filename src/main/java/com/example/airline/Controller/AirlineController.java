package com.example.airline.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.airline.Entities.Airline;
import com.example.airline.Repository.AirlineRepository;

@RestController
@RequestMapping("/api/airlines")
public class AirlineController {
    @Autowired private AirlineRepository airlineRepository;

    @GetMapping
    public List<Airline> getAllAirlines() {
        return airlineRepository.findAll();
    }

    @PostMapping
    public Airline createAirline(@RequestBody Airline airline) {
        return airlineRepository.save(airline);
    }
}

