package com.example.airline.ServiceImp;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.airline.DTO.ReservationDTO;
import com.example.airline.Entities.Customer;
import com.example.airline.Entities.Flight;
import com.example.airline.Entities.Payments;
import com.example.airline.Entities.Reservation;
import com.example.airline.Repository.CustomerRepository;
import com.example.airline.Repository.FlightRepository;
import com.example.airline.Repository.PaymentsRepository;
import com.example.airline.Repository.ReservationRepository;
import com.example.airline.Service.ReservationService;

@Service
public class ReservationServiceImpl implements ReservationService{
    private final ReservationRepository reservationRepository;
    private final CustomerRepository customerRepository;
    private final FlightRepository flightRepository;
    private final PaymentsRepository paymentsRepository;

    public ReservationServiceImpl(ReservationRepository reservationRepository, CustomerRepository customerRepository,
                                  FlightRepository flightRepository, PaymentsRepository paymentsRepository) {
        this.reservationRepository = reservationRepository;
        this.customerRepository = customerRepository;
        this.flightRepository = flightRepository;
        this.paymentsRepository = paymentsRepository;
    }

    private ReservationDTO convertToDTO(Reservation reservation) {
        ReservationDTO dto = new ReservationDTO();
        dto.setReservationId(reservation.getReservationId());
        dto.setCustomerId(reservation.getCustomer() != null ? reservation.getCustomer().getCustomerId() : null);
        dto.setFlightId(reservation.getFlight() != null ? reservation.getFlight().getFlightId() : null);
        dto.setPaymentId(reservation.getPayment() != null ? reservation.getPayment().getPayId() : null);
        return dto;
    }

    private void updateEntityFromDTO(Reservation reservation, ReservationDTO dto) {
        Customer customer = customerRepository.findById(dto.getCustomerId()).orElseThrow();
        Flight flight = flightRepository.findById(dto.getFlightId()).orElseThrow();
        Payments payment = paymentsRepository.findById(dto.getPaymentId()).orElseThrow();
        reservation.setCustomer(customer);
        reservation.setFlight(flight);
        reservation.setPayment(payment);
    }

    @Override
    public List<ReservationDTO> getAllReservations() {
        return reservationRepository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public ReservationDTO getReservationById(Long id) {
        Reservation reservation = reservationRepository.findById(id).orElseThrow();
        return convertToDTO(reservation);
    }

    @Override
    public ReservationDTO createReservation(ReservationDTO dto) {
        Reservation reservation = new Reservation();
        updateEntityFromDTO(reservation, dto);
        reservationRepository.save(reservation);
        return convertToDTO(reservation);
    }

    @Override
    public ReservationDTO updateReservation(Long id, ReservationDTO dto) {
        Reservation reservation = reservationRepository.findById(id).orElseThrow();
        updateEntityFromDTO(reservation, dto);
        reservationRepository.save(reservation);
        return convertToDTO(reservation);
    }

    @Override
    public void deleteReservation(Long id) {
        reservationRepository.deleteById(id);
    }
}
