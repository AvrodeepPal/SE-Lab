package com.example.airline.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.airline.Entities.Airline;

public interface AirlineRepository extends JpaRepository<Airline, Long>{

}
