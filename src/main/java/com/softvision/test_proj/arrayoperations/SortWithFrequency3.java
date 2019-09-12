package com.softvision.test_proj.arrayoperations;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class SortWithFrequency3 {

	class Pair<T> {
		T key, value;

		public Pair(T k, T v) {
			this.key = k;
			this.value = v;
		}
	}

	public void sortWithFrequency(int[] a) {
		Map<Integer, Integer> map = new HashMap<>();

		for (int i = 0; i < a.length; i++) {
			if (map.containsKey(a[i]))
				map.put(a[i], map.get(a[i]) + 1);
			else
				map.put(a[i], 1);
		}

		List<Pair<Integer>> list = map.entrySet().stream().map((x) -> {
				return new Pair<Integer>(x.getKey(), x.getValue());
			}).sorted((x, y) -> {
				if (x.value == y.value)
					return x.key - y.key;
				return y.value - x.value;
			}).collect(Collectors.toList());

		int i = 0;
		for (Pair<Integer> e : list) {
			int temp = e.value;
			while (temp-- != 0)
				a[i++] = e.key;
		}

		System.out.println(Arrays.toString(a));
	}

	public static void main(String[] args) {
		SortWithFrequency3 driver = new SortWithFrequency3();
		int[] a = { 5, 4, 2, 4, 1, 4, 4, 5, 1 };

		driver.sortWithFrequency(a);
	}

}
