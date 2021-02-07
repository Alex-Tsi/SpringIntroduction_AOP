package com.aop.spring.springaopdemo;

import com.aop.spring.springaopdemo.zoo.animals.Animal;
import com.aop.spring.springaopdemo.zoo.configs.ZooConfig;
import com.aop.spring.springaopdemo.zoo.services.Zoo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class SpringAopDemoApplication {

    public static void main(String[] args) {
       ConfigurableApplicationContext context = SpringApplication.run(SpringAopDemoApplication.class, args);
//        AnnotationConfigApplicationContext context =
//                new AnnotationConfigApplicationContext(ZooConfig.class);
        Zoo msc = context.getBean("moscowZoo", Zoo.class);
        Animal animal = context.getBean("tiger", Animal.class);
        System.out.println(msc.addAnimal(animal));
        msc.getAnimal(animal, "Alex");
    }
}
