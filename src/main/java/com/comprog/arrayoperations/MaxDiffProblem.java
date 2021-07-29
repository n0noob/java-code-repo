package com.comprog.arrayoperations;

public class MaxDiffProblem {

	public int getMaxDiff(int[] a) {
		// Invalid data
		if (a == null || a.length < 2) {
			return 0;
		}

		// Valid data
		int ptr = 0;
		int max_diff = Integer.MIN_VALUE;
		for (int i = 1; i < a.length; i++) {
			// Next element has to be bigger
			if (a[i] >= a[ptr]) {
				// Check diff
				if (a[i] - a[ptr] > max_diff) {
					max_diff = a[i] - a[ptr];
				}
			}
			// If element is smaller that what is present at ptr
			else {
				ptr = i;
			}
		}

		return max_diff;

	}

	public static void main(String[] args) {
		MaxDiffProblem driver = new MaxDiffProblem();
		int[] a = { 7, 9, 5, 6, 3, 2 };

		int res = driver.getMaxDiff(a);
		System.out.println(res);
	}
}