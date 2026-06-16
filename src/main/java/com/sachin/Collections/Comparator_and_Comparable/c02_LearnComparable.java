package com.sachin.Collections.Comparator_and_Comparable;

import java.util.*;

/** @Definition: Comparable ek Java interface hai jo kisi class ko uski natural/default ordering define karne ki capability deta hai. Iske compareTo() method ko override karke hum batate hain ki same type ke do objects ko kaise compare aur sort karna hai.
 *
 * One-Line Interview Answer
 *
 * Comparable ek interface hai jo kisi class ki natural ordering define karta hai through the compareTo() method.
 *
 * @Elaboration
 * Jab hume apne custom objects ko Collections.sort() ya Arrays.sort() se sort karna hota hai, toh class Comparable implement karti hai aur compareTo() method me comparison logic define karti hai. Sorting algorithms internally isi method ko call karke objects ki ordering decide karte hain.
 *
 * Natural Ordering Kya Hoti Hai?
 *
 * Natural ordering matlab:
 *
 * Object ka default sorting rule.
 *
 * Examples:
 *
 * Student → Marks
 * Employee → Salary
 * Product → Price
 * String → Alphabetical Order
 *
 * Ye rule Comparable ke through define kiya jata hai.
 *
 * @YouMayAsk..
 *
 * @Que1.
 * . Fir Comparator Ki Zaroorat Kyu Padi?
 *
 *@Answer Comparable ki limitation:
 *
 * Ek class me sirf ek hi compareTo() hota hai.
 *
 * Example:
 *
 * Student
 *
 * ko sort karna ho sakta hai:
 *
 * Marks ke basis pe
 * Name ke basis pe
 * Roll Number ke basis pe
 * Age ke basis pe
 *
 * Lekin Comparable sirf ek natural ordering define kar sakta hai.
 *
 * Example:
 *
 * compareTo()
 *
 * marks ke basis pe likh diya.
 *
 * Ab name ke basis pe sorting kaise karoge?
 *
 * Yahin Comparator introduce hua.
 *
 * Comparator external sorting strategy provide karta hai.
 *
 * Example:
 *
 * Comparator<Student> byName
 * Comparator<Student> byMarks
 * Comparator<Student> byAge
 *
 * Ek hi class ke liye multiple sorting logics possible ho gaye.
 *
 * @Que2. Why not in Integer or String case hamne ye nahi kiya??
 * @Answer Because unme pehle se hota h internally you can check if want to...
 *
 * {@code public int compareTo(Integer anotherInteger) {
 *         return compare(this.value, anotherInteger.value);
 * } }
 *
 *
 * */


public class c02_LearnComparable {
    static void main() {
        List<Vidhyarthi> students = new ArrayList<>();
        students.add(new Vidhyarthi("Satya", 100));
        students.add(new Vidhyarthi("Vijay", 75));
        students.add(new Vidhyarthi("Karuna", 87));
        students.add(new Vidhyarthi("Daina", 91));

//        List<Demo> dem = new ArrayList<>(Arrays.asList(new Demo(), new Demo()));
//        Collections.sort(dem, null);

        Comparator<Vidhyarthi> c = new Comparator<>() {


/**
 *
 * if(o2.marks > o1.marks) return  1;
 * else if(o2.marks < o1.marks) return  -1;
 * else return 0;
 *
 * Now listen the above logic is equivalent to the logic inside the Integer.compare(int x, int y){...} method of the Integer class
 *
  */


            @Override
            public int compare(Vidhyarthi o1, Vidhyarthi o2) {
               return Integer.compare(o1.marks, o2.marks); //Equivalent to:
                                                           /**
                                                             * if(o2.marks > o1.marks) return  1;
                                                             * else if(o2.marks < o1.marks) return  -1;
                                                             * else return 0;
                                                            */
            }



        };

        students.sort(c); //Passing the base of sorting, i.e., telling the TimSort to sort on the basis of marks.
        students.sort((c1, c2) -> Integer.compare(c1.marks, c2.marks));//Shorthand method to pass Comparator instead of how we have overridden the compare method using the way above and then passing, students.sort(c) as done above.
        students.sort(null);//triggers the 'natural-ordering' i.e., the compareTo() that is overridden below. TimSort in it's algo., does something like pivot.compareTo(a[mid]>0)...and more  .
/**
        Where pivot represents a single obj of our List<Vidhyarthi> i.e., Vidyarthi("someName", marks x);
        similarly 'a' represents 'Object array' containing our new Vidhyarthi("someName", marks x) objects.
        Each time during the iterations in Timsort algo, these objects generally change acc. To the Timsort algorithm written internally with the purpose of sorting the List in Descending or Ascending wise on the given basis i.e., either the Comparable or Comparator.

But how is this being decided which basis be used??? I.e., the .compareTo(){...} Of (Comparable) be used or the .compare() be used.
 See the Comparable are always tend to be provided within the Object itself using .compareTo(){...} By method overriding within the same object for e.g., a Vidhyarthi object here and
 while Comparator logic is written by overriding or using lambdas at the place where it is needed to be called. It's like saying "hey I need a list of Vidhyarthi objects sorted on the basis of xxx" for e.g., here we have used marks basis.
        But we can also use a 'name' basis or any other basis if needed.

@Remember -> Comparator have High priority then Comparable, if Comparator is passed then it will be used if null be passed then comparable be used i.e., .compareTo(){...} né invoked internally by TimSort algo.
*/



/**
 *        now lets back to understand how this is decided:
 *        Look if you will ctrl+leftClick on the Collections.sort() or list.sort() you will reach to Collections.java then list.java or directly to list.java respectively.
 *       there we can see Arrays.sort(a, (Comparator) c); through this by clicking to it, we will reach to Arrays.java and in the same sort() method two options are there.
 *       Here by these two options, this is actually decided whether to call another overloaded static sort() method, by navigating through which we will reach to find ComparableTimSort.sort(); method
 *       to sort on the basis of overridden .compareTo(){...} 'natural Ordering' method which we have provided in our Vidhyarthi
 *       obj or generally saying in our objects of which we are creating the List.
 *       or directly move to call TimSort.sort().
 *
 *       Now lets see these both the options standing in sort(T[] a, Comparator<? super T> c) method:
 *       1st option: going through sort() -> ComparableTimSort.sort() -> BinarySort() where our .toCompare() is called on each of our object we have stored in out List
 *       2nd option: going through TimSort.sort() -> BinarySort() where our comparators compare method be used
*/






        students.forEach(Vidhyarthi::toString);

    }
}

class Vidhyarthi implements Comparable<Vidhyarthi> {
    String name;
    int marks;


    Vidhyarthi(String name, int marks) {
        this.name = name;
        this.marks = marks;
    }

    @Override
    public int compareTo(Vidhyarthi o) {
        return Integer.compare(this.marks, o.marks);
    }

    @Override
    public String toString() {
        System.out.printf("name: %s, marks: %d\n ",this.name,this.marks);
//    return "\"name: %s\\n marks: %d\",this.name,this.marks";
        return "";
    }

}
class Demo{
    void demo(){

    }
}