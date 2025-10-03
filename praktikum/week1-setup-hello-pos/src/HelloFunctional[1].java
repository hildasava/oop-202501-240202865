package com.upb.agripos;

import java.util.function.Supplier;

public class HelloFunctional {
    public static void main(String[] args) {
        // Paradigma fungsional: gunakan lambda expression
        Supplier<String> hello = () -> "Hello World, I am hilda-240202865";

        System.out.println(hello.get());
    }
}
