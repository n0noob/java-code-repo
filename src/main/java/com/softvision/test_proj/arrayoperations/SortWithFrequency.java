package com.softvision.test_proj.arrayoperations;

import java.util.*;
import java.util.stream.*;

public class SortWithFrequency {

	class Pair<K, V> {
		public K key;
		public V value;

		public Pair(K k, V v) {
			this.key = k;
			this.value = v;
		}

	}

	public void sortFrequency(int[] a) {
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

		List<Pair<Integer, Integer>> list = map.entrySet().stream().sorted((x, y) -> {
			return y.getValue() - x.getValue();
		}).map((x) -> {
			return new Pair<Integer, Integer>(x.getKey(), x.getValue());
		}).collect(Collectors.toList());

		int i = 0;
		for (Pair<Integer, Integer> x : list) {
			while (x.value-- != 0) {
				a[i++] = x.key;
			}
		}
	}

	public static void main(String[] args) {
		SortWithFrequency driver = new SortWithFrequency();
		int[] a = { 2, 3, 4, 2, 4, 2, 7 };

		driver.sortFrequency(a);

		System.out.println(Arrays.toString(a));
	}

}