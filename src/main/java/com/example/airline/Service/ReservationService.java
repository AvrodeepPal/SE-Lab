package com.example.airline.Service;

import java.util.List;

import com.example.airline.DTO.ReservationDTO;

public interface ReservationService {
    List<ReservationDTO> getAllReservations();
    ReservationDTO createReservation(ReservationDTO reservationDTO);
    ReservationDTO getReservationById(Long id);
    ReservationDTO updateReservation(Long id, ReservationDTO dto);
    void deleteReservation(Long id);
}
