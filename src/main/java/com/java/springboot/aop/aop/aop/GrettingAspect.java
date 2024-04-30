package com.java.springboot.aop.aop.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Order(2)
@Aspect
@Component
public class GrettingAspect {
  private Logger logger = LoggerFactory.getLogger(this.getClass());

  @Before("execution(* com.java.springboot.aop.aop.services.GrettingService.*(..))")
  public void beforeGreeting(JoinPoint joinPoint) {
    String methodName = joinPoint.getSignature().getName();
    String args = joinPoint.getArgs().toString();
    logger.info("Before => " + methodName + " => " + args);
  }

  @AfterReturning("execution(* com.java.springboot.aop.aop.services.GrettingService.*(..))")
  public void afterReturningGreeting(JoinPoint joinPoint) {
    String methodName = joinPoint.getSignature().getName();
    String args = joinPoint.getArgs().toString();
    logger.info("After Returning => " + methodName + " => " + args);
  }

  @AfterThrowing("execution(* com.java.springboot.aop.aop.services.GrettingService.*(..))")
  public void afterThrowingGreeting(JoinPoint joinPoint) {
    String methodName = joinPoint.getSignature().getName();
    String args = joinPoint.getArgs().toString();
    logger.info("After Throwing => " + methodName + " => " + args);
  }

  @After("execution(* com.java.springboot.aop.aop.services.GrettingService.*(..))")
  public void afterGreeting(JoinPoint joinPoint) {
    String methodName = joinPoint.getSignature().getName();
    String args = joinPoint.getArgs().toString();
    logger.info("After => " + methodName + " => " + args);
  }

  @Around("execution(* com.java.springboot.aop.aop.services.GrettingService.*(..))")
  public Object aroundGretting(ProceedingJoinPoint joinPoint) throws Throwable {
    try {
      String methodName = joinPoint.getSignature().getName();
      String args = joinPoint.getArgs().toString();
      logger.info("Around => " + methodName + " => " + args);
      Object result = joinPoint.proceed();
      logger.info("Around result => " + result);
      return result;
    } catch (Throwable e) {
      logger.error("Around error => " + e.getMessage());
      throw e;
    }
  }
}
