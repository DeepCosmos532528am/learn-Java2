package com.sachin.Java8.FunctionalProgramming.p06_Optional_In_Java;

import java.util.*;

public class Optionals {
    static void main() {
        Shops shops = new Shops();

        System.out.println("Log 1");

        Optional<String> shopNameById = shops.getShopNameById(121);
        shopNameById.ifPresent(System.out::println);//Takes Consumer in input. If value is present then only the Consumer runs other wise no

        System.out.println("Log 2");

        int size = shopNameById.orElse("").trim().length();
        System.out.println(size);

//        int exception = shopNameById.orElseThrow(() -> new RuntimeException("No value found")).length();


//        Optional<String> name = Optional.of(null); bad idea as the this line itself will through error ,because .of method expects gauranteed non null value. but here null is given. in such situation where the value can be null try using .ofNullable() or .empty()
        Optional<String> name = Optional.empty();

//        See point is simple: If you are completely sure that the value will not be null, or it would definitely have some value, then you can use:
//         Optional.of()
//        If you are not sure, means in 50/50 case, the value can either be null or can have value, then definitely  Optional.ofNullable()  is the best choice.
//          Now at the end if you are sure the value will be null, then use Optional.empty()

//Lets explore .orElse(), .orElseGet(), .orElseThrow()

        Optional<String> name2 = Optional.ofNullable(null);

        System.out.println(name); //print Optional.empty simple
        System.out.println(name.orElse(null)); //.orElse() method ensures returning the original value if it present otherwise the one passed in .orElse(...) [null will be simple returned and will be printed]

        System.out.println(name.orElse("1. Default shop name").length());
        System.out.println(name2.orElse("2. Default shop name"));

//----------------------------------------------------------------------------------------------------------------------
        Optional<String> name3 = Optional.ofNullable(null);
        System.out.println(name3.orElseGet(
                ()->{
                    return """
                            name3:unknown
                            """;
                }));

        String nam = name3.orElseGet(
                ()->{
                    return """
                            name3:unknown
                            """;
                });

        System.out.println(nam);

//        (Basically they both .orElse() and .orElseGet() does same work. However, the difference between the .orElse() and .orElseGet()[takesSupplier as an argument] is that use .orElse() when the alternate logic is just a simple string or a simple basic short obj without any logic and second one is for, when there is heavy larger logic to write not only returning something as an alternative to the value when null is there as we do in .orElse().

//  ----------------------------------------------------------------------------------------------------------------------
//        (When we want to throw custom exception)

        Optional<String>  name4 = Optional.ofNullable(null);
     System.out.println(name4);

        System.out.println(name4.orElseThrow(()->new RuntimeException("NO VALUE THERE IN name4 VARIABLE")));





//  System.out.println(name.get()); //not preferred to use this, as it results in null pointer exception on the vacancy of value, use when you are 100% sure that value is definitely present.



    }
}

 class Shops{

    String shopName ;


    Optional<String> getShopNameById(int id ){
        Map<Integer,String> shops = new HashMap<>();
        shops.put(121,"Santosh kirana store");
        shops.put(201,"Paras Bakery");
        shops.put(341,"Rani Dairy");


        shops.forEach(
                (k,v)-> {
                    if (k == id) {
                        shopName = v ;
                    }});



//    return (shopName!=null)? Optional.of(shopName): Optional.empty();
//    return Optional.of(shopName);

        return Optional.ofNullable(shopName);

    }

}
