package com.aop.spring.springaopdemo.zoo.services;

import com.aop.spring.springaopdemo.zoo.animals.Animal;
import com.aop.spring.springaopdemo.zoo.aspects.AddRegister;
import com.aop.spring.springaopdemo.zoo.aspects.GetRegister;
import com.aop.spring.springaopdemo.zoo.aspects.ReturnRegister;

public abstract class AbstractZoos implements Zoo {

    private String name;

    @GetRegister
    @Override
    public void getAnimal(Animal animal, String name) {
        System.out.println("Get animal: " + animal.getName() + " with " + animal.getSize());
        System.out.println("From " + name);
    }

    @Override
    public void getPicture() {
        System.out.println("Getting picture in " + name);
    }

    @AddRegister
    @Override
    public String addAnimal(Animal animal) {
        System.out.println("Added animal " + animal.getClass().getSimpleName());
        return animal.getName();
    }

    @ReturnRegister
    @Override
    public void returnAnimal() {
        System.out.println("Throw exception");
        throw new RuntimeException("after return throwing exception");
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }
}
