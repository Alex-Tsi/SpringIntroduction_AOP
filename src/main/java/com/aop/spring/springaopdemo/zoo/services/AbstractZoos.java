package com.aop.spring.springaopdemo.zoo.services;

import com.aop.spring.springaopdemo.zoo.animals.Animal;
import com.aop.spring.springaopdemo.zoo.aspects.AddRegister;
import com.aop.spring.springaopdemo.zoo.aspects.GetRegister;

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

    @Override
    public void returnAnimal() {

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
