package com.sachin.Generics;
enum Constants{
    sachin, naman, rohit, vishal;
        }

public class GenericsConstructor {
    static void main() {
        GenericContainer g = new GenericContainer(Constants.sachin);
    }
}

class GenericContainer{

    <T> GenericContainer (T value){ //ye humne yaha pe 'generic type constructor' implement kiya h!
        T c = value;   //yaha pe T value ke base pe apne aap samjh jayega ki calue ka type kya hoga, aur automatically T ki value infer kar lega on run time
//        System.out.println(c.name()); will not work , because at compile time it does not know the type of <T>
    }

    //Let's see bounded type parameter here in generic constructor
    <T extends Constants> GenericContainer (T value ){ //It's the bounded type parameter
         T c = value;
       System.out.println(c.name()); //here this would work, as because of bounded type param. the type of <T> is already known. And this .name() method exists in the enum classes always.

    }

    //NOTE:
    /*
    * Class aur Interface level generics i.e. class <T> className{...},interface <T> interface_name{...} ka kaam 'Type Definition' (Left Side), return type wagera , basically Datatype ko control karna hota hai,*
    * jabki Constructor aur Methods ka kaam 'Type Implementation' aur 'Value Assignment' (Right Side) ko handle karna hota hai matlab run time pe uss particular Generic type ki value ko set karna.
    */

    //wese generic constructor me bhi LHS direct nahi but on the basis of passed value type ke base pe <T> set ho jata h , issi me first or second constructor ko dekhlo, hum sirf <T> type parameter laga rahe h value ke liye, but T apne aap set ho jayega.
    //yaha pe hum generic constructor ko dekh rahe h, class level generic ko dekh chuke h, method ko bhi dekhenge next file me.

    void display(){
//        GenericContainer g = new GenericContainer();
    }
}