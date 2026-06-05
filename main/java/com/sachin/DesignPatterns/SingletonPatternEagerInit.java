package com.sachin.DesignPatterns;

public class SingletonPatternEagerInit {
     static void main(String[] args) {
        SP singetonPattern = SP.getInstanceOfCustomer();
        System.out.println(singetonPattern);

        SP customer2 = SP.getInstanceOfCustomer();
        System.out.println(customer2);

        System.out.println(singetonPattern);
        System.out.println(customer2);

        System.out.println(singetonPattern == customer2);
    }
}

class SP {
    private static final SP INSTANCE = new SP();

    private SP(){
    }

    public static SP getInstanceOfCustomer(){
        return INSTANCE;
    }
}