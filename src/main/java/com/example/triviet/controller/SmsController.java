package com.example.triviet.controller;

import com.example.triviet.service.SendMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/v1/sendSMS", produces = MediaType.APPLICATION_JSON_VALUE)
public class SmsController {
  private final SendMessageService sendMessageService;

  @Autowired
  public SmsController(SendMessageService sendMessageService) {
    this.sendMessageService = sendMessageService;
  }

  @GetMapping(value = "/payment")
  public ResponseEntity<String> sendPayment() {
    return new ResponseEntity<>(sendMessageService.sendPayment(), HttpStatus.OK);
  }
}
