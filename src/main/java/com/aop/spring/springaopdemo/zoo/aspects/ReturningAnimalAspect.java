package com.aop.spring.springaopdemo.zoo.aspects;

import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class ReturningAnimalAspect {

    @Pointcut("@annotation(ReturnRegister)")
    private void doSomeRegisterAfterThrowingReturn() {
    }

    @AfterThrowing(pointcut = "doSomeRegisterAfterThrowingReturn()", throwing = "exception")
    public void afterThrowingMethodAdvice(Throwable exception) {
        System.out.println("Advice couch " + exception.getMessage());
    }
}
