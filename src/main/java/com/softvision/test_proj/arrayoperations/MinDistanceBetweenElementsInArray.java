package com.softvision.test_proj.arrayoperations;

public class MinDistanceBetweenElementsInArray {

	public int calculateMinDistance(int[] a, int x, int y) {
		// If x and y are same
		if (x == y) {
			// Case when x is not present in array return -1
			if (findIndex(a, x) == -1)
				return -1;

			// Case when x is present in array return 0
			return 0;
		}

		// If x and y are not same start iterating over each element
		int ptr = -1;
		int minDist = Integer.MAX_VALUE;
		for (int i = 0; i < a.length; i++) {
			// Initial assignment of ptr
			if (ptr == -1 && (a[i] == x || a[i] == y)) {
				ptr = i;
			}

			// Now look for second element
			if (ptr != -1 && (a[i] == x || a[i] == y)) {
				// if this is other element
				if (a[i] != a[ptr]) {

					// if distance between i th element and ptr th element is less than minDist
					if (minDist > (i - ptr)) {
						minDist = i - ptr;
					}

				}

				// In any case reset ptr
				ptr = i;
			}

		}

		if (minDist == Integer.MAX_VALUE)
			minDist = -1;

		return minDist;
	}

	private int findIndex(int[] a, int ele) {
		for (int i = 0; i < a.length; i++) {
			if (a[i] == ele) {
				return i;
			}
		}

		return -1;
	}

	public static void main(String[] args) {
		MinDistanceBetweenElementsInArray driver = new MinDistanceBetweenElementsInArray();
		int a[] = { 3, 5, 4, 2, 6, 5, 6, 6, 5, 4, 8, 3 };

		int d = driver.calculateMinDistance(a, 3, 6);

		System.out.println("Distance between elements = " + d);
	}
}
