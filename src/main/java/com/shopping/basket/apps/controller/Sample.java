package com.shopping.basket.apps.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


interface SampleInterface {
	public String check();
}

public class Sample {
	
	
	
	public static void main(String arg[]) 
	{
		System.out.print(generateAscendingNumbers(2));
	}
	private void sample(){
		
		List<String> names = Arrays.asList("John", "Doe", "Jane");
		
		List<String> tempList = names.stream().collect(Collectors.toList());
		
		System.out.println(tempList);
		
		String common = "common";
		
		System.out.println(home1(common));
		
		
		
		Sample sample = new Sample();
		String s = "ohommoe";
		
		//System.out.println(home(s));
		
		System.out.println("CARD : "+sample.isValid("4388576018402626"));
		//System.out.println("CARD : "+sample.isValid("4111111111111111"));
		
		//System.out.println(run("5h", 11, 25)); // 8a
		//System.out.println(run("2b", 03, 02)); // 5d
		System.out.println(run("1a", 10, 10)); // 3c
		//System.out.println(run("4f", 88, 88)); // 4f
		
		
		/*
		for(int i=0; i<=256; i++)
        {
           System.out.println( i + ". " + (char)i);
        }*/
			
		SampleInterface sample1 = ()->{return "Hellow";};
		
		System.out.println(sample1.check());
		
		generateFibonacci(10);
		
	}
	
	public static String run (String startingPosition, int row, int column) {// 2b , 3 ,2
		
		int startRow = Integer.parseInt(startingPosition.substring(0,1)); // 2
		char startColumn = startingPosition.charAt(1);  // b
		
		//Operator Precedence
		int endRow = (startRow + row -1 ) % 8 + 1 ;    // 2 + 3 -1 = 4 % 8 = 4 +1 = 5
		
		char endColumn = (char) ((startColumn + column - 97  ) % 8 + 97);  // ASCII value of b 98 - 97 + 2 = 3
																		  // 3%8 + 97	 	
																	      // 3 +97 = 100
																		  // ASCII char of 100 is  d	
		return "" + endRow + endColumn;  // 5d
	}
	
	public boolean isValid(String cardNumber) {  //4388576018402626
		
		
		if(cardNumber == null || cardNumber.isEmpty()) {
			return false;
		}
		
		 
		int sum = 0;
		int temp = 0;
		
		for(int index = cardNumber.length() - 1; index >= 0 ; index--) {
			temp = cardNumber.charAt(index) - '0'; // 6
			
			if(index%2 == 0) {
				if(temp > 4) {
					sum += temp * 2 -9;  
				}else {
					sum += temp * 2;
				}
			}else {
				sum += temp;
			}
			//System.out.println(evenIndex + " index: " + index  + " temp  :" + temp + " sum:" + sum);
		}
		
		return sum%10 == 0; 
	}
	
	public boolean isValid1(String cardNumber)
	{
		
		if(cardNumber == null || cardNumber.isEmpty() ) {
			return false;
		}
		
		boolean evenIndex = true;
		int sum=0;
		int temp=0;
		
		for (int i = cardNumber.length()-1; i >= 0; i--) {
			
			temp = cardNumber.charAt(i) - '0';
			
			 
			if(evenIndex = !evenIndex) {
				if(temp > 4) {
					sum = sum + temp * 2 -9;
				}else {
					sum = sum + temp * 2;
				}
			}else {
				sum = sum + temp;
			}
			System.out.println(evenIndex + " index: " + i  + " temp  :" + temp + " sum:" + sum);
		}
		
		return sum%10 == 0;
	}
	
	public static int home(String str) {
		Map <Character, Integer> charCount = new HashMap<>();  
		
		for (int i = str.length() - 1; i >= 0; i--)   
		{  
			if(charCount.containsKey(str.charAt(i)))   
			{  
				int count = charCount.get(str.charAt(i));  
				charCount.put(str.charAt(i), ++count);  
			}   
			else   
			{  
				charCount.put(str.charAt(i),1);  
			}  
		}  
		
		System.out.println(charCount);
		
		return charCount.get('m');
	}
	
	public static Map<Character, Integer> home1(String str) {
		Map <Character, Integer> charCount = new HashMap<>();  
		
		for (int i = str.length() - 1; i >= 0; i--)   
		{  
			if(charCount.containsKey(str.charAt(i)))   
			{  
				int count = charCount.get(str.charAt(i));  
				charCount.put(str.charAt(i), ++count);  
			}   
			else   
			{  
				charCount.put(str.charAt(i),1);  
			}  
		}  
		
		
		
		return charCount;
	}
	
	public static void generateFibonacci(int n) {
        int a = 0, b = 1;
        System.out.println("Fibonacci Series up to " + n + " terms:");
        System.out.print(a + ", " + b + ", ");
        for(int index = 2; index < n ; index++) {
        	int next = a+b;
        	System.out.print(next + ", ");
        	a = b;
        	b = next; 
        	
        } 
    }
	
	
	 public static String generateAscendingNumbers(int n) {
	        List<String> result = new ArrayList<>();
	        generateNumbers("", 1, n, result);
	        return String.join(",", result);
	    }

	    private static void generateNumbers(String prefix, int startDigit, int n, List<String> result) {
	        if (n == 0) {
	            result.add(prefix);
	            return;
	        }
	        
	        for (int i = startDigit; i <= 9; i++) {
	            generateNumbers(prefix + i, i, n - 1, result);
	        }
	    }
}
