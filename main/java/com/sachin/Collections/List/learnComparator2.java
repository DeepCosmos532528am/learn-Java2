package com.sachin.Collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class learnComparator2 {
    static void main() {

        List<Employee> emp = Arrays.asList( //you knwo Sachin that this, Arrays.asList(...) returns the ArrayList(...), remember this arrayList is not same as the one, in the java.util,ArrayList, But it is the Inner class of the Arrays
                new Employee(100000, "Ragini"),
                new Employee(1, "Rahul"),
                new Employee(10, "Bhavani"),
                new Employee(4, "Umesh"),
                new Employee(8, "Ramesh"),
                new Employee(3, "Sachin"),
                new Employee(5, "Krishna")
        );

        List<Employee> emplist = new ArrayList<>(emp);
//        System.out.println(emplist.get(3).salary); //A way to get value from the list.

//         emplist.add(1 , new Employee(202202, "Megha Sharma"));
//
//         emplist.get(1).empName ="Aditya Sharma";

        Comparator<Employee> compareEmp = (o1, o2) -> { //Used Lambda expression, Sachin you know this, we can make another class
            return o2.salary - o1.salary; //manual way not recommended but use the modern way instead as below given
/*            return Integer.compare(o1.salary, o2.salary);   // ascending
            return Integer.compare(o2.salary, o1.salary);   // descending
*/        };

//        Collections.sort(emplist,compareEmp); //Old way to do so... , below is the modern way to do so.
        emplist.sort(compareEmp); //means, 'emplist' list ko sort Karo compareEmp(custom class) me overridden Comparator compare method me custom logic ke base pe

        for (Employee e : emplist) {
            System.out.println(e.salary);
        }

    }
}


class Employee {
    int salary;
    String empName;

    Employee(int salary, String name) {
        this.salary = salary;
        this.empName = name;
    }

}

/*Return	Meaning
< 0 (negative)	o1 comes before o2
> 0 (positive)	o1 comes after o2
= 0	both equal*/