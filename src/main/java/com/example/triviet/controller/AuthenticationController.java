package com.example.triviet.controller;

import com.example.triviet.dto.request.AuthenticationRequest;
import com.example.triviet.dto.request.RegisterRequest;
import com.example.triviet.dto.response.AuthenticationResponse;
import com.example.triviet.service.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
public class AuthenticationController {

  private final AuthenticationService authenticationService;

  @Autowired
  public AuthenticationController(AuthenticationService authenticationService) {
    this.authenticationService = authenticationService;
  }

  @PostMapping("/register")
  public ResponseEntity<AuthenticationResponse> register(@RequestBody RegisterRequest request) {
    return new ResponseEntity<>(authenticationService.register(request), HttpStatus.OK);
  }

  @PostMapping("/authenticate")
  public ResponseEntity<AuthenticationResponse> authenticate(
      @RequestBody AuthenticationRequest request) {
    return new ResponseEntity<>(authenticationService.authenticate(request), HttpStatus.OK);
  }
}
