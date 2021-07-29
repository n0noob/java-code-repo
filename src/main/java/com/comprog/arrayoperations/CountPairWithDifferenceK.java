package com.comprog.arrayoperations;

import java.util.*;

public class CountPairWithDifferenceK {

	public int countPairWithDifferenceK(int[] a, int k) {
		if (a == null || a.length == 0)
			return -1;

		Arrays.sort(a);

		int start = 0, end = 0;
		int count = 0;

		while (true) {
			// Expand window
			while (end < a.length && (a[end] - a[start]) <= k) {
				if (a[end] - a[start] == k) {
					System.out.println(a[start] + " " + a[end]);
					count++;
				}
				end++;
			}

			if (end == a.length)
				break;

			// Reduce window
			while (start < a.length && (a[end] - a[start]) > k) {
				start++;
			}

			/*
			 * if(a[end] - a[start] < k && end == a.length - 1) break;
			 */
		}

		return count;

	}

	public static void main(String[] args) {
		CountPairWithDifferenceK driver = new CountPairWithDifferenceK();
		int[] a = { 55, 2, 33, 44, 11, 10 };

		int res = driver.countPairWithDifferenceK(a, 11);
		System.out.println("Res : " + res);
	}

}
