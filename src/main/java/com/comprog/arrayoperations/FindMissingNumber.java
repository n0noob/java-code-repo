package com.comprog.arrayoperations;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class FindMissingNumber {

	public int findMissingNumber3(int[] a) {
		// If there is no missing element
		if (a == null || a.length == 0)
			return 0;

		int osum = 0;
		int n = a.length;

		for (int i = 0; i < a.length; i++) {
			osum += a[i];
		}

		// System.out.println();

		int rsum = (n * (n + 1)) / 2;
		int missingNumber = rsum - osum;
		return missingNumber;
	}

	public int findMissingNumber2(int[] a) {
		// If there is no missing element
		if (a == null || a.length == 0)
			return 0;

		Set<Integer> set = new HashSet<>();
		for (int i = 0; i < a.length; i++) {
			set.add(a[i]);
		}

		for (int i = 1; i <= a.length; i++) {
			if (!set.contains(i))
				return i;
		}

		return 0;
	}

	public int findMissingNumber(int[] a) {
		Arrays.sort(a);

		// If there is no missing element
		if (a == null || a.length == 0 && a[0] != 0)
			return 0;

		int i = 0;
		for (; i < a.length; i++) {
			if (a[i] != i) {
				return i;
			}
		}

		if (i == a.length)
			return i;
		return 0;
	}

	public static void main(String[] args) {
		FindMissingNumber driver = new FindMissingNumber();
		int[] a = { 2, 5, 4, 1, 0 };

		int res = driver.findMissingNumber3(a);
		System.out.println(res);
	}
}
