package com.example.code;

import java.util.*;
import java.util.stream.Collectors;

import com.example.code.realTime.scenarioQuestions.Employee;

public class TestClass {

	public static void main(String[] args) {
	
		//  Basics questions java 8 stream API.
		
     List<Integer> numbers=Arrays.asList(1,2,3,4,5,6,7,8,9,10,11,12,13,14,15);
	// even ,odd
     List<Integer> EvenNumners	=numbers.stream().filter(n -> n%2==0).collect(Collectors.toList());
	 List<Integer> Oddnumners	=numbers.stream().filter(n -> n%2!=0).collect(Collectors.toList());
	 System.out.println("Even numbers "+EvenNumners);
	 System.out.println("Even numbers "+Oddnumners);
	 
	 // string length more than 5
	List<String> names= Arrays.asList("Vaibhav","GopinathGhanghao","Nitin","Om");
	List<String> morethan5= names.stream().filter(n-> n.length()>5).collect(Collectors.toList());
	System.out.println(" length >5 "+morethan5);
	
	// squares of numbers in a list 
	List<Integer> squares=numbers.stream().map(n -> n*n).collect(Collectors.toList());
	System.out.println(squares);
	
	// find first element greater than 10
	Optional<Integer> nums=numbers.stream().filter(n -> n >10).findFirst();
	
	System.out.println(nums);
	// natural sorted names
	List<String> sortedlist=names.stream().sorted().collect(Collectors.toList());
	System.out.println(sortedlist);
	
	
	
	
	// ***********************************************Intermediate Questions of Java 8 stream: ********************************************************* 
	//Find the sum of all even numbers in a list using Streams.
	
	Integer EvenNumnerssum	=numbers.stream().filter(n -> n%2==0).mapToInt(Integer::intValue).sum();
	System.out.println(EvenNumnerssum);
	//Given a list of strings, create a comma-separated string of all elements.
	System.out.println(names.stream().collect(Collectors.joining(",")));
	
	//Write a program to group a list of strings by their length using Streams.
   Map<Integer, List<String>> groupingByLength=	names.stream().collect(Collectors.groupingBy(String::length));
   groupingByLength.forEach((length,word) -> System.out.println("Length"+length+ "Word"+word));
   
   List<Integer> number1 = Arrays.asList(1, 2, 3, 4, 5);

   // Check if all elements are greater than 0
   boolean allGreaterThanZero = numbers.stream()
                                       .allMatch(num -> num > 0);

   // Print the result
   if (allGreaterThanZero) {
       System.out.println("All elements are greater than 0.");
   } else {
       System.out.println("Not all elements are greater than 0.");
   }
	
   //Find the longest string in a list using Streams.
    Optional <String> longestString = names.stream().reduce((s1,s2) -> s1.length() > s2.length() ? s1:s2);
    
    System.out.println(longestString);
    
    // *****************************************************Advance Stream Questions :************************************************************ 
    // 1) Given a list of employees (with fields name, age, and department), group employees by their department.
    //   
    
    List<Employee> listofemp= Arrays.asList(new Employee("Girish", 27, "ERD"),new Employee("Namdev", 30, "ABS"),new Employee("Sagar", 32, "CompEngg"));
    Map<String, List<Employee>> empGroupByDept= listofemp.stream().collect(Collectors.groupingBy(Employee::getDepartment));
    
    System.out.println(empGroupByDept+"*************");
    
    // 2) Given a String, find the first non-repeated character in it?

	String input = "Today is an awesome day";

	String uniqueCharacters = input.chars().distinct().mapToObj(c -> String.valueOf((char) c))
			.collect(Collectors.joining());
	System.out.println("non repeated character"+ uniqueCharacters);
    // 3) 
    
	List<Integer> numbers1=Arrays.asList(1,2,3,4,2,3,5,6,6);
	Set<Integer>  abc= new HashSet<>();
	Set<Integer>  duplicates=numbers1.stream().filter(n -> !abc.add(n)).collect(Collectors.toSet());
	System.out.println("duplicate elements are "+duplicates);
	}
}