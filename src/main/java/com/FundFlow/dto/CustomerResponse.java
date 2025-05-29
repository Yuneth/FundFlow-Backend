package com.FundFlow.dto;

import lombok.Data;

// returned to frontend (Response)
@Data
public class CustomerResponse {

    private Long id;
    private String name;
    private String nic;
    private String email;
    private double monthlyIncome;
    private int creditScore;
    private String username; // for reference
}
