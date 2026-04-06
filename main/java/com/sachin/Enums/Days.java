package com.sachin.Enums;

public enum Days {
     MONDAY, TUESDAY, WEDNESDAY, FRIDAY, SATURDAY,THURSDAY,SUNDAY; //these all 7 are instances public final and static each, like Days MONDAY = new Days("MONDAY", 0); in the back at compile time, Days class created in which each Enum value is treated as the Instance as like Monday

 //We can have our custom method too, as enum at the end turn out to be a class only.

    public String display(){
         return "The Day is " +this.name(); //now as 'this' keyword points to the instance only, so it will point to the corresponding instance like Days.MONDAY, Days.TUESDAY etc...
    } //Let's take this method into the practice below


    //We can have our custom fields, constructors too, lets see this in other enum class, as its getting too messy here.


}

class Main{
    static void main(){
        Days Monday = Days.MONDAY;
        Days Sunday = Days.SUNDAY;
        Days Tuesday = Days.TUESDAY;

        //Some methods of the enum Class;

        int ordinal = Sunday.ordinal();

        System.out.println(ordinal);
        System.out.println(Monday.ordinal());
        System.out.println(Tuesday.ordinal());

//       this method gives the difference in the position starting from the 0 as the first index of the instance, as here MONDAY is the 0th indexed instance
        int diff = Monday.compareTo(Days.SUNDAY);
//        or
        int diff2 = Days.WEDNESDAY.compareTo(Days.SATURDAY);
//        or
        int diff3 = Days.WEDNESDAY.compareTo(Sunday);

        System.out.println(diff);
        System.out.println(diff2);
        System.out.println(diff3);

        //When want to perform some String operations on the Values (Instances), we first need to get the values in the String format;

        System.out.println(Days.THURSDAY.toString().toLowerCase());
//        or
        System.out.println(Monday.toString().toCharArray());
//        or
        System.out.println(Days.FRIDAY.name().toLowerCase());

//        The method below is used to get the String converted to the corresponding Enum Constant, if the string value passed
//        is exact same out of all the values or the instances of the corresponding enum class, then this method would return
//        the enum constant of the passed string, otherwise exception would occur.
        try{
             Days d = Days.valueOf("MONDAY");
             System.out.println(d);
         }catch (Exception e){
            System.out.println(e.getMessage()); //Case-sensitive → "MONDAY" works, but "monday" throws IllegalArgumentException.
         }

        //To get all the enum values;
        System.out.println(Days.values()); //Not the correct way , ha ha ha...!!!, It's an array bro.

        for (Days a : Days.values() ){
            System.out.println(a);
        }

//         using my custom method to get the name of the Day
        Days sunday = Days.SUNDAY; //Days.SUNDAY; is the instance of the Days 'enum class'
        System.out.println(sunday.display());

        Days monday = Days.MONDAY;
        System.out.println(monday.display());

        Days tuesday = Days.TUESDAY;
        System.out.println(tuesday.display());

        Days wednesday = Days.WEDNESDAY;
        System.out.println(wednesday.display());

        Days thursday = Days.THURSDAY;
        System.out.println(thursday.display());

        Days friday = Days.FRIDAY;
        System.out.println(friday.display());

        Days saturday = Days.SATURDAY;
        System.out.println(saturday.display());

    }

}
