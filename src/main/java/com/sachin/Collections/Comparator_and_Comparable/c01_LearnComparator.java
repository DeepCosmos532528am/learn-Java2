package com.sachin.Collections.Comparator_and_Comparable;

import java.util.*;

public class c01_LearnComparator {

    public static void main(String[] args) {

        ArrayList<Student> list = new ArrayList<>();

        list.add(new Student("Amit", 85));
        list.add(new Student("Ravi", 70));
        list.add(new Student("Neha", 95));

        // Ascending order by marks
        Comparator<Student> comp1 = (s1, s2) -> s1.marks - s2.marks;
        Collections.sort(list, comp1);
        list.sort(comp1);//modern way

        System.out.println("Ascending: " + list);

        // Descending order by marks
        Comparator<Student> comp2 = (s1, s2) -> s2.marks - s1.marks;
        list.sort(null);

        System.out.println("Descending: " + list);

//        // Marks + Name sorting
//        Comparator<Student> comp3 = (s1, s2) -> {
//            if (s1.marks == s2.marks)
//                return s1.name.compareTo(s2.name);
//            else
//                return s1.marks - s2.marks;
//        };
//
//        list.sort(comp3);

        System.out.println("Marks + Name: " + list);
    }
}

class Student {
    String name;
    int marks;

    Student(String name, int marks) {
        this.name = name;
        this.marks = marks;
    }

    @Override
    public String toString() {
        return name + " : " + marks;
    }
}