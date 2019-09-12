package com.softvision.test_proj.arrayoperations;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PrintModuloPairs {
	private List<Integer> getDivisors(final int n) {
		if (n == 0)
			return new ArrayList<>(0);

		List<Integer> list = new ArrayList<>();
		for (int i = 1; i * i < n; i++) {
			if (n % i == 0) {
				if (i * i == n) {
					list.add(i);
				} else {
					list.add(i);
					list.add(n / i);
				}
			}
		}

		return list;
	}

	public void printModuloPairs2(final int[] a, final int k) {

		Map<Integer, Boolean> map = new HashMap<>();
		// Populate map
		for (int i = 0; i < a.length; i++) {
			map.putIfAbsent(a[i], true);
		}

		for (int i = 0; i < a.length; i++) {
			// For each element

			// Check if k is present in array and ith element is greater than k
			if (map.containsKey(k) && k < a[i])
				System.out.print("(" + a[i] + ", " + k + ") ");

			int test = a[i] - k;
			List<Integer> divisors = getDivisors(test);
			for (Integer divisor : divisors) {
				if (a[i] % divisor == k && a[i] != divisor && map.containsKey(divisor))
					System.out.print("(" + a[i] + ", " + divisor + ") ");
			}

		}

	}

	// Find all pairs with a%b == k
	public void printModuloPairs(final int[] a, final int k) {

		for (int i = 0; i < a.length; i++) {
			for (int j = i + 1; j < a.length; j++) {
				if (a[i] % a[j] == k || a[j] % a[i] == k) {
					System.out.print("(" + a[i] + ", " + a[j] + ") ");
				}
			}
		}
	}

	public static void main(String[] args) {
		PrintModuloPairs driver = new PrintModuloPairs();
		int[] a = { 5, 3, 6, 2 };

		driver.printModuloPairs2(a, 2);

	}

}
