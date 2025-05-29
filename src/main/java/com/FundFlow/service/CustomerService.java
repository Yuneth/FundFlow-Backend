package com.FundFlow.service;

import com.FundFlow.dto.CustomerDto;
import com.FundFlow.entity.Customer;
import com.FundFlow.entity.User;

import java.util.List;

public interface CustomerService {
    Customer createCustomer(CustomerDto dto, User user);
    Customer updateCustomer(Long id, CustomerDto dto);
    void deleteCustomer(Long id);
    Customer getCustomerById(Long id);
    List<Customer> getAllCustomers();
    Customer getCustomerByUser(User user);
}
