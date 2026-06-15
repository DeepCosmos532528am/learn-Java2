
package com.sachin.Map;

import java.util.HashMap;
import java.util.Objects;

// Custom Class to demonstrate Hashmap Key behavior
class Student {
    int id;
    String name;

    Student(int id, String name) {
        this.id = id;
        this.name = name;
    }

    // 1. hashCode override: Isse bucket index decide hota hai
    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

    // 2. equals override: Collision ke time exact key dhundne ke liye
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Student student = (Student) obj;
        return id == student.id && Objects.equals(name, student.name);
    }

    @Override
    public String toString() {
        return "Student{id=" + id + ", name='" + name + "'}";
    }
}

public class c02_MapDemo2 {
    public static void main(String[] args) {

        // Custom Object as Key demo
        HashMap<Student, String> studentMap = new HashMap<>();

        Student s1 = new Student(101, "Sachin");
        Student s2 = new Student(101, "Sachin"); // Same data as s1

        studentMap.put(s1, "Developer");

        // Agar equals/hashCode override nahi hota, toh s2 ko naya key maanta
        // Par override hai, isliye ye purani value update kar dega

        //✔ Reality:
        //s1 == s2 → false   (on checking references, different objects in memory)
        //🔥 But tumne override kiya hai:
        //id == student.id && Objects.equals(name, student.name)
        //s1.equals(s2) → true
        studentMap.put(s2, "Senior Developer");

        //“Even after overwriting in HashMap, both objects still exist in heap memory as separate instances, but HashMap stores only one entry because equals() treats them as the same key.”

        System.out.println("Map Size: " + studentMap.size()); // Size 1 hi rahega
        System.out.println(studentMap.get(s1));
  /*
        🪣 HashMap me kya hua step-by-step:
        1️⃣
        studentMap.put(s1, "Developer");

→ insert ho gaya

        2️⃣
        studentMap.put(s2, "Senior Developer");

        HashMap internally:

        1. s2.hashCode() → same bucket as s1
        2. s1.equals(s2) → true

👉 RESULT:
✔ same key treat kiya
✔ value overwrite ho gayi

🎯 Final Map:
        Student(101, "Sachin") → "Senior Developer"

✔ Size = 1
✔ overwrite ho gaya

🔥 Tumhari line ko correct kaise likhen:
// s1 aur s2 alag objects hain (== false)
// lekin equals() ke according same key hain (equals() true)
// isliye HashMap me s2, s1 ko replace kar deta hai
⚡ One-line clarity:

👉 objects same nahi hue
👉 unko same maana gaya (logically)

🧠 Golden rule yaad rakhna:
==  → memory compare
        equals() → logic compare
        HashMap → equals() pe trust karta hai

        Agar tum interview me ye bol do:

“HashMap does not merge objects, it just treats them as same key based on equals() and replaces the value”
        */
    }
}
/*
🧠 Scenario:
        Student s1 = new Student(101, "Sachin");
        Student s2 = new Student(101, "Sachin");

map.put(s1, "Developer");
map.put(s2, "Senior Developer");

(assuming equals() + hashCode() overridden)

        🧠 1. Heap Memory (real objects)
        HEAP:

        s1 ───► Student object A
        (id=101, name=Sachin)

        s2 ───► Student object B
        (id=101, name=Sachin)

✔ 2 different objects
✔ memory me dono exist karte hain

🪣 2. HashMap structure (logical view)
        HASHMAP (Buckets):

        Bucket X:
        Student(101,Sachin) ───► "Senior Developer"
        🔥 What happened step-by-step:
        Step 1:
        put(s1, "Developer")
        Bucket X:
        s1 ─► "Developer"
        Step 2:
        put(s2, "Senior Developer")

        HashMap checks:

        s2.hashCode() == s1.hashCode() ✔
        s1.equals(s2) == true ✔

        👉 So:
        ✔ SAME KEY considered
✔ VALUE REPLACED

⚡ Final state:
        🧠 Heap:
        s1 → Object A
        s2 → Object B
        (2 objects still exist)
🪣 HashMap:
        Bucket X:
        Student(101,Sachin) → "Senior Developer"
        🎯 Key Insight (VERY IMPORTANT):

        👉 HashMap:

        objects ko merge nahi karta
        sirf mapping replace karta hai

👉 Heap:

        objects independent rehte hain
🔥 One-line memory trick:

        “Heap has objects, HashMap has references — overwrite only changes mapping, not memory objects.”

*/

/*
* Hey, are you aware of the behaviour of the hashmap where, if the key is new then using that same (HashCode,BucketIndex,LinkedList) system the new (key->value)
* will get assign to the (new bucketIndex then to the linkedList node) but what if the key already exists and we are putting the new value on the same key
* then it overwrites the value at the same key, despite assigning that key->value to the new bucket *//*



*/
/*
Look, we have already seen the internal working of the 'Hashmap' and we have seen the demonstration using the prebuilt classes like String, Integer.
 But in the case of the objects created using the new keyword, despite having the same value in each state, it will every time create the different objects, will not overwrite as prebuilt classes.
*/

/*
class Student {
    int id; (Talking of this state, assume this as a key)
    String name; (Talking of this state, assume this as a value)

    ...
    }
      */


/*
* Now bro you know this that custom classes do not override the Object's by def .equals() and .hashcode() methods,
*
* By default Java me jab tum custom objects banate ho (jaise `Student s1` aur `Student s2`), to unka comparison
*  **reference ke basis pe hota hai**, value ke basis pe nahi. Matlab chahe dono objects ke andar same data ho (“Sachin”, 1),
*  phir bhi wo alag treat honge kyunki memory me wo alag instances hain. Ye behavior `Object` class ke default
* `equals()` aur `hashCode()` se aata hai, jo sirf ye check karta hai ki dono references same hain ya nahi (`this == obj`).
*  Java aisa isliye karta hai kyunki usse nahi pata hota ki tumhare object me equality ka logic kya hona chahiye — name se,
*  id se, ya dono se — isliye wo safe default (identity comparison) use karta hai.

Jab tum `equals()` aur `hashCode()` override kar dete ho uss custom class me, tab tum Java ko batate ho ki “kaunse fields
* ke basis pe objects equal maane jayenge.” Tab HashMap bhi wahi follow karta hai: pehle `hashCode()` se bucket decide karta
* hai, aur agar same bucket me multiple keys aaye to `equals()` se check karta hai ki key same hai ya nahi. Isi wajah se
* String jaise classes me same value hone par overwrite hota hai, kyunki unhone already value-based equality define ki hoti hai.
*  Custom class me bhi agar tum ye methods override kar do, to HashMap usko String jaisa logical key treat karega; warna har
*  object alag key maana jayega.
*
*
* Jab tum `HashMap` me `put(key, value)` karte ho, to sabse pehle `hashCode()` run hota hai jo decide karta hai ki key kis bucket me jayegi.
*  Uske baad agar us bucket me already koi entry hai, to HashMap `equals()` call karta hai compare karne ke liye: `existingKey.equals(newKey)`.
* Agar `equals()` true return karta hai, to HashMap samajhta hai ki ye **same key hai**, aur wo purani value ko **overwrite** kar deta hai.
* Isme “same object” hona zaroori nahi hai — agar tum wahi object dubara use karo (`map.put(s1, 1)` phir `map.put(s1, 2)`), tab bhi overwrite hoga,
*  kyunki reference bhi same hai aur logically bhi same key hai.

Lekin interesting part ye hai ki **alag objects bhi same treat ho sakte hain**, agar `equals()` unhe equal bole.
* Jaise Strings me `"Sachin".equals("Sachin")` true hota hai, isliye overwrite hota hai. Custom class me agar tum `equals()` ko
*  is tarah override kar do ki sirf `name` compare ho, to `Student("Sachin", 1)` aur `Student("Sachin", 2)` bhi same key maane jayenge aur
*  overwrite ho jayega. Agar override nahi karoge, to `equals()` default reference compare karega aur dono objects alag treat honge, isliye
* overwrite nahi hoga. Matlab final decision overwrite ka **equals() ke haath me hota hai**, chahe object same ho ya logically same define kiya gaya ho.


*
*  */


