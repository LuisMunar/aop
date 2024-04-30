package com.java.springboot.aop.aop.services;

import org.springframework.stereotype.Service;

@Service
public class GrettingService implements GrettingServiceInterface {

  @Override
  public String greet(String name, String text) {
    String greeting = text + ", " + name + "!";
    System.out.println("greeting => " + greeting);
    return greeting;
  }

  @Override
  public String greetError(String name, String text) {
    throw new RuntimeException("Custom Error generated from greetError method");
  }
}
