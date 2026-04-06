package com.sachin.Objects;

public class Car {
    public String brand;
    public int speed;
    public String color;

    String drive(){
        return "The " +color+ " Car of Brand " +brand+ " running at the speed of " +speed + " KM/h";
    }

}
