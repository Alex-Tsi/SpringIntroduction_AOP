package com.aop.spring.springaopdemo.zoo.animals;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
//@Scope("prototype")
public class Leon extends AbstractAnimals implements Animal {

    @Autowired
    protected Leon(@Value("${leon.name}") String name,
                   @Value("${leon.size}") int size) {
        super(name, size);
    }

    @Override
    public String voice() {
        return "Leon Argh!";
    }
}
