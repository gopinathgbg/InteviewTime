package com.example.ai.java8;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class Duplicates {

	public static void main(String[] args) {
		List<Integer> numbers =Arrays.asList(1,2,3,4,5,3,2);
		Set<Integer> duplicates=numbers.stream().collect(Collectors.groupingBy(n ->n,Collectors.counting()))
		.entrySet().stream().filter( e -> e.getValue() >1).map(Map.Entry::getKey).collect(Collectors.toSet());
	 System.out.println(duplicates);
	}
}
