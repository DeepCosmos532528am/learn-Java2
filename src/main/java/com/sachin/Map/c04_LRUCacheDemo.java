package com.sachin.Map;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

/*
========================================================
🧠 LINKEDHASHMAP + LRU CACHE NOTES (IMPORTANT)
========================================================

🔹 LinkedHashMap internally:
   - HashMap + Doubly Linked List
   - maintains order of entries

--------------------------------------------------------
🔹 ORDER TYPES:

1️⃣ insertionOrder (default)
   → entries same order me rehte hain

2️⃣ accessOrder = true (LRU MODE)
   → recently accessed element goes to TAIL
   → HEAD always becomes LEAST RECENTLY USED (LRU)

   Example:
   A → B → C

   get(A)
   → B → C → A   (A moved to tail)

   ✔ HEAD = B (oldest / LRU)
   ✔ TAIL = A (most recently used)

--------------------------------------------------------
🔹 removeEldestEntry():

   👉 This method is NOT automatic removal logic
   👉 It is a HOOK (custom rule setter)

   Java internally calls it after every put()

   If it returns true:
      → HEAD (eldest entry) is removed automatically

--------------------------------------------------------
🔹 If custom logic NOT written:

   Default behavior:
   return false;

   👉 Result:
   ❌ No automatic deletion
   ❌ Cache will grow infinitely
   ❌ NOT an LRU cache anymore

========================================================
*/

class LRUCache<K, V> extends LinkedHashMap<K, V> {

    private final int capacity;

    public LRUCache(int capacity) {
        super(capacity, 0.75f, true); // true = accessOrder (LRU mode)
        this.capacity = capacity;
    }
    /*
    ----------------------------------------------------
    🔥 THIS METHOD CONTROLS EVICTION POLICY

    eldest = oldest entry (HEAD of LinkedList)

    return true  → remove head automatically
    return false → keep everything
    ----------------------------------------------------
    */
    @Override
    protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
        // CUSTOM LOGIC:
        return size() > capacity;
    }
}

/**
 *
 * Agar isse samjhein to `LinkedHashMap` me `removeEldestEntry()` ka kaam sirf itna hai ki jab bhi nayi entry `put()` hoti hai, tab map us method se poochta hai ki "kya ab mujhe eldest (head wali) entry hata deni chahiye?" Agar method `true` return karta hai to head wali entry remove ho jati hai, aur agar `false` return karta hai to kuch bhi remove nahi hota. Ye Method wese har baar sirf 2 hi methods call pe, .put() and .putAll() pe chalta h aur insertion ke baad chalta h. Is( removeEldestEntry() ) method ka kaam ye decide karna nahi hai ki head par kaunsi entry hogi; iska kaam sirf removal ki permission dena hai. Head par kaunsi entry hogi, ye map ke ordering mechanism par depend karta hai.
 *
 * Ab heade pe konsi entry rahegi ye kon decide karega. See Humare pass 2 options h ya toh head pe hamesha wo entry rahe jo entry sabse pehle insert kari gayi, seedhi baat h ki insertion order ke base pe element stored rahe, ussi seq me aur koi bhi further operation like .get() ya .put() unke uss sequence ko na chhed sake agar maanli insert hi 1,2,3,4,5 ke seq me ki toh ussi sequence me hamesha rahe chahe hum fir put(6), karkle yaa .get(1) ya koi aur element kare. Ab ordering mechanism `accessOrder` decide karta hai. Agar `accessOrder=false` hai to map insertion order maintain karta hai. Iska matlab hum jesa ki samajh chuke h, ki jo entry sabse pehle insert hui thi wahi head par rahegi,
 *
 * chahe tum usse kitni bhi baar `get()` kar lo ya koi entry put() karlo. Agar tumne `1,2,3,4,5` insert kiya aur phir `get(1)` kiya, to order fir bhi `1,2,3,4,5` hi rahega ye bhi samjh chuke h. Dusri taraf agar `accessOrder=true` hai, to `get(1)` karte hi `1` recently used maan li jayegi aur order `2,3,4,5,1` ban jayega. Yaani head par ab `2` aa jayega.Notice here ki sirf AccessControl true ya false karne se koi element delete nahi ho raha.
 *<br></br>
 * Agar false hota h toh element order maintained rehta h aur yadi true kar diya jaaye, toh 'most recently used' sabse 'last me' aur 'least recently used' 'sabse top' yani HEAD pe pahuch jata h. Remove hoga ya nahi ye toh depend karega ki override kiya h removEldestEntry() ko ya nahi aur usse true return ho raha h ya nahi. 'true' return hone pe delete hota h HEAD wala element aur false return hone pe nahi hota h, aur delete kab hoga ye decide karega internal logic ki true kis condition pe return ho raha h jese yahe pe dekho overriden me likha h 'return size() > capacity;' matlab tab true return karo jese hi size() zada ho capacity se.
 *
 * Ek aur important baat ye hai ki `LinkedHashMap` khud se kisi fixed capacity ko enforce nahi karta. Constructor me jo capacity dete ho, wo cache ki maximum size nahi hoti; wo sirf internal hash table ki initial capacity hoti hai. Agar tum `removeEldestEntry()` override hi nahi karte, to map ka size badhta hi rahega. Wo automatically ye nahi sochega ki "capacity 5 thi, ab 6th entry aayi hai to oldest hata do." Aisa kuch built-in behavior nahi hai. Automatic eviction tabhi hoti hai jab tum `removeEldestEntry()` ko override karke khud condition likho, jaise `return size() > 5`.
 *
 * Isliye LRU cache asal me do cheezon ke combination se banta hai. Pehli cheez `accessOrder=true`, jo decide karti hai ki least recently used entry head par rahe. Dusri cheez `removeEldestEntry()` ka custom logic, jo decide karta hai ki eviction kab karni hai. Agar pehli cheez nahi hogi to head par oldest inserted entry rahegi aur behavior FIFO jaisa ho jayega. Agar dusri cheez nahi hogi to head par LRU entry to rahegi, lekin kabhi remove nahi hogi aur map unlimited grow karta rahega. Isliye LRU cache ke liye dono ka saath me hona zaroori hai: `accessOrder=true` head ko LRU banata hai, aur `removeEldestEntry()` batata hai ki us LRU entry ko kab remove karna hai.
 *
 * @Point_1_ToFocusON
 *
 * `removeEldestEntry()` kab trigger hoti hai?**
 * Ye sirf tab check hoti hai jab map me **nayi entry add hoti hai**, yani `put()`, `putAll()` ke through insertion ke baad. `get()`, `containsKey()`, `replace()` wagairah par ye method trigger nahi hoti.
 *
 * **Koi element head par kab aata hai?**
 *
 * * `accessOrder = false` → jo sabse pehle insert hua tha, wahi head ki taraf rahega.
 * * `accessOrder = true` → jo entry sabse kam recent access hui hai (LRU), wahi head par rahegi. `get()` ya existing key par `put()` karne se entry tail (end) me move ho sakti hai.
 *
 * **Kya ye dono alag concepts hain?**
 * Haan.
 *
 * * **`accessOrder`** ka purpose hai **order maintain karna** (entries kis sequence me rakhi jayengi).
 * * **`removeEldestEntry()`** ka purpose hai **eviction/removal policy define karna** (kab eldest entry hatani hai).
 *
 * Ek order decide karta hai, doosra removal decide karta hai. Dono milkar LRU cache banate hain, lekin dono ki responsibility alag hai.
 *
 * @Point_2_ToFocusON
 *
 * 🧠 HashMap cache vs LRU cache (simple difference)
 * 🟦 Normal HashMap cache
 *
 * 👉 Sirf data store karta hai, koi rule nahi hota remove karne ka
 *
 * order matter nahi karta
 * size limit automatically enforce nahi hoti
 * purani entries tab tak rehti hain jab tak manually delete na karo
 *
 * 👉 Example:
 * “jo daala wo tab tak rahega jab tak tum hatao”
 *
 * 🟨 LRU Cache (LinkedHashMap based)
 *
 * 👉 Smart cache hota hai jo limited size maintain karta hai
 *
 * least recently used item automatically remove hota hai
 * access karne se order update hota hai
 * memory control hota hai
 *
 * 👉 Example:
 * “jo sabse kam use hua, wahi pehle nikal jayega”
 *
 * ⚡ One-line difference:
 *
 * 👉 HashMap cache = dumb storage (manual control)
 * 👉 LRU cache = smart storage (automatic eviction based on usage)
 * */

class c04_LRUCacheDemo {
    public static void main(String[] args) {

        LRUCache<Integer, String> cache = new LRUCache<>(3);
        new ArrayList<>();

        cache.put(1, "A");
        cache.put(2, "B");
        cache.put(3, "C");

        cache.get(1); // 1 becomes most recently used (moves to tail)

        cache.put(4, "D"); // triggers removal of LRU (2)

        System.out.println(cache);
    }
}

/*
========================================================
🧠 FINAL FLOW:

1. put() / get()
      ↓
2. LinkedHashMap updates order (if accessOrder = true)
      ↓
3. HEAD = LRU (oldest entry)
      ↓
4. removeEldestEntry() called
      ↓
5. if true → HEAD removed automatically

========================================================
*/