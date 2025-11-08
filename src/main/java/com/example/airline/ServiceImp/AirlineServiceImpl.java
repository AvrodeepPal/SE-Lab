package com.example.airline.ServiceImp;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.airline.DTO.AirlineDTO;
import com.example.airline.Entities.Airline;
import com.example.airline.Repository.AirlineRepository;
import com.example.airline.Service.AirlineService;

@Service
public class AirlineServiceImpl implements AirlineService{
    private AirlineRepository repository;

    public AirlineServiceImpl(AirlineRepository repository) {
        this.repository = repository;
    }

    // Helper: convert Airline entity to DTO
    private AirlineDTO convertToDTO(Airline airline) {
        AirlineDTO dto = new AirlineDTO();
        dto.setAirlineId(airline.getAirlineId());
        dto.setName(airline.getName());
        dto.setBasedIn(airline.getBasedIn());
        dto.setEmail(airline.getEmail());
        dto.setContact(airline.getContact());
        dto.setAddress(airline.getAddress());
        return dto;
    }

    // Helper: update entity from DTO
    private void updateEntityFromDTO(Airline airline, AirlineDTO dto) {
        airline.setName(dto.getName());
        airline.setBasedIn(dto.getBasedIn());
        airline.setEmail(dto.getEmail());
        airline.setContact(dto.getContact());
        airline.setAddress(dto.getAddress());
    }

    @Override
    public List<AirlineDTO> getAllAirlines() {
        return repository.findAll().stream()
                         .map(this::convertToDTO)
                         .collect(Collectors.toList());
    }

    @Override
    public AirlineDTO getAirlineById(Long id) {
        Airline airline = repository.findById(id).orElseThrow();
        return convertToDTO(airline);
    }

    @Override
    public AirlineDTO createAirline(AirlineDTO dto) {
        Airline airline = new Airline();
        updateEntityFromDTO(airline, dto);
        repository.save(airline);
        return convertToDTO(airline);
    }

    @Override
    public AirlineDTO updateAirline(Long id, AirlineDTO dto) {
        Airline airline = repository.findById(id).orElseThrow();
        updateEntityFromDTO(airline, dto);
        repository.save(airline);
        return convertToDTO(airline);
    }

    @Override
    public void deleteAirline(Long id) {
        repository.deleteById(id);
    }
}
