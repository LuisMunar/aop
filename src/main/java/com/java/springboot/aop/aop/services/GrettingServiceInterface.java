package com.java.springboot.aop.aop.services;

public interface GrettingServiceInterface {
  String greet(String name, String text);
  String greetError(String name, String text);
}
