package com.sachin.Enums;

public enum Months {

    JANUARY("Sachin",12), FEBRUARY("Naman"), MARCH, April;

    private String name; //ye last kiya tha, continue from here

     Months(String name, int guitars){
        System.out.println(name + " bought " + guitars +" guitars in the month of" + this.name());
    }

    Months(String name){
        this.name = name;
    }

    Months() {

    }
     void de(){
//         Months ms = new Months("");
         System.out.println(name);
     }

}

class Main2{
    static void main() {
        Months january = Months.JANUARY;
        Months april = Months.April;
        Months february = Months.FEBRUARY;
        february.de();
        january.de();
        april.de();

    }
}

class demo1{
    void d(){

    }
    demo1 (int x){

    }
    demo1(String s){

    }
    demo1(){};
}class demo2{
    void d(){
        demo1 d = new demo1();
    }
}

