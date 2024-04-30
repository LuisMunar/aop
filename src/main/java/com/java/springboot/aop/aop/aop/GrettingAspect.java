package com.java.springboot.aop.aop.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.After;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class GrettingAspect {
  private Logger logger = LoggerFactory.getLogger(this.getClass());

  @Before("execution(* com.java.springboot.aop.aop.services.GrettingService.greet(..))")
  public void beforeGreeting(JoinPoint joinPoint) {
    String methodName = joinPoint.getSignature().getName();
    String args = joinPoint.getArgs().toString();
    logger.info("Before => " + methodName + " => " + args);
  }

  @After("execution(* com.java.springboot.aop.aop.services.GrettingService.greet(..))")
  public void afterGreeting(JoinPoint joinPoint) {
    String methodName = joinPoint.getSignature().getName();
    String args = joinPoint.getArgs().toString();
    logger.info("After => " + methodName + " => " + args);
  }
}
