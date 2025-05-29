package com.FundFlow.repository;

import com.FundFlow.entity.LoanApplication;
import com.FundFlow.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
public interface LoanApplicationRepository extends JpaRepository<LoanApplication, Long>{
        List<LoanApplication> findByUser(User user);
        List<LoanApplication> findByStatus(String status);
}
