package com.aop.spring.springaopdemo.zoo.animals;


import lombok.ToString;

@ToString
public abstract class AbstractAnimals implements Animal {
    private String name;
    private int size;

    protected AbstractAnimals(String name, int size) {
        this.name = name;
        this.size = size;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public void setSize(int size) {
        this.size = size;
    }
}
