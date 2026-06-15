package com.sachin.Objects;

public class CarObjectsdemo {
    static void main() {
        //Here every obj i.e. car1, car2 and car3, have its own instance of the class(template/blueprint) decided by us.
        Car car1 = new Car();
        car1.brand ="Mercedes";
        car1.color = "Red";
        car1.speed =120;


        Car car2 = new Car();
        car2.brand ="Lamborghini";
        car2.color = "Yellow";
        car2.speed =200;


        Car car3 = new Car();
        car3.brand ="Alto";
        car3.color = "White";
        car3.speed =70;


        System.out.println(car1.drive());
        System.out.println(car2.drive());
        System.out.println(car3.drive());
    }
}
