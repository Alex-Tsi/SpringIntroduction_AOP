package com.aop.spring.springaopdemo.zoo.services;

import com.aop.spring.springaopdemo.zoo.animals.Animal;

public interface Zoo {

    void getAnimal(Animal Animal, String name);

    void getPicture();

    String addAnimal(Animal animal);

    void returnAnimal();

    void setName(String name);

    String getName();

}
