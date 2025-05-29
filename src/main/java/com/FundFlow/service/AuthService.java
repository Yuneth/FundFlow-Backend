package com.FundFlow.service;

import com.FundFlow.dto.AuthResponse;
import com.FundFlow.dto.LoginRequest;
import com.FundFlow.entity.User;
public interface AuthService {
    AuthResponse login(LoginRequest request);
    User register(User user);
}
