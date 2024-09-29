package com.shopping.basket.apps.utils;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class SumOfInterger {
	
	public static void sumOfInteger(List<String> listOfVal) {
		
		
		
		listOfVal.stream().mapToInt(n -> Integer.parseInt(n)).sum();
		
		
		System.out.println(listOfVal.stream().mapToInt(num -> Integer.parseInt(num)).sum());
		
		List<Integer> sum = listOfVal.stream()
				.map(num -> Integer.parseInt(num)).collect(Collectors.toList());
		
		System.out.println(listOfVal.stream().map(num -> Integer.parseInt(num)).mapToInt(Integer::intValue).sum());
		
		listOfVal.stream().mapToInt(num->Integer.parseInt(num)).sum();
		
		System.out.println(sum.stream().mapToInt(Integer::intValue).sum());
		
		Map<String,String> valueOfStr = new HashMap<>();
		valueOfStr.put("A1", "Test");
		valueOfStr.put("C1", "Test2");
		valueOfStr.put("D1", "Test3");
		valueOfStr.put("B1", "Test1");
		
		
		Map<String, String> sortedVal = valueOfStr.entrySet()
				.stream().sorted(Map.Entry.comparingByValue())
				.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
				(oldValue, newValue)-> oldValue, LinkedHashMap::new));
		
		Map<String,String> all = valueOfStr.entrySet().stream().sorted(Map.Entry.comparingByValue())
				.collect(Collectors.toMap(Map.Entry::getKey,Map.Entry::getValue,(oldValue, neValue)->oldValue,LinkedHashMap::new));
		
		System.out.println("Value of Sorted : " + valueOfStr);
		
		System.out.println("Sorted Val : " + sortedVal);
		
		System.out.println("All : "+all);
		
		
		Map<String,String> valueOfStr1 = valueOfStr.entrySet()
			.stream()
			.sorted(Map.Entry.<String, String>comparingByValue().reversed())
			.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, 
					(oldValue, newValue)->oldValue, LinkedHashMap::new));
		
		
		 System.out.println("By Value Reversed : "+ valueOfStr1);
		 
		 
		 
		 Map<String,String> valueOfStr2 = valueOfStr.entrySet().stream().sorted(Map.Entry.comparingByValue())
				 .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
				 (oldValue, newValue)-> newValue, LinkedHashMap::new));
		 	
		 System.out.println("By Value : "+valueOfStr2);
		
	}
 
	public static void main(String arg[]) {
		List<String> listOfStr = Arrays.asList("1","2","3","4","5");
		sumOfInteger(listOfStr);
		
		
		
		
		Map<String, Integer> map = new HashMap<>();
        map.put("Alice", 30);
        map.put("Bob", 25);
        map.put("Charlie", 35);
        map.put("David", 20);

        Map<String, Integer> sortedByValue = map.entrySet().stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                        (oldValue, newValue) -> newValue, LinkedHashMap::new));

        System.out.println("Sorted by value: " + sortedByValue);
        
        String text = "COmmon";
        
       Map<Character, Long> result= text.toLowerCase().chars().mapToObj( c -> (char) c)
    		   .collect( Collectors.groupingBy(Function.identity(), Collectors.counting()));
       
        result.entrySet().stream().sorted(Map.Entry.<Character, Long>comparingByValue().reversed())
    		   .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
    		   (oldValue, newValue) -> oldValue, LinkedHashMap::new))
    		   .forEach((k, v )-> {System.out.println(k + " - " + v);});
       
       System.out.println(result);	
       
		
	}

}
