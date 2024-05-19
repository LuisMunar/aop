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

  @Before("PointCuts.greetingLoggerPointcut()")
  public void before() {
    logger.info("Before method execution I");
  }

  @After("PointCuts.greetingLoggerPointcut()")
  public void after() {
    logger.info("After method execution I");
  }

  @AfterReturning("PointCuts.greetingLoggerPointcut()")
  public void afterReturning() {
    logger.info("After returning method execution I");
  }

  @AfterThrowing("PointCuts.greetingLoggerPointcut()")
  public void afterThrowing() {
    logger.info("After throwing method execution I");
  }
}
