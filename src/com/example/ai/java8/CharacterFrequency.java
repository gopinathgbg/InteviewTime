package com.example.ai.java8;
import java.util.Map;
import java.util.stream.Collectors;

public class CharacterFrequency {
    public static void main(String[] args) {
        String input = "hello world";

        Map<Character, Long> frequencyMap = input.chars() // Convert the string to an IntStream of characters
            .filter(c -> c != ' ') // Ignore spaces (optional)
            .mapToObj(c -> (char) c) // Convert int to char
            .collect(Collectors.groupingBy(c -> c, Collectors.counting()));

        System.out.println(frequencyMap); // Output: {d=1, e=1, h=1, l=3, o=2, r=1, w=1}
    }
}
