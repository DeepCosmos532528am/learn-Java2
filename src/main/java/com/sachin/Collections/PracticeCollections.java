package com.sachin.Collections;

import java.time.temporal.Temporal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Stack;

public class PracticeCollections {
    static void main() {
        ArrayList<Employee> emplist = new ArrayList<>();
        emplist.add(new Employee(1,"Rohan"));
        emplist.add(new Employee(5,"Madan"));
        emplist.add(new Employee(2,"Rohit"));
        emplist.add(new Employee(9,"Suresh"));

        emplist.sort(Comparator.comparingInt( a -> a.salary));

        for(Employee e:emplist){
            System.out.print(e.name +" : "+e.salary);
        }

        emplist.sort((a, b) -> b.salary - a.salary);

        for(Employee e:emplist){
            System.out.print(e.name +" : "+e.salary);
        }


        System.out.println("-------------------------------------------------");

        Stack<Employee> stack = new Stack<>();
        stack.push(new Employee(1,"Rohan"));
        stack.push(new Employee(5,"Madan"));
        stack .push(new Employee(2,"Rohit"));
        stack .add(new Employee(2,"kavya"));
        System.out.println(stack.peek().name);

        System.out.println("-------------------------------------------------");


    }
}


class Employee{
    int salary;
    String name;

    Employee(int salary, String name) {
        this.salary = salary;
        this.name = name;
    }
}





/**
 * */
