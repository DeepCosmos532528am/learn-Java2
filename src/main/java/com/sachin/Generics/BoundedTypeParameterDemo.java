package com.sachin.Generics;

public class BoundedTypeParameterDemo {
    static void main() {
        Demo <Integer> d = new Demo<>();
        Demo <Byte> d2 = new Demo<>();
        Demo <Byte> d3 = new Demo<>();
        Demo <Byte> d4 = new Demo<>(); // All Allowed but--->

        //Demo <String> d5 = new Demo(); // Not Allowed/possible because the parameter is bounded by the
        // classes that extends Number Class. String does not extends it, so Compiler time error.

    }
}

class Demo <T extends Number>{
    T num;

    void putNum(T num){
        this.num = num ;
    }

    void showNum(){
        System.out.println(num);
    }
}