package com.java.springboot.aop.aop.controllers;

import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/greeting")
public class GreetingController {

  @GetMapping("/foo")
  public ResponseEntity<?> greet() {
    Map<String, String> response = Map.of("greeting", "Hello, World!");
    return ResponseEntity.status(HttpStatus.OK).body(response);
  }
}
