package com.softvision.test_proj.arrayoperations;

public class MinDistBetweenArrayElements {

	public int getMinDistBetweenTwoElements(int[] a, int x, int y) {
		// Invalid data
		if (a == null || a.length == 0)
			return -1;

		// x and y are equal
		if (x == y)
			return 0;

		int ptr = -1;
		int min_dist = Integer.MAX_VALUE;
		for (int i = 0; i < a.length; i++) {
			// If any of the elements are found
			if (a[i] == x || a[i] == y) {

				// If ptr is not found for first time
				if (ptr != -1 && a[ptr] != a[i] && i - ptr < min_dist)
					min_dist = i - ptr;

				// Change the ptr anyways
				ptr = i;
			}
		}

		if (min_dist == Integer.MAX_VALUE)
			min_dist = -1;

		return min_dist;
	}

	public static void main(String[] args) {
		MinDistBetweenArrayElements driver = new MinDistBetweenArrayElements();
		int[] a = { 2, 3, 4, 5, 2, 4, 6, 5, 1, 2, 3, 2 };
		int res = driver.getMinDistBetweenTwoElements(a, 7, 1);

		System.out.println(res);
	}
}
