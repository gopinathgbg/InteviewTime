package com.example.code;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class Test {
   public static void main(String args[]) {
	   
	 //  list1={4, 2, 7, 1};
	  // list2= {8, 3, 9, 5}
	   // output = [1, 2, 3, 4, 5, 7, 8, 9] 
	   
	 // 1)  print first 10 numbers using java 8
	//  IntStream.range(1, 11).forEach(System.out::println);
	  
	  // 2) sort and merge the array using java 8 
	  int arr1[]= {4, 2, 7,1}; 
	  int arr2[]= {8, 3, 9, 5}; 
	//  int mergeAndSortArray[]= IntStream.concat(Arrays.stream(arr1),Arrays.stream(arr2)).sorted().toArray();
	  
	//  System.out.println(Arrays.toString(mergeAndSortArray));
	 
	   
	
	 // 3) reverse a string Using Java 7 : 
	  
	String name1 = "Gopinath";
	for (int i = name1.length() - 1; i >= 0; i--) {
	    char a = name1.charAt(i);
	//    System.out.print(a); // Using print to display the reversed string on one line
	}

	// 4) reverse a string Using Java 8:
//	String input = "Gopinath";
//	String reversed = IntStream.range(0, input.length()).mapToObj(i -> String.valueOf(input.charAt(input.length() - i - 1))).collect(Collectors.joining());

	
	
	
	
	
	
	
	
	
	
	
 List<Integer> list=	Arrays.asList(1,2 , 3, 2, 4, 6, 8, 1);
 
 Set<Integer> seen= new HashSet<>();
 Set<Integer>  duplicates= 
 list.stream().filter(n -> !seen.add(n)).collect(Collectors.toSet());
 System.out.println(duplicates); 
	
	
	
	

	
	
	
   }
}
//The function of this method is to find the same value from two lists