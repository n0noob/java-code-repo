package com.softvision.test_proj.arrayoperations;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamOperations {
	
	public static void main(String[] args) {
		//Infinite stream
		Stream<Integer> stream = Stream.iterate(0, i -> i + 3);
		int[] a = {23,24,25,26,27,28,29,10,11,12,13,14,15,16,17};
		stream.limit(5).forEach((i) -> {
			if(i < a.length )
				System.out.println(a[i]);
			});
		
		//Stream of UUID
		Supplier<UUID> randomUUIDSupplier = UUID::randomUUID;
		Stream<UUID> infiniteStreamOfRandomUUID = Stream.generate(randomUUIDSupplier);
		infiniteStreamOfRandomUUID
		  .skip(10)
		  .limit(10).forEach(System.out::println);
		
		
		
		//Grouping elements i.e. converting list or stream to map
		List<String> names = Arrays.asList("Pranaal", "Swastik", "Michelle", "Alexa");
		Map<Character, List<String>> map = names
											.stream()
											.collect(Collectors.groupingBy((name) -> name.charAt(0)));
		
		for(Map.Entry<Character, List<String>> e : map.entrySet()) {
			System.out.println(e.getKey() + " <> " + e.getValue());
		}
		
	}
	
}
