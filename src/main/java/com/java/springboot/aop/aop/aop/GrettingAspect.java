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

  @Before("PointCuts.greetingLoggerPointcut()")
  public void beforeGreeting(JoinPoint joinPoint) {
    String methodName = joinPoint.getSignature().getName();
    String args = joinPoint.getArgs().toString();
    logger.info("Before II => " + methodName + " => " + args);
  }

  @AfterReturning("PointCuts.greetingLoggerPointcut()")
  public void afterReturningGreeting(JoinPoint joinPoint) {
    String methodName = joinPoint.getSignature().getName();
    String args = joinPoint.getArgs().toString();
    logger.info("After Returning II => " + methodName + " => " + args);
  }

  @AfterThrowing("PointCuts.greetingLoggerPointcut()")
  public void afterThrowingGreeting(JoinPoint joinPoint) {
    String methodName = joinPoint.getSignature().getName();
    String args = joinPoint.getArgs().toString();
    logger.info("After Throwing II => " + methodName + " => " + args);
  }

  @After("PointCuts.greetingLoggerPointcut()")
  public void afterGreeting(JoinPoint joinPoint) {
    String methodName = joinPoint.getSignature().getName();
    String args = joinPoint.getArgs().toString();
    logger.info("After II => " + methodName + " => " + args);
  }

  @Around("PointCuts.greetingLoggerPointcut()")
  public Object aroundGretting(ProceedingJoinPoint joinPoint) throws Throwable {
    try {
      String methodName = joinPoint.getSignature().getName();
      String args = joinPoint.getArgs().toString();
      logger.info("Around II => " + methodName + " => " + args);
      Object result = joinPoint.proceed();
      logger.info("Around result II => " + result);
      return result;
    } catch (Throwable e) {
      logger.error("Around error II => " + e.getMessage());
      throw e;
    }
  }
}
