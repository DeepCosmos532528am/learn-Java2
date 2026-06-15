package com.sachin.Maths;

public class DemoClass {
    public static void main(String[] args) {
        // 1. Math.abs(x): Returns the absolute (positive) value of a number
        System.out.println("Absolute value of -5: " + Math.abs(-5));

        // 2. Math.max(x, y): Returns the largest of two numbers
        System.out.println("Maximum of 10 and 20: " + Math.max(10, 20));

        // 3. Math.min(x, y): Returns the smallest of two numbers
        System.out.println("Minimum of 10 and 20: " + Math.min(10, 20));

        // 4. Math.sqrt(x): Returns the square root of a number
        System.out.println("Square root of 64: " + Math.sqrt(64));

        // 5. Math.pow(x, y): Returns the value of x raised to the power of y
        System.out.println("2 raised to the power of 3: " + Math.pow(2, 3));

        // 6. Math.random(): Returns a random double between 0.0 (inclusive) and 1.0 (exclusive)
        System.out.println("Random number: " + Math.random());

        // 7. Math.ceil(x): Returns the smallest integer greater than or equal to x (rounds up)
        System.out.println("Ceil of 5.3: " + Math.ceil(5.3));

        // 8. Math.floor(x): Returns the largest integer less than or equal to x (rounds down)
        System.out.println("Floor of 5.7: " + Math.floor(5.7));

        // 9. Math.round(x): Rounds a number to the nearest integer
        System.out.println("Round 5.5: " + Math.round(5.5));
        System.out.println("Round 5.4: " + Math.round(5.4));

        // 10. Math.cbrt(x): Returns the cube root of a number
        System.out.println("Cube root of 27: " + Math.cbrt(27));

        // 11. Math.log(x): Returns the natural logarithm (base e) of a number
        System.out.println("Natural log of 10: " + Math.log(10));

        // 12. Math.log10(x): Returns the base 10 logarithm of a number
        System.out.println("Log base 10 of 100: " + Math.log10(100));

        // 13. Math.exp(x): Returns Euler's number e raised to the power of x
        System.out.println("e^1: " + Math.exp(1));

        // 14. Trigonometric methods (work in radians)
        double radians = Math.toRadians(90); // Converts degrees to radians
        System.out.println("Sin(90 degrees): " + Math.sin(radians));
        System.out.println("Cos(90 degrees): " + Math.cos(radians));
        System.out.println("Tan(45 degrees): " + Math.tan(Math.toRadians(45)));

        // 15. Constants
        System.out.println("Value of PI: " + Math.PI);
        System.out.println("Value of E: " + Math.E);
    }
}

class Demo1{
    static void main(String[] args) {
        DemoClass2 d2 = new DemoClass2();
        DemoClass2.InnerDemo2 id2 = new DemoClass2.InnerDemo2();
        id2.toString();
        id2.increaseCount();
        id2.increaseCount();
        id2.increaseCount();
        id2.showCount();


        DemoClass2.InnerDemo2 id3 = new DemoClass2.InnerDemo2();
        id3.toString();
        id3.showCount();
        id2.showCount();
    }
}

class DemoClass2 {

  static class InnerDemo2{
         static int i = 0;

        void increaseCount(){
            this.i++;
        }
        void showCount(){
            System.out.println(this.i);
        }

        @Override
        public String toString() {
            System.out.println(this.getClass().getSimpleName());
            return this.getClass().getName().toString();
        }
    }

}

