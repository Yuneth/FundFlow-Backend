package com.FundFlow.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Map;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreditScoreLog {
    @Id
    private String id;

    private Long userId;
    private int score;
    private String status;
    private String recommendation;
    private Map<String, Object> input;
    private LocalDateTime timestamp;
}
