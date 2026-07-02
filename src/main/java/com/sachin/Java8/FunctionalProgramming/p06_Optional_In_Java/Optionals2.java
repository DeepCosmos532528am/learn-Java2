package com.sachin.Java8.FunctionalProgramming.p06_Optional_In_Java;

import java.util.List;
import java.util.Optional;

public class Optionals2 {
    static void main() {

        System.out.println("chaining operations, and using Optional to prevent null pointer exception");


        Optional<List<String>> labourNames = Optional.ofNullable(null);
//        Optional<List<String>> labourNames = Optional.ofNullable(List.of("Aremaan", "Reeval", "Kayreo", "Kanuma")); //try passing null, and see how optional will handle it
        labourNames.ifPresent(s -> s
                .stream()
                .filter(l -> l
                        .startsWith("k") )
                .map(String::toUpperCase)
                .forEach(solution -> System.out.println(solution)));


    }
}

