package com.softvision.test_proj.arrayoperations;

public class FindIndexOfOnlyDifferentElement {

	public int findIndexOfOnlyDifferentElement(int[] a) {
		// Case when array is null or contains 2 or less elements return invalid index
		if (a == null || a.length < 3)
			return -1;

		// If first element is different
		if (a[0] != a[1] && a[0] != a[2]) {
			return 0;
		}

		// If last element is different
		if (a[a.length - 1] != a[0] && a[a.length - 1] != a[1]) {
			return a.length - 1;
		}

		// Loop skipping first and last element
		for (int i = 1; i < a.length - 1; i++) {
			if (a[i] != a[i - 1] && a[i] != a[i + 1]) {
				return i;
			}
		}

		return -1;
	}

	public static void main(String[] args) {
		FindIndexOfOnlyDifferentElement driver = new FindIndexOfOnlyDifferentElement();
		int[] a = { 1, 1, 1, 1, 1, 4 };

		int res = driver.findIndexOfOnlyDifferentElement(a);

		System.out.print("Position of different element = " + res);
	}

}
