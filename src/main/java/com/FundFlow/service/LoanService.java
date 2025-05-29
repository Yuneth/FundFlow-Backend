package com.FundFlow.service;

import com.FundFlow.dto.LoanApplicationDto;
import com.FundFlow.entity.LoanApplication;
import com.FundFlow.entity.User;

import java.util.List;
public interface LoanService {
    LoanApplication applyForLoan(LoanApplicationDto dto, User user);
    List<LoanApplication> getLoansByUser(User user);
    List<LoanApplication> getAllLoans();

    LoanApplication updateLoanStatus(Long id, String status);

}
