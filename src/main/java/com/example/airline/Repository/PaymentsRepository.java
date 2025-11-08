package com.example.airline.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.airline.Entities.Payments;

public interface PaymentsRepository extends JpaRepository<Payments, Long>{

}
