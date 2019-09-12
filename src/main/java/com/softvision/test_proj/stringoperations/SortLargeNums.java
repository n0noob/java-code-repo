package com.softvision.test_proj.stringoperations;

import java.util.Arrays;

public class SortLargeNums {

	public void sortLargeNumbers(String[] a) {
		Arrays.sort(a, (x, y) -> {

			// First compare with length
			if (x.length() != y.length())
				return x.length() - y.length();

			// Now compare logically
			return x.compareTo(y);

		});
	}

	public static void main(String[] args) {
		String[] arr = { "1", "321", "443", "23", "412431212123123", "5423534" };

		SortLargeNums driver = new SortLargeNums();
		driver.sortLargeNumbers(arr);

		System.out.println(Arrays.toString(arr));
	}
}