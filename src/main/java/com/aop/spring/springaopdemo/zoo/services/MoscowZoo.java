package com.aop.spring.springaopdemo.zoo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class MoscowZoo extends AbstractZoos implements Zoo {

    @Autowired
    @Override
    public void setName(@Value("${moscow.zoo}") String name) {
        super.setName(name);
    }
}
