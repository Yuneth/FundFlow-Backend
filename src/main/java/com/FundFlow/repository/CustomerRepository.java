package com.FundFlow.repository;

import com.FundFlow.entity.Customer;
import com.FundFlow.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
public interface CustomerRepository extends JpaRepository<Customer, Long> {
    Optional<Customer> findByUser(User user);
}
