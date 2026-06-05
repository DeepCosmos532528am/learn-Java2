package com.sachin.DesignPatterns;

public class SingletonPatternLazyInit {
}


class Main{
    static void main() {
    SP2 sp2 =  SP2.getInstanceOfCustomer();
    }
}

class SP2 {
    private static SP2 INSTANCE;

    private SP2(){
    }

    public static SP2 getInstanceOfCustomer(){
        if(INSTANCE == null){
            INSTANCE = new SP2();
        }
        return INSTANCE;
    }
}
