package com.example.triviet.service.impl;

import com.example.triviet.service.SendMessageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class SendMessageServiceIml implements SendMessageService {

  @Override
  public String sendPayment() {
    return "successfully";
  }
}
