package com.comprog.arrayoperations;

public class SeggeragateOddEvenWithoutOrder {
	public void segregateOddEvenWithoutOrder(int a[]) {
		int countOdd = 0;

		// For each element
		for (int i = 0; i < a.length; i++) {
			// If element is odd
			if (a[i] % 2 != 0) {
				swap(countOdd++, i, a);
			}
		}
	}

	private void swap(int i, int j, int[] a) {
		if (i == j) {
			return;
		}

		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}

	public static void main(String[] args) {
		SeggeragateOddEvenWithoutOrder driver = new SeggeragateOddEvenWithoutOrder();
		int a[] = { 14, 9, 7, 5, 2, 18, 6, 13 };

		driver.segregateOddEvenWithoutOrder(a);

		// Print array
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}
	}
}
