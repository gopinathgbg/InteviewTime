package com.example.ai.java8.falcrumCompany.test.question;
import java.util.*;
import java.util.stream.Collectors;

public class ReplaceWords {
    public static String replaceWords(List<String> dictionary, String sentence) {
        
        Set<String> rootSet = new HashSet<>(dictionary);

        return Arrays.stream(sentence.split(" "))
                .map(word -> findRoot(word, rootSet))
                .collect(Collectors.joining(" "));
    }

    private static String findRoot(String word, Set<String> rootSet) {

        for (int i = 1; i <= word.length(); i++) {
            String prefix = word.substring(0, i);
            if (rootSet.contains(prefix)) {
                return prefix;
            }
        }
        return word; 
    }

    public static void main(String[] args) {
        List<String> dictionary1 = Arrays.asList("cat", "bat", "rat");
        String sentence1 = "the cattle was rattled by the battery";
        System.out.println(replaceWords(dictionary1, sentence1)); 

        List<String> dictionary2 = Arrays.asList("a", "b", "c");
        String sentence2 = "aadsfasf absbs bbab cadsfafs";
        System.out.println(replaceWords(dictionary2, sentence2)); 
    }
}
