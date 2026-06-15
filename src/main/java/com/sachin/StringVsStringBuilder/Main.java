package com.sachin.StringVsStringBuilder;

/*
 * Hum yahan 3 alag classes banayenge to understand:
 * 1. String (Immutable)
 * 2. StringBuilder (Mutable, Not Thread-safe)
 * 3. StringBuffer (Mutable, Thread-safe)
 */

class StringDemo {
    public static void show() {
        System.out.println("--- String Demo ---");
        // String is Immutable (change nahi ho sakta)
        String s1 = "Sachin"; // SCP mein banta hai
        String s2 = "Sachin"; // s2 bhi usi SCP object ko point karega
        
        System.out.println("s1 == s2: " + (s1 == s2)); // True (Dono same reference hain)
        
        s1 = s1.concat(" Sharma"); 
        System.out.println("Modified s1: " + s1); 
        
        /*
         * Internal Working (Gehri samajh):
         * 1. Storage: Java 9 se pehle ye `char[]` use karta tha, ab `byte[]` use karta hai memory bachane ke liye.
         * 2. Immutability: String final class hai aur iska internal array bhi final hota hai.
         * 3. String Constant Pool (SCP): Jab hum bina 'new' ke string banate hain, toh wo SCP mein check karta hai.
         *    Agar wahan pehle se hai, toh naya object nahi banata.
         * 4. Memory: Bar-bar concat karne se Heap mein bahut saare kachra (garbage) objects ban jaate hain.
         */
    }
}

class StringBuilderDemo {
    public static void show() {
        System.out.println("\n--- StringBuilder Demo ---");
        // StringBuilder is Mutable (change ho sakta hai)
        StringBuilder sb = new StringBuilder();
        
        System.out.println("Initial Capacity: " + sb.capacity()); // Default capacity 16
        
        sb.append("Sachin");
        System.out.println("StringBuilder: " + sb); 
        System.out.println("Capacity after append: " + sb.capacity());
        
        /*
         * Internal Working:
         * 1. Capacity: Default capacity 16 characters ki hoti hai.
         * 2. Resizing: Jab characters 16 se zyada hote hain, toh capacity badhti hai.
         *    Formula: (Old Capacity * 2) + 2. (E.g., 16 -> 34 -> 70...)
         * 3. Backend: Ye bhi internal `byte[]` ya `char[]` use karta hai jo final nahi hota.
         * 4. Performance: Ye fast hai kyunki methods 'synchronized' nahi hain.
         */
    }
}

class StringBufferDemo {
    public static void show() {
        System.out.println("\n--- StringBuffer Demo ---");
        // StringBuffer is also Mutable but Thread-safe
        StringBuffer sb = new StringBuffer("Sachin");
        
        // Extra Examples:
        sb.insert(6, " (Developer)"); // Beech mein add karna
        System.out.println("After Insert: " + sb);
        
        sb.replace(0, 6, "Master"); // Range badalna
        System.out.println("After Replace: " + sb);
        
        sb.reverse(); // Poora ulta karna
        System.out.println("After Reverse: " + sb);
        
        System.out.println("Final Capacity: " + sb.capacity());
        
        /*
         * Internal Working (Backend):
         * 1. Thread Safety: Iske saare methods `synchronized` hote hain. 
         *    Iska matlab ek time par ek hi thread ise use kar sakta hai.
         * 2. Growth Policy: Iski capacity bhi StringBuilder ki tarah (Old*2 + 2) badhti hai.
         * 3. Legacy: Ye Java 1.0 se hai, jabki StringBuilder Java 1.5 mein aaya tha.
         * 4. Storage: Ye Heap memory mein hi banta hai, SCP ka yahan koi kaam nahi.
         */
    }
}

public class Main {
    public static void main(String[] args) {
        // Explaining when to use which:
        
        // 1. String: Use karo jab data change na karna ho (Constants, Keys).
        StringDemo.show();
        
        // 2. StringBuilder: Use karo jab data bahut change karna ho aur performance chahiye (Single Thread).
        StringBuilderDemo.show();
        
        // 3. StringBuffer: Use karo jab multi-threading environment ho aur data consistency chahiye.
        StringBufferDemo.show();
    }
}
