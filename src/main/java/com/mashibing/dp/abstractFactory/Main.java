package com.mashibing.dp.abstractFactory;

import com.mashibing.dp.factoryMethod.CarFactory;
import com.mashibing.dp.factoryMethod.Moveable;

public class Main {
    public static void main(String []args){
   AbastractFactory f = new MagicFactory();

   Vehicle  c = f.createVehicle();
   Weapon w = f.createWeapon();
   Food b = f.createFood();
   c.go();w.shoot();b.printName();
    }
}
