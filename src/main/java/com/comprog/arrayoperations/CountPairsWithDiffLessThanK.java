package com.comprog.arrayoperations;

import java.util.*;

public class CountPairsWithDiffLessThanK {

	// Version 1
	public int countPairsWithDiffLessThanK(int[] a, int k) {
		int count = 0;

		for (int i = 0; i < a.length; i++) {
			int j = i + 1;
			for (; j < a.length; j++) {
				if (Math.abs(a[j] - a[i]) < k) {
					System.out.println(a[i] + "<>" + a[j]);
					count++;
				}
			}
		}

		return count;
	}

	// Version 2
	public int countPairsWithDiffLessThanK2(int[] a, int k) {
		int count = 0;

		Arrays.sort(a);
		// Print sorted array
		System.out.println("Sorted array : " + Arrays.toString(a));

		int start = 0;
		int end = 1;

		while (start < a.length) {
			// Expanding window
			while (end < a.length && a[end] - a[start] < k) {
				end++;
			}

			// System.out.println(a[start] + "<>" + a[end]);
			if (end != start) {
				System.out.println(a[start] + "<>" + a[end - 1]);
				count += (end - start) - 1;
			}
			// Shrinking window
			start++;
		}

		return count;

	}

	public static void main(String[] args) {
		CountPairsWithDiffLessThanK driver = new CountPairsWithDiffLessThanK();
		int[] a = {5,2,3,4};
		int res = driver.countPairsWithDiffLessThanK2(a, 3);
		System.out.println(res);
	}
}