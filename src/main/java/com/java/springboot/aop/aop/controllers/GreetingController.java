package com.java.springboot.aop.aop.controllers;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.java.springboot.aop.aop.services.GrettingService;

@RestController
@RequestMapping("/greeting")
public class GreetingController {
  
  @Autowired
  private GrettingService grettingService;

  @GetMapping("/foo")
  public ResponseEntity<?> greet() {
    Map<String, String> response = Map.of("greeting", grettingService.greet("John Doe", "Hey there"));
    return ResponseEntity.status(HttpStatus.OK).body(response);
  }

  @GetMapping("/bar")
  public ResponseEntity<?> greetError() {
    Map<String, String> response = Map.of("greeting", grettingService.greetError("John Doe", "Hey there"));
    return ResponseEntity.status(HttpStatus.OK).body(response);
  }
}
