package com.FundFlow.serviceImpl;

import com.FundFlow.dto.CustomerDto;
import com.FundFlow.entity.Customer;
import com.FundFlow.entity.User;
import com.FundFlow.repository.CustomerRepository;
import com.FundFlow.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class CustomerServiceImpl implements CustomerService{
    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public Customer createCustomer(CustomerDto dto, User user) {
        Customer customer = new Customer();
        customer.setName(dto.getName());
        customer.setEmail(dto.getEmail());
        customer.setNic(dto.getNic());
        customer.setMonthlyIncome(dto.getMonthlyIncome());
        customer.setCreditScore(new Random().nextInt(551) + 300); // 300–850
        customer.setUser(user);

        return customerRepository.save(customer);
    }

    @Override
    public Customer updateCustomer(Long id, CustomerDto dto) {
        Customer customer = customerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Customer not found"));
        customer.setName(dto.getName());
        customer.setEmail(dto.getEmail());
        customer.setNic(dto.getNic());
        customer.setMonthlyIncome(dto.getMonthlyIncome());
        return customerRepository.save(customer);
    }

    @Override
    public void deleteCustomer(Long id) {
        customerRepository.deleteById(id);
    }

    @Override
    public Customer getCustomerById(Long id) {
        return customerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Customer not found"));
    }

    @Override
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    @Override
    public Customer getCustomerByUser(User user) {
        return customerRepository.findByUser(user)
                .orElseThrow(() -> new RuntimeException("Customer not found for user"));
    }
}
