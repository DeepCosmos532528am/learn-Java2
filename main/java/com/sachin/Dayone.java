package com.sachin;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;


public class Dayone {
    static void main() {
//  System.out.println("Sachin");


         String NAME;
        NAME = "Sachin";

        String NEW_NAME = "Sachin";//String Constant pool me same reference

        System.out.println(NAME == NEW_NAME); //will print true


        List <Object> list = new ArrayList<>();
        int count = 0;
        list.add("String");
        list.add(2);

        System.out.println(list.getFirst());


            list.add(count);
            System.out.println(count);
            count++;

  Demo2 demo1 = new Demo2();
          demo1.demo();


    }
}

class Demo1{
    void demo(){
        System.out.println(this.getClass().getName());
    }
}

class Demo2 extends Demo1{

}


class ChainingMethods {

    private String name ;

    static void main() {

        ChainingMethods chain = new ChainingMethods();

        System.out.println( chain.giveFirstName("Sachin").toString());

        System.out.println(chain.getName().toString());

    }


    Object giveFirstName(String firstName){ //will print the full object name
         this.name = firstName.concat(" Sharma");
        return 2;
    }

    void printFullName(){
        System.out.println(this.name);
    }

     Integer getName(){
        return 3;
    }

}

class ClassStreams{
    static void main() {

    }

    List<Integer> numbs = new ArrayList<>();
    Boolean hasEven = numbs.stream().anyMatch(n -> n%2 ==0);

}

class charPrimitiveDemo{
    static void main(String[] args) {

//        Aap ek hi character 'A' ko Java mein 4 alag formatting styles se likh sakte hain:
//        Literal Format:
        char a = 'a';
        System.out.println(a);

//        (Inverted commas ke sath)Decimal Format (Base-10):
        char b = 196;
        System.out.println("b -> "+ b);

//        (Direct numeric value) [4]Hexadecimal Format (Base-16):
        char c = 0x41; //(0x prefix ke sath)
        System.out.println(c);

//        Unicode Escape Format:
        char d = '\u0041'; // ( '\ u' prefix ke sath 4-digit hex)
        System.out.println(d);


// Assigning a 2-byte (16-bit) Unicode code point using 4 hexadecimal digits
        char e = '\uF232';
        System.out.println(e);

/*
  UNDERSTANDING JAVA CHAR AND UNICODE:

  1. Hexadecimal Format:
     Java supports hexadecimal literals for the 'char' type using the '\ u' prefix.
     You must provide exactly 4 hexadecimal digits using combinations of {0-9}, {a-f}, or {A-F}.
     These 4 hex digits represent exactly 2 bytes (16 bits) of data in memory.

  2. ASCII Support:
     Since ASCII is a strict subset of Unicode (occupying the first 128 positions from \u0000 to \u007F),
     any standard ASCII character is natively supported inside this exact same hex structure.

  3. The Giant Library (Unicode) vs Java Char:
     Unicode is a universal dictionary storing hundreds of thousands of characters, scripts, and symbols.
     A single Java 'char' can ONLY store characters within the range of 0 to 65,535 (The Basic Multilingual Plane).

  4. How Modern Emojis Work:
     Modern emojis and rare historical scripts have code numbers higher than 65,535.
     Because a single 'char' cannot fit them, Java stores them in a 'String'.
     Internally, the String handles this by pairing two 'char' variables together (called a Surrogate Pair)
     to represent that single 4-byte extended character.
*/

        // Programming loop to print all printable ASCII characters from 32 to 126
        for (int i = 0; i <= 128; i++) {
            // Casting the integer format to char format to see the actual character
            System.out.println("Decimal Value: " + i + " -> Character: " + (char)i);
        }
    }
}

class WrapperTypeCasting{
    public static void main(String[] args) {

        Integer a = 2321;
        Float b = 3.9f;

        //Float c = a ; //(not supported as they are not even in the Parent Child relation)

        Float c = a.floatValue(); //this is how they are being cast using the dedicated methods for casting.
        // As here for Integer to Float we have .floatValue();
        System.out.println(c);
//        and vice versa
        Integer d = b.intValue();
        System.out.println(d);

//      Byte e = c.byteValue();
//
//      System.out.println("e: " + e);  // will soon explore these as well, right now commented...

    }
}
