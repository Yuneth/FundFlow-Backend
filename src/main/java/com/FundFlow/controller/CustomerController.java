package com.FundFlow.controller;

import com.FundFlow.dto.*;
import com.FundFlow.entity.Customer;
import com.FundFlow.entity.User;
import com.FundFlow.service.CustomerService;
import com.FundFlow.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/customers")
//@CrossOrigin(origins = "http://localhost:3000")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @Autowired
    private UserService userService;

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping
    public ResponseEntity<CustomerResponse> create(@RequestBody CustomerDto dto) {
        User user = userService.findByUsername("admin");
        Customer customer = customerService.createCustomer(dto, user);
        return ResponseEntity.ok(toDto(customer));
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping
    public ResponseEntity<List<CustomerResponse>> getAll() {
        List<CustomerResponse> responseList = customerService.getAllCustomers()
                .stream().map(this::toDto).collect(Collectors.toList());
        return ResponseEntity.ok(responseList);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/{id}")
    public ResponseEntity<CustomerResponse> update(@PathVariable Long id, @RequestBody CustomerDto dto) {
        Customer customer = customerService.updateCustomer(id, dto);
        return ResponseEntity.ok(toDto(customer));
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        customerService.deleteCustomer(id);
        return ResponseEntity.noContent().build();
    }

    private CustomerResponse toDto(Customer c) {
        CustomerResponse dto = new CustomerResponse();
        dto.setId(c.getId());
        dto.setName(c.getName());
        dto.setEmail(c.getEmail());
        dto.setNic(c.getNic());
        dto.setMonthlyIncome(c.getMonthlyIncome());
        dto.setCreditScore(c.getCreditScore());
        dto.setUsername(c.getUser().getUsername());
        return dto;
    }
}
