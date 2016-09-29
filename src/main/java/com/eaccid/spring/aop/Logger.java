package com.eaccid.spring.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class Logger {

    @Pointcut("execution(* com.eaccid.spring.aop.Camera.snap())")
    public void cameraSnap() {
    }


    @Before("cameraSnap()")
    public void beforeAdvice() {
        System.out.println("Before advice...");
    }

    @After("cameraSnap()")
    public void afterAdvice() {
        System.out.println("After advice...");
    }

    @AfterReturning("cameraSnap()") //if method without thrown exceptions
    public void afterReturningAdvice() {
        System.out.println("After returning advice...");
    }

    @AfterThrowing("cameraSnap()") //if method without thrown exceptions
    public void afterThrowingAdvice() {
        System.out.println("After throwing advice...");
    }

    @Around("cameraSnap()") //if method without thrown exceptions
    public void aroundAdvice(ProceedingJoinPoint p) {
        System.out.println("Around advice (before)...");

        try {
            p.proceed();
        } catch (Throwable e) {
            System.out.println("In around advice: " + e.getMessage());
        }

        System.out.println("Around advice (after)...");
    }

}
