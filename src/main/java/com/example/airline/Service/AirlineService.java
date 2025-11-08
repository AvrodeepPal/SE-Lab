package com.example.airline.Service;

import java.util.List;

import com.example.airline.DTO.AirlineDTO;

public interface AirlineService {
    List<AirlineDTO> getAllAirlines();
    AirlineDTO getAirlineById(Long id);
    AirlineDTO createAirline(AirlineDTO airlineDTO);
    AirlineDTO updateAirline(Long id, AirlineDTO airlineDTO);
    void deleteAirline(Long id);
}
