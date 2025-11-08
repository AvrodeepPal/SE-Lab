package com.example.airline.Entities;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Flight {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long flightId;

    private String source;
    private String destination;
    private LocalDate date;
    private LocalTime time;

    @ManyToOne
    @JoinColumn(name = "airlineId")
    private Airline airline;

    @OneToMany(mappedBy = "flight")
    private List<Reservation> reservations;

    @OneToMany(mappedBy = "flight")
    private List<Payments> payments;
}

