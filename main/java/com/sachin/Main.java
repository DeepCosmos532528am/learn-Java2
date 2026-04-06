package com.sachin;
import java.util.List;
import java.util.Scanner;
class Main{
    public static void main(String[] args) {
        System.out.println("Hello");
        Scanner sc = new Scanner(System.in);
        // int input = sc.nextInt();
        String name = "Sachin Sharma";
        String naam = "Sachin";

        if (naam.equals(name.substring(0, 6))) System.out.println("hai bhai");
        else ;
        System.out.println(name.substring(0, 6));

        int[] arr = {1, 2, 3, 4, 5};
        for (int a : arr) {
            System.out.println(a);
        }

        for (int a = arr.length - 1; a >= 0; a--) {
            System.out.println(arr[a]);
        }
        String nam = "";
        while (naam.equals("Sachin")) {
            System.out.println("Sachin Bhai");
            naam = "ok";
            nam = naam;
        }
        do {
            System.out.printf("ye do while h aur name h %s Ok!!", nam);
        } while (false);

        //Enum



       Days day = Days.Monday;

        switch (day){
            case Monday : System.out.println("Monday");
            case TUESDAY: System.out.println("Tuesday");
            default:
                System.out.println("Sachin");
        }

    float f = 0.2f;
    float a = f-1;


    String name1 = "Sachin";

        System.out.println("name" + name1);



    }
    void sum(){
        System.out.println("sas");
    }

}


enum Days{
    Monday, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY,
}

class GenericDemo {
    <T> void hello(List<?>  T ) {

    }
}