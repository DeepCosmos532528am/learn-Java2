package com.sachin.Generics;

public class Generics {
    static void main() {
        GenericsDemo<Integer> gd = new GenericsDemo<>(2);
        GenericsDemo<Double> g = new GenericsDemo<>(75.2);

        GenericsDemo2<String, Double> gd2 = new GenericsDemo2<>("Sachin", 75.2);


    }
}

class GenericsDemo<T> {
     T value;

    GenericsDemo(T value) {
        this.value = value;
    }
}

class GenericsDemo2<T, V> {
     T value;
     V name;

    GenericsDemo2(T value, V name) {
        this.value = value;
        this.name = name;
    }
}

