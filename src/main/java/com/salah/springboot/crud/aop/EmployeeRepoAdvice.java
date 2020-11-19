package com.salah.springboot.crud.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.stream.Stream;

@Aspect
@Slf4j
@Component
public class EmployeeRepoAdvice {

    @Pointcut("execution(* com.salah.springboot.crud.dao.EmployeeRepository.*(..))")
    private void daosPointCut() {
    }
    @Pointcut("execution(* com.salah.springboot.crud.service.EmployeeServiceRepo.*(..))")
    private void servicesPointCut() {
    }

    @Pointcut("execution(* com.salah.springboot.crud.controller.*.*(..))")
    private void controllersPointCut() {
    }


    @Before("servicesPointCut() || daosPointCut() || controllersPointCut()")
    private void beforePackages(JoinPoint joinPoint) {
        log.info("@Before  Method: " + joinPoint.getSignature().toString());
        StringBuilder stringBuilder = new StringBuilder("Args: ");
        Stream.of(joinPoint.getArgs()).forEach(stringBuilder::append);
        log.info(stringBuilder.toString());
    }

    @AfterReturning(pointcut ="servicesPointCut() || daosPointCut() ||  controllersPointCut()", returning = "result")
    private void afterPackages(JoinPoint joinPoint, Object result) {
        log.info("@After Method: " + joinPoint.getSignature().toString());
        log.info("result: " + result);
    }

    //    @Around("servicesPointCut() || daosPointCut() || controllersPointCut()")
//    private Object aroundPackages(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
//        log.info("Method: " + proceedingJoinPoint.getSignature().toString());
//
//        StringBuilder stringBuilder = new StringBuilder("Args: ");
//        Stream.of(proceedingJoinPoint.getArgs()).forEach(stringBuilder::append);
//        log.info(stringBuilder.toString());
//
//        final Object proceed = proceedingJoinPoint.proceed();
//        log.info("result: " + proceed);
//
//        return proceed;
//    }
}
