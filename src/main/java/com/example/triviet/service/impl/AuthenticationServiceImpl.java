package com.example.triviet.service.impl;

import com.example.triviet.dto.request.AuthenticationRequest;
import com.example.triviet.dto.request.RegisterRequest;
import com.example.triviet.dto.response.AuthenticationResponse;
import com.example.triviet.entity.Role;
import com.example.triviet.entity.User;
import com.example.triviet.repository.RoleRepository;
import com.example.triviet.repository.UserRepository;
import com.example.triviet.service.AuthenticationService;
import com.example.triviet.service.JwtService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {
  private final UserRepository userRepository;
  private final PasswordEncoder passwordEncoder;

  private final JwtService jwtService;

  private final RoleRepository roleRepository;

  @Autowired
  public AuthenticationServiceImpl(
      UserRepository userRepository,
      PasswordEncoder passwordEncoder,
      JwtService jwtService,
      RoleRepository roleRepository) {
    this.userRepository = userRepository;
    this.jwtService = jwtService;
    this.passwordEncoder = passwordEncoder;
    this.roleRepository = roleRepository;
  }

  @Override
  @Transactional
  public AuthenticationResponse register(RegisterRequest request) {
    if(!ObjectUtils.isEmpty(userRepository.findByEmail(request.getEmail())) ){
      return null;
    }
    User user =
        User.builder()
            .firstName(request.getFirstName())
            .lastName(request.getFirstName())
            .email(request.getEmail())
            .password(passwordEncoder.encode(request.getPassword()))
            .build();
    Role userRole = roleRepository.getReferenceById(1);
    user.setRole(userRole);
    userRepository.save(user);
    return AuthenticationResponse.builder().token(jwtService.generateToken(user)).build();
  }

  @Override
  public AuthenticationResponse authenticate(AuthenticationRequest request) {
    AuthenticationResponse response = new AuthenticationResponse();
    return response;
  }
}
