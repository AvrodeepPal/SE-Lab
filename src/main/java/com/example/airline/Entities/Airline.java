package com.example.airline.Entities;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Airline {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long airlineId;

    private String name;
    private String basedIn;
    private String email;
    private String contact;
    private String address;

    @OneToMany(mappedBy = "airline")
    private List<Flight> flights;
}

