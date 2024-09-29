package com.shopping.basket.apps.utils;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class GroupByUtils {
	
	public static void ContentGroupBy(String content) {
		
		
		System.out.println(content+ "---" + content.chars().count());
		
		// Counting character
		Map<Character, Long> resultCount   = content.chars().mapToObj(c -> (char) c)
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
		
		// Sort by count values
		Map<Character, Long> resultCount1   = resultCount.entrySet().stream().sorted(Map.Entry.comparingByValue())
			.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (oldValue, newValue) -> oldValue, LinkedHashMap::new));
		
		
		
		
		resultCount1.forEach((character, count) -> System.out.println(character + "---" + count));
		
		System.out.println(resultCount1.size());
		
		
	}
	
	public static void main(String arg[]) {
		ContentGroupBy("common");
	}

}
