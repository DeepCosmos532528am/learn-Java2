package com.sachin.Inheritance1;


//        Dog.setWeight("black", 25);
//
//        Dog.getDogProps();
//        Dog.getDogProps();
//
//        Dog dog1 = new Dog();
//
//
//        dog1.setWeight("white", 30);
//        dog1.getter();
//        Dog.getDogProps();
//
//        myloginAccount_basic.account_info("Sachin");
//        System.out.println(Dog.getNum());
//       Dog.setNum(2);
//        int a = Dog.getNum();
//        System.out.println(a);
//
//        Dog.setNum(3);
//        int b = Dog.getNum();
//        System.out.println(b);
//
//        int c = Dog.getNum();
//         Dog.setNum(10);
//         b = Dog.getNum();
//        System.out.println(c);
//        System.out.println(b);
//
//




public class InheritDog  {
    static void main() {

     Dog dog1 = new Dog2();

       System.out.println(dog1.legs);
//       dog1.showGreeting();
          dog1.legsCount();//overridden, so the child class instance would run in context to the class itself



    }

}
