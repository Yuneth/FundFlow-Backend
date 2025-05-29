package com.FundFlow.service;

import com.FundFlow.entity.User;
public interface UserService {
    User findByUsername(String username);
    User register(User user);
}
