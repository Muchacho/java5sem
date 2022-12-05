package com.example.studyapp.Aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

@Aspect
@Slf4j
@Component
public class GeneralLogAspect {
    @Pointcut("execution(* com.example.studyapp.Controllers.GradeController.*(..))")
    public void loggingPointCut(){}


    @Before("loggingPointCut()")
    public void before(JoinPoint joinPoint) {
        log.info("Before method invoked::"+joinPoint.getSignature());
    }

    @After("loggingPointCut()")
    public void after(JoinPoint joinPoint) {
        log.info("After method invoked::"+joinPoint.getSignature());
    }
    @Pointcut("execution(* com.example.studyapp.*.*.*(..))")
    public void loggingExceptionsPointCut(){}

    @AfterThrowing(value = "loggingExceptionsPointCut()",throwing = "e")
    public void afterThrowing(JoinPoint joinPoint,Exception e) {
        log.info("Method::"+joinPoint.getSignature() + "throw error:" + e.getMessage());
    }

}