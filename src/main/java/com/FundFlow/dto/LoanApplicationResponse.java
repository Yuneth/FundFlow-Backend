package com.FundFlow.dto;

import lombok.Data;
import java.time.LocalDateTime;

// sent to frontend after loan is processed (Response)
@Data

public class LoanApplicationResponse {
    private Long id;
    private double loanAmount;
    private int durationMonths;
    private String purpose;
    private int existingLoans;
    private double monthlyIncome;


    private int score;
    private String status;
    private String recommendation;

    private LocalDateTime appliedAt;
    private String username; // to identify owner
}
