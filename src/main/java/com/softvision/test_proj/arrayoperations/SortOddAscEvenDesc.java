package com.softvision.test_proj.arrayoperations;

import java.io.*;
import java.util.*;

public class SortOddAscEvenDesc {

	public void sortOddAscEvenDesc(Integer[] a) {

		// If required number of elements are not there in array
		if (a == null || a.length == 0 || a.length == 1)
			return;

		// Separate odd first and then even
		int countOdd = 0;
		for (int i = 0; i < a.length; i++) {

			// If odd number is encountered
			if (a[i] % 2 != 0) {
				swap(a, countOdd++, i);
			}

		}

		// Done separating odd and even
		Arrays.sort(a, 0, countOdd);
		Arrays.sort(a, countOdd, a.length - 1);
	}

	private void swap(Integer[] a, int i, int j) {
		if (i == j || a[i] == a[j])
			return;

		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}

	public static void main(String[] args) {
		SortOddAscEvenDesc driver = new SortOddAscEvenDesc();
		Integer[] a = { 9, 12, 3, 4, 5, 6, 7, 8 };

		driver.sortOddAscEvenDesc(a);

		System.out.println(Arrays.toString(a));
	}
}
