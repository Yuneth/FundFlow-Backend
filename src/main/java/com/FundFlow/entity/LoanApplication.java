package com.FundFlow.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class LoanApplication {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private double loanAmount;
    private int durationMonths;
    private String purpose;
    private double monthlyIncome;
    private int existingLoans;

    private int score;
    private String status;
    private String recommendation;

    private LocalDateTime appliedAt;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
