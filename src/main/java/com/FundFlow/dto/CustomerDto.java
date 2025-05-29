package com.FundFlow.dto;

import lombok.Data;

// for create/update customer (Request)
@Data
public class CustomerDto {
    private String name;
    private String nic;
    private String email;
    private double monthlyIncome;
}
