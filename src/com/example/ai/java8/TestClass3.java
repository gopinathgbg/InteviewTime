package com.example.ai.java8;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class TestClass3 {

	public static void main(String[] args) {
	
//		Linked list1: 1->2->3->4->5->6->7->8   
		//	ques -> remove every kth node, say k = 3, answer = 1->2->4->5->7->8  
		
		List<Integer> list1 =Arrays.asList(1,2,3,4,5,6,7,8);
		int k=3;
	List<Integer> list2=list1.stream().filter(n -> !n.equals(k)).collect(Collectors.toList());
		System.out.println(list2);
		
	}
	
	
	
	

}
