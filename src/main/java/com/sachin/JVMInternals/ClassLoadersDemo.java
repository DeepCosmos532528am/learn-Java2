package com.sachin.JVMInternals;

import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLData;
import java.util.Scanner;

class WrapperTypeCasting {

    static {
        System.out.println("I am WrapperTypeCasting");
    }

}

class ClassLoaderDemo0 {

    static {
        System.out.println("Hello World, I am Loaded");
    }

}

class ClassLoadersDemo {

    static void main() throws ClassNotFoundException {

        ClassLoader loader1 = Scanner.class.getClassLoader();
        ClassLoader loader2 = Scanner.class.getClassLoader();
        ClassLoader loader3 = Scanner.class.getClassLoader();

        System.out.println(loader1); // null (on your JDK)
        System.out.println(loader2);
        System.out.println(loader3);

//      Reason:
//      On your JDK, Scanner is being loaded by the Bootstrap ClassLoader.
//      Since the Bootstrap ClassLoader is implemented in native code,
//      getClassLoader() returns null.


        ClassLoader loader4 = SQLData.class.getClassLoader();
        ClassLoader loader5 = Driver.class.getClassLoader();
        ClassLoader loader6 = DriverManager.class.getClassLoader();

        System.out.println(loader4); // Platform ClassLoader
        System.out.println(loader5); // Platform ClassLoader
        System.out.println(loader6); // Platform ClassLoader

//      Reason:
//      These classes are loaded by the Platform ClassLoader.


        ClassLoader loader7 = ClassLoaderDemo0.class.getClassLoader();
        ClassLoader loader8 = ClassLoadersDemo.class.getClassLoader();
        ClassLoader loader9 = WrapperTypeCasting.class.getClassLoader();

        System.out.println(loader7); // AppClassLoader
        System.out.println(loader8); // AppClassLoader
        System.out.println(loader9); // AppClassLoader

//      Reason:
//      These are user-defined classes, hence loaded by the
//      Application (System) ClassLoader.


        /*
               | API                       | Purpose                                 | Loads Class? | Initializes Class? |
               |---------------------------|-----------------------------------------|--------------|--------------------|
               | ClassLoader.loadClass()   | Manually load a class                   | Yes          | No                 |
               | Class.forName()           | Load and initialize a class             | Yes          | Yes (default)      |
               | Class.getClassLoader()    | Find which class loader loaded a class  | No           | No                 |
        */


        // ======================================================
        // 1. ClassLoader.loadClass()
        // ======================================================

        ClassLoader loader = WrapperTypeCasting.class.getClassLoader();

        Class<?> c = loader.loadClass(
                "com.sachin.JVMInternals.ClassLoaderDemo0"
        );

        // Loads the class.
        // Does NOT initialize it.
        // Therefore the static block is NOT executed.


        // ======================================================
        // 2. Class.forName()
        // ======================================================

        Class<?> c1 = Class.forName(
                "com.sachin.JVMInternals.ClassLoaderDemo0"
        );

        /*
            By default Class.forName():

            1. Loads the class.
            2. Links the class.
            3. Initializes the class.

            Therefore the static block inside ClassLoaderDemo0
            executes immediately.
        */


        // ======================================================
        // 3. Class.getClassLoader()
        // ======================================================

        System.out.println(ClassLoaderDemo0.class.getClassLoader());

        /*
            This method does NOT load anything.

            It simply returns the ClassLoader object that loaded
            the class.
        */


        // ======================================================
        // Interview Takeaway
        // ======================================================

        /*
            ClassLoader.loadClass()
                -> Loads a class.
                -> Does NOT initialize it.

            Class.forName()
                -> Loads + Initializes a class (by default).

            Class.getClassLoader()
                -> Returns the ClassLoader that loaded the class.
                -> Does not load or initialize anything.
        */
    }
}