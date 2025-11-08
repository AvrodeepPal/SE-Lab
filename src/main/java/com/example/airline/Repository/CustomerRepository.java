package com.example.airline.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.airline.Entities.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long>{

}
