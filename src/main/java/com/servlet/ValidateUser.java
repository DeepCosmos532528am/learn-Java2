package com.servlet;

public class ValidateUser {


   public static Boolean validate(String username , String password){
       //isse mene intentionally static rakha h, kyuki validate method sirf input leta hai (username, password) aur result de deta hai. Isse class ki kisi
       // purani ya nayi kisi bhi state ya variable se matlab nahi hai. Aise methods jo sirf "input -> processing -> output" ka kaam karte hain, unhe Utility Methods kehte
       // hain aur unhe static rakhna hi best practice hai.



        //Now in real scene the password is validated by matching from the Database.
        //But here we don't have DB tables setup right now, lets use dummy password for matching.

       System.out.println("for" + username + " "+ password);


       if("Sachin".equals(username) && "1234".equals(password)){
           System.out.println("in true");
           return true;
       }
           return false;
   };

}
