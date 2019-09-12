package com.softvision.test_proj.arrayoperations;

import java.util.Arrays;

public class CountSubArrayWithProdLTK {
	// Count no of subaarays having product less than target number (Sorted)
	public int countSubStringWithProdWithLTK(int[] a, int k) {

		Arrays.sort(a);
		System.out.println(Arrays.toString(a));

		int start = 0, end = 0, count = 0;
		int prod = 1;
		while (end < a.length) {
			// Expand window
			while (end < a.length && prod < k) {
				if (a[end] < k) {
					count++;
				}
				prod = prod * a[end++];
				// System.out.println(prod);
			}

			count += (end - start - 1);
			// System.out.println(a[start] + "<>" + a[end-1]);
			// System.out.println(count);

			while (start < end && prod >= k) {
				// System.out.println(" > " + a[start]);
				prod = prod / a[start++];
			}
		}
		return count;

	}

	public static void main(String[] args) {
		CountSubArrayWithProdLTK driver = new CountSubArrayWithProdLTK();
		int[] a = { 1, 9, 2, 8, 6, 4, 3 };
		int count = driver.countSubStringWithProdWithLTK(a, 100);
		System.out.println(count);
	}
}