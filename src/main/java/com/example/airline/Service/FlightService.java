package com.example.airline.Service;

import java.util.List;

import com.example.airline.DTO.FlightDTO;

public interface FlightService {
    List<FlightDTO> getAllFlights();
    FlightDTO getFlightById(Long id);
    FlightDTO createFlight(FlightDTO flightDTO);
    List<FlightDTO> searchFlights(String source, String destination, String date);
    FlightDTO updateFlight(Long id, FlightDTO dto);
    void deleteFlight(Long id);
}
