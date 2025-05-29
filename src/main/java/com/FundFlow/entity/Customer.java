package com.FundFlow.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Customer {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String nic;
    private String email;
    private double monthlyIncome;
    private int creditScore;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;
}
