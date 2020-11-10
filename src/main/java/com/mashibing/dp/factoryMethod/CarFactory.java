package com.mashibing.dp.factoryMethod;

public class CarFactory {
    public Moveable create(){
        System.out.println("a car created");
        return new Car();
    }
}
