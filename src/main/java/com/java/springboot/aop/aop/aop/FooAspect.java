package com.java.springboot.aop.aop.aop;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Order(1)
@Aspect
@Component
public class FooAspect {
  private Logger logger = LoggerFactory.getLogger(this.getClass());

  @Before("execution(* com.java.springboot.aop.aop.services.GrettingService.*(..))")
  public void before() {
    logger.info("Before method execution I");
  }

  @After("execution(* com.java.springboot.aop.aop.services.GrettingService.*(..))")
  public void after() {
    logger.info("After method execution I");
  }

  @AfterReturning("execution(* com.java.springboot.aop.aop.services.GrettingService.*(..))")
  public void afterReturning() {
    logger.info("After returning method execution I");
  }

  @AfterThrowing("execution(* com.java.springboot.aop.aop.services.GrettingService.*(..))")
  public void afterThrowing() {
    logger.info("After throwing method execution I");
  }
}
