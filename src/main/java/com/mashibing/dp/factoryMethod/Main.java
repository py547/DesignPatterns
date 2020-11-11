package com.mashibing.dp.factoryMethod;

public class Main {
    public static void main(String []args){
     /*   Car c = new Car();
        c.go();
        Plane p= new Plane();
        p.go();*/
     /* Broom b = new Broom();
        b.go();*/

     Moveable m  = new CarFactory().create();
     m.go();
    }
}
