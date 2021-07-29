package com.comprog.arrayoperations;

import java.util.*;

class CountPairsWithSumLessThanK {

	/*
	 * NOTE : Previous sum always contributes to next sum and difference doesn't
	 *
	 */

	public int countPairsWithSumLessThanK(int[] a, final int k) {

		Arrays.sort(a);
		System.out.println(Arrays.toString(a));

		int start = 0;
		int sum = 0, count = 0;

		// Select the largest window
		for (int end = a.length - 1; start < end;) {
			// If the sum is less than k
			if (a[end] + a[start] < k) {

				System.out.println("Pair : " + a[start] + "<>" + a[end]);

				count += (end - start);
				start++;
			}
			// If the sum is greater than or equal to k
			else {
				end--;
			}
		}
		return count;
	}

	public static void main(String[] args) {
		CountPairsWithSumLessThanK driver = new CountPairsWithSumLessThanK();
		int[] a = { 1, 22, 5, 6, 8, -12, -2 };
		int res = driver.countPairsWithSumLessThanK(a, 3);
		System.out.println("RES : " + res);
	}

}
