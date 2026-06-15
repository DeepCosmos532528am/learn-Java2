package com.letsDoSomething;


public class PrintingUtility {
    static void main() {
        Demo1 demo1 = new Demo1();
        Demo1 demo2 = new Demo2();
        Demo2 demo3 = new Demo2();

        
        demo2.showName();
//        demo3.showName();
//
//        demo3.showName();

//        PrintAnything.printIt(false,demo1.name,demo2.name,demo3.name );
    }
}


class PrintAnything{
    static <T> void printIt(Boolean singleLineFormatting, T ...a){

        if(singleLineFormatting){
            for(T b: a){
                System.out.print(b+" ");
            }
        }else
            for(T b: a){
                System.out.println(b);
            }
    }
}
class Demo1{

    String name = "Sachin";

    void showName(){
        System.out.println(name + " -> With Parent");
    }

}

class Demo2 extends Demo1{
String name = "MataRani";
//    void showName(){
//        System.out.println(name+ " -> With Child.");
//    }

}
