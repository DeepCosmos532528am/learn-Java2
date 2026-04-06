package com.sachin.Collections;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;

public class Main {
    static void main() {
        ArrayList<Integer> list1 = new ArrayList<>();
        ArrayList<Integer> list2 = new ArrayList<>();
        list1.add(2);

    int a = list1.getFirst();

        list2.add(3);

        for(int i = 1; i<=10; i++) {
            list1.add(i);
            System.out.println(list1);
        }
        int b = list1.getFirst();
        boolean bool = a==b;


        System.out.println();

    }
}
