package com.example.airline.Repository;

import java.time.LocalDate;
import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.airline.Entities.Flight;

public interface FlightRepository extends JpaRepository<Flight, Long>{

    Collection<Flight> findBySourceAndDestinationAndDate(String source, String destination, LocalDate localDate);

}
