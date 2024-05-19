package com.java.springboot.aop.aop.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class PointCuts {

  @Pointcut("execution(* com.java.springboot.aop.aop.services.GrettingService.*(..))")
  public void greetingLoggerPointcut() {}
}
