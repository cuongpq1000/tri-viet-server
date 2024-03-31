package com.example.triviet.service;

import com.example.triviet.dto.request.AuthenticationRequest;
import com.example.triviet.dto.request.RegisterRequest;
import com.example.triviet.dto.response.AuthenticationResponse;

public interface AuthenticationService {
  AuthenticationResponse register(RegisterRequest request);

  AuthenticationResponse authenticate(AuthenticationRequest request);
}
