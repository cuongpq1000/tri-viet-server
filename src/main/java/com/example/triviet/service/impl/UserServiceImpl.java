package com.example.triviet.service.impl;

import com.example.triviet.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Override
    public String getUser() {
        return "Cuong yeu Vy lam";
    }
}
