package com.example.ai.java8;
import java.util.*;
import java.util.stream.Collectors;

public class DuplicateFinder {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 3, 2,5, 6);

        Set<Integer> seen = new HashSet<>();
        Set<Integer> duplicates = numbers.stream()
            .filter(n -> !seen.add(n)) // `add` returns false if the element already exists
            .collect(Collectors.toSet());

        System.out.println(duplicates); // Output: [2, 3,5]
    }
}