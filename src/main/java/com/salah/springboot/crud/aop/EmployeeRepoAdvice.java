package com.salah.springboot.crud.aop;

import com.salah.springboot.crud.logger.MyLogger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.util.stream.Stream;

@Aspect
@Component
public class EmployeeRepoAdvice {
    @Around("execution(* com.salah.springboot.crud.dao.EmployeeRepository.*(..))")
    public Object bla(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        MyLogger.log.info("Method signature: " + proceedingJoinPoint.getSignature().toString());
        StringBuilder stringBuilder = new StringBuilder("Args: ");
        Stream.of(proceedingJoinPoint.getArgs()).forEach(stringBuilder::append);
        MyLogger.log.info(stringBuilder.toString());
        Object result = proceedingJoinPoint.proceed();
        MyLogger.log.info("result: " + result);
        return result;

    }
}
