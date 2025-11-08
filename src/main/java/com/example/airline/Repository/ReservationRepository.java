package com.example.airline.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.airline.Entities.Reservation;

public interface ReservationRepository extends JpaRepository<Reservation, Long>{

}
