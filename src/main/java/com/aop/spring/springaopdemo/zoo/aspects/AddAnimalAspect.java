package com.aop.spring.springaopdemo.zoo.aspects;

import com.aop.spring.springaopdemo.zoo.animals.Animal;
import com.aop.spring.springaopdemo.zoo.services.AbstractZoos;
import com.aop.spring.springaopdemo.zoo.services.Zoo;
import lombok.SneakyThrows;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;

@Component
@Aspect
public class AddAnimalAspect {

    @Pointcut("@annotation(AddRegister)")
    private void doSomeRegisterAroundAdd() {
    }

    @SneakyThrows
    @Around("doSomeRegisterAroundAdd()")
    public Object beforeAddMethodAdvice(ProceedingJoinPoint point) {
        StringBuilder builder = new StringBuilder();
        Object[] args = point.getArgs();
        Field privateNameZoo = AbstractZoos.class.getDeclaredField("name");
        privateNameZoo.setAccessible(true);
        String fieldVal = (String) privateNameZoo.get(point.getTarget());
        System.out.println("Trying to add animal in " + fieldVal);
        privateNameZoo.setAccessible(false);
        if (!(args[0] instanceof Animal)) throw new RuntimeException("Second argument must been Zoo");
        Animal current = (Animal) args[0];
        Object o = point.proceed();
        builder.append("Animal name is ");
        builder.append(o.toString());
        builder.append("\n");
        builder.append(current.voice());
        return builder.toString();
    }
}