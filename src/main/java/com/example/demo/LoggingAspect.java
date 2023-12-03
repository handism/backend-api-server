package com.example.demo;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.AfterReturning;
import org.springframework.context.annotation.Configuration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Aspect
@Configuration
public class LoggingAspect {

    private static final Logger logger = LoggerFactory.getLogger(DummyController.class);

    @Before("execution(* com.example.demo.*.*(..))")
    public void logMethodEntry(JoinPoint joinPoint) {
        logger.info("Method Entry: {} | Arguments: {}", joinPoint.getSignature().toShortString(), joinPoint.getArgs());
    }

    @AfterReturning(pointcut = "execution(* com.example.demo.*.*(..))", returning = "result")
    public void logMethodExit(JoinPoint joinPoint, Object result) {
        logger.info("Method Exit: {} | Return Value: {}", joinPoint.getSignature().toShortString(), result);
    }
}
