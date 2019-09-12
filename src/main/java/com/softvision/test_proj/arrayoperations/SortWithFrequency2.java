package com.softvision.test_proj.arrayoperations;

import java.io.*;
import java.util.*;
import java.util.stream.*;

public class SortWithFrequency2 {

	public void sortFrequency2(int[] a) {
		// Case when array is empty
		if (a == null || a.length < 2)
			return;

		// Normal case
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < a.length; i++) {
			if (!map.containsKey(a[i])) {
				map.put(a[i], 1);
			} else {
				map.put(a[i], map.get(a[i]) + 1);
			}
		}

		Set<Map.Entry<Integer, Integer>> sortedSet = map.entrySet().stream().sorted((x, y) -> {
			return y.getValue() - x.getValue();
		}).collect(Collectors.toSet());

		int i = 0;
		for (Map.Entry<Integer, Integer> x : sortedSet) {
			int value = x.getValue();
			while (value-- != 0) {
				a[i++] = x.getKey();
			}
		}
	}

	public static void main(String[] args) {
		SortWithFrequency2 driver = new SortWithFrequency2();
		int[] a = { 2, 3, 4, 2, 4, 2, 7 };

		driver.sortFrequency2(a);

		System.out.println(Arrays.toString(a));
	}

}