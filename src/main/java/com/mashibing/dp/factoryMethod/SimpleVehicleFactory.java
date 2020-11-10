package com.mashibing.dp.factoryMethod;

/**
 * 简单工厂 可扩展性不好
 */
public class SimpleVehicleFactory {
    public Car creatCar(){
        //前置处理
        return  new Car();
        //后置处理
    }

    public Broom creatBroom(){
        return new Broom();
    }
}
