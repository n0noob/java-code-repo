package com.softvision.test_proj.arrayoperations;

import java.util.Arrays;

public class EvenOddAlternate {

	/* Even numbers at even index and odd numbers at odd index */
	public void rearrangeEvenOddAlternate(int[] a) {

		// Special case
		if (a == null || a.length < 2)
			return;

		int evenIndex = 0;
		int oddIndex = 1;

		// Normal case
		for (int i = 0; i < a.length; i++) {

			while (evenIndex < a.length && a[evenIndex] % 2 == 0) {
				evenIndex += 2;
			}

			while (oddIndex < a.length && a[oddIndex] % 2 != 0) {
				oddIndex += 2;
			}

			System.out.println("Even Index= " + evenIndex);
			System.out.println("Odd Index= " + oddIndex);

			if (evenIndex < a.length && oddIndex < a.length) {
				System.out.println("Swapping");
				swap(a, evenIndex, oddIndex);
			} else {
				break;
			}

		}

	}

	private void swap(int[] a, int i, int j) {
		if (i == j || a[i] == a[j])
			return;

		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;

	}

	public static void main(String[] args) {
		EvenOddAlternate driver = new EvenOddAlternate();
		int[] a = { 2, 3, 5, 8, 9 };

		driver.rearrangeEvenOddAlternate(a);

		System.out.println(Arrays.toString(a));
	}
}