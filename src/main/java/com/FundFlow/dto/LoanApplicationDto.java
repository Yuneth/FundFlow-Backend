package com.FundFlow.dto;

import lombok.Data;

// for submitting loan request (Request)
@Data
public class LoanApplicationDto {
    private double loanAmount;
    private int durationMonths;
    private String purpose;
    private double monthlyIncome;
    private int existingLoans;
}
