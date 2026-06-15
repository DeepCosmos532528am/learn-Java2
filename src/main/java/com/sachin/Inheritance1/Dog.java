package com.sachin.Inheritance1;

public class Dog  {
    String sound = "Barks"; //These are called fiedls or States
    int legs = 4;
    int tail = 1;
    String color ;
    float weight;
    void legsCount(){
         System.out.println("total legs my dog have"+ legs);
     }

    //   static String sound = "Barks";
//    static int legs = 4;
//    static int tail = 1;
//    static String color ;
//    static float weight;

//    Dog(String n){
//
//    };

//    public static void setWeight(String colo, float weigh ) {
//        weight = weigh;
//        color = colo;
//
//    }
//    public static void getDogProps() {
//        System.out.println("your dog "+sound +", have "+ tail +" tail, "+legs+" legs and is "+ color+ " in color. Weight is "+ weight );
//    }
//
//    public void getter() {
//        System.out.println("your dog "+sound +", have "+ tail +" tail, "+legs+" legs and is "+ color+ " in color. Weight is "+ weight );
//    }

//    static int num ;
//
//    Dog(int num){
//        Dog.num = 10;
//    }
//    static void setNum(int n)
//    {
//        num= n;
//
//    }
//   static int getNum()
//    {
//      return num;
//    }

    void showDog(){
        System.out.println("i am dog 1 ");
    }


    public void getDogProps() {
        System.out.println("your dog "+sound +", have "+ tail +" tail, "+legs+" legs and is "+ color+ " in color. Weight is "+ weight );
    }
    public void setDogProps(String color, float weight ) {
        this.weight = weight;
        this.color = color;

    }

}
