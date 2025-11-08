package com.example.airline.ServiceImp;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.airline.DTO.FlightDTO;
import com.example.airline.Entities.Flight;
import com.example.airline.Repository.FlightRepository;
import com.example.airline.Service.FlightService;

@Service
public class FlightServiceImpl implements FlightService{
    private FlightRepository repository;

    public FlightServiceImpl(FlightRepository repository) {
        this.repository = repository;
    }

    private FlightDTO convertToDTO(Flight flight) {
        FlightDTO dto = new FlightDTO();
        dto.setFlightId(flight.getFlightId());
        dto.setSource(flight.getSource());
        dto.setDestination(flight.getDestination());
        dto.setDate(flight.getDate() != null ? flight.getDate() : null);
        dto.setTime(flight.getTime());
        dto.setAirlineId(flight.getAirline() != null ? flight.getAirline().getAirlineId() : null);
        dto.setAirlineName(flight.getAirline() != null ? flight.getAirline().getName() : null);
        return dto;
    }

    private void updateEntityFromDTO(Flight flight, FlightDTO dto) {
        flight.setSource(dto.getSource());
        flight.setDestination(dto.getDestination());
        if (dto.getDate() != null) {
            flight.setDate(dto.getDate());
        }
        flight.setTime(dto.getTime());
    }

    @Override
    public List<FlightDTO> getAllFlights() {
        return repository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public FlightDTO getFlightById(Long id) {
        Flight flight = repository.findById(id).orElseThrow();
        return convertToDTO(flight);
    }

    @Override
    public FlightDTO createFlight(FlightDTO dto) {
        Flight flight = new Flight();
        updateEntityFromDTO(flight, dto);
        repository.save(flight);
        return convertToDTO(flight);
    }

    @Override
    public FlightDTO updateFlight(Long id, FlightDTO dto) {
        Flight flight = repository.findById(id).orElseThrow();
        updateEntityFromDTO(flight, dto);
        repository.save(flight);
        return convertToDTO(flight);
    }

    @Override
    public void deleteFlight(Long id) {
        repository.deleteById(id);
    }

    @Override
    public List<FlightDTO> searchFlights(String source, String destination, String date) {
        return repository.findBySourceAndDestinationAndDate(source, destination, LocalDate.parse(date)).stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }
}
