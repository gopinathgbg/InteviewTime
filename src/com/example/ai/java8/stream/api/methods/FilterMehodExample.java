package com.example.ai.java8.stream.api.methods;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class FilterMehodExample {
    public static void main(String[] args) {
    	
    // 1) find even numbers 	
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        List<Integer> evenNumbers = numbers.stream()
                                           .filter(n -> n % 2 == 0)
                                           .collect(Collectors.toList());
        System.out.println("1: "+evenNumbers); // Output: [2, 4, 6]
        
     // 2) string length less than 5 
        List<String> fruits=Arrays.asList("Apple","Banana","orange","mango","PineApple");
       List<String> fruitlengthlessthan5= fruits.stream().filter(n ->n.length() <=5).collect(Collectors.toList());
       System.out.println("2: "+fruitlengthlessthan5);
       
    // 3) Filter products with price greater than 500
       List<Product> listofProduct=Arrays.asList(new Product("TV",15000),new Product("SmartPhone",30000),new Product("SmartPhone",30000),
    		   new Product("WATCH",2000),new Product("notebood",120),new Product("notebood2",120));
    		   
    		 List<Product> uniqueProduct=  listofProduct.stream().filter(s -> s.getPrice()>500).collect(Collectors.toList());  
    		 uniqueProduct.forEach(p ->System.out.println(p.getName()));
    }
} 