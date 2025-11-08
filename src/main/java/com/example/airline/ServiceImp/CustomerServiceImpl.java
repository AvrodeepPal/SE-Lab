package com.example.airline.ServiceImp;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.airline.DTO.CustomerDTO;
import com.example.airline.Entities.Customer;
import com.example.airline.Repository.CustomerRepository;
import com.example.airline.Service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService{
    private CustomerRepository repository;

    public CustomerServiceImpl(CustomerRepository repository) {
        this.repository = repository;
    }

    // Convert Entity to DTO
    private CustomerDTO convertToDTO(Customer c) {
        CustomerDTO dto = new CustomerDTO();
        dto.setCustomerId(c.getCustomerId());
        dto.setName(c.getName());
        dto.setUsername(c.getUsername());
        dto.setAddress(c.getAddress());
        dto.setPhone(c.getPhone());
        dto.setDob(c.getDob() != null ? c.getDob().toString() : null);
        return dto;
    }

    // Convert DTO to Entity
    private void updateEntityFromDTO(Customer c, CustomerDTO dto) {
        c.setName(dto.getName());
        c.setUsername(dto.getUsername());
        c.setAddress(dto.getAddress());
        c.setPhone(dto.getPhone());
        if (dto.getDob() != null) {
            c.setDob(java.time.LocalDate.parse(dto.getDob()));
        }
    }

    @Override
    public List<CustomerDTO> getAllCustomers() {
        return repository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public CustomerDTO getCustomerById(Long id) {
        Customer c = repository.findById(id).orElseThrow();
        return convertToDTO(c);
    }

    @Override
    public CustomerDTO createCustomer(CustomerDTO dto) {
        Customer c = new Customer();
        updateEntityFromDTO(c, dto);
        repository.save(c);
        return convertToDTO(c);
    }

    @Override
    public CustomerDTO updateCustomer(Long id, CustomerDTO dto) {
        Customer c = repository.findById(id).orElseThrow();
        updateEntityFromDTO(c, dto);
        repository.save(c);
        return convertToDTO(c);
    }

    @Override
    public void deleteCustomer(Long id) {
        repository.deleteById(id);
    }
}
