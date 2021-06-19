package com.example.heroes.annotation;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Aspect
@Component
@Slf4j
public class TimerAnnotation {
    
    @Around("@annotation(Timer)")
    public Object timerLog(ProceedingJoinPoint joinPoint) throws Throwable {
        long start = System.currentTimeMillis();
        Object proceed = joinPoint.proceed();
        long time = System.currentTimeMillis() - start;
        log.info(joinPoint.getSignature() + " processed in " + time +"ms" );
        return proceed;
    }
}
