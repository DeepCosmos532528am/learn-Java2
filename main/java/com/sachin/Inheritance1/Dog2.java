package com.sachin.Inheritance1;

public class Dog2 extends Dog{
    int legs = 3;

   void legsCount(){ //Wese toh states inherit hoti.But iss tareeke se inherit jesa behaviour achieve jo sakta
        super.legsCount();

        System.out.println("total legs my dog have"+ legs); //isme legs automatic issi class ka context lega aur jo iss class me
        // legs ki value h wo print karega kyuki ye method ke saath h aur ye wala overriden method iss class ke context me chal rhaa h
        //lekin agar reference se karoge access karne ki toh compile time me hi left side wale class ke according, (iss case me parent class Dog ke according) hi direct value lega hamesha,return 0;
   }


//public void showGreeting(){
//        System.out.println("Parent:Hello GoodMorning");
//    }



}
