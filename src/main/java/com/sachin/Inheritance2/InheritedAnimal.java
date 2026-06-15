package com.sachin.Inheritance2;

class Animal {
    String animalName;
    int legs = 4;
    boolean hasTail = true;
    String foodConsumer ;
    int dangerOutOfTen ;
    String sound;



    public void setSound(String sound) {
        this.sound = sound;
    }

    public Animal(String animalName,int legs, boolean hasTail, String foodConsumer, int dangerOutOfTen) {
        this.legs = legs;
        this.hasTail = hasTail;
        this.foodConsumer = foodConsumer;
        this.dangerOutOfTen = dangerOutOfTen;
        this.animalName = animalName;
    }

    public void getSound() {
        System.out.println(animalName+ sound);    }



}

class Dog extends Animal{

    String sound = "Barks";

    public Dog(String animalName, int legs, boolean hasTail, String foodConsumer, int dangerOutOfTen) {
        super(animalName, legs, hasTail, foodConsumer, dangerOutOfTen);
    }


}

class Cat extends Dog{
    String sound = "Meows";

    public Cat(String animalName, int legs, boolean hasTail, String foodConsumer, int dangerOutOfTen) {
        super(animalName, legs, hasTail, foodConsumer, dangerOutOfTen);
    }


    @Override
    public void getSound() {
        System.out.println(animalName+ sound); //Jab tak animalName child ka khudka nahi tab tak wo parent ka refer karega!
    }
}

public class InheritedAnimal{
    static void main() {
         Dog animal = new Cat("Dog", 4, true, "Omnivores", 5);
         animal.getSound();
    }
}