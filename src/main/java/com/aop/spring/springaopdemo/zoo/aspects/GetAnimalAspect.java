package com.aop.spring.springaopdemo.zoo.aspects;

import com.aop.spring.springaopdemo.zoo.animals.Animal;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
@Aspect
public class GetAnimalAspect {

    @Pointcut("@annotation(GetRegister)")
    private void doSomeRegisterBeforeGet() {
    }

    @Before("doSomeRegisterBeforeGet()")
    public void beforeGetMethodAdvice(JoinPoint joinPoint) {
        System.out.println("-------------------------------------------------------------------------");
        System.out.println("beforeGetMethodAdvice: перед тем, как забрали животное");
        StringBuilder sb;
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        System.out.println("methodSignature = " + signature);
        System.out.println("methodSignature.getName = " + signature.getName());
        System.out.println("methodSignature.getMethod = " + signature.getMethod());
        System.out.println("methodSignature.getReturnType = " + signature.getReturnType());
        System.out.println("methodSignature.getParameterTypes = " + Arrays.toString(signature.getParameterTypes()));

        if (signature.getName().equals("getAnimal")) {

            Object[] objects = joinPoint.getArgs();
            for (Object o : objects) {
                if (o instanceof Animal) {
                    Animal an = (Animal) o;
                    sb = new StringBuilder();
                    sb.append("Забираем животное: ");
                    sb.append(an.getName());
                    sb.append(" размер животного: ");
                    sb.append(an.getSize());
                    sb.append("см.");
                    System.out.println(sb.toString());
                } else if (o instanceof String) {
                    System.out.println("Животное забрал человек с Именем: " + o.toString());
                }
            }
        } else if (signature.getName().equals("getPicture")) {
            System.out.println("beforeGetPicture : перед получением фотографии");
        }
    }
}
