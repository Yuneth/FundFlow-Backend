package com.FundFlow.dto;

import com.FundFlow.entity.Role;
import lombok.Data;

@Data
public class UserRegistrationRequest {
    private String username;
    private String password;
    private Role role;
}
