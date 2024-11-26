package com.example.ai.java8;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class WordFrequencyExample {
    public static void main(String[] args) {
        List<String> words = Arrays.asList("apple", "banana", "apple", "orange", "banana", "apple");

        Map<String, Long> wordFrequency = words.stream()
            .collect(Collectors.groupingBy(w -> w, Collectors.counting()));

        System.out.println(wordFrequency); // Output: {apple=3, banana=2, orange=1}
    }
}
