package com.FundFlow.dto;

import lombok.Data;

// for /auth/login
@Data
public class LoginRequest {
    private String username;
    private String password;
}
