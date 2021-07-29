package com.comprog.arrayoperations;

public class MoveAllZeroesToEnd {
	public void moveZeroesToEnd(int[] a) {
		// When array is empty or contains 1 element
		if (a == null || a.length == 0 || a.length == 1) {
			return;
		}

		// Count number of non-zero elements
		int count = 0;

		// Find number of non-zero elements in array from the beginning
		for (int i = 0; i < a.length; i++) {
			if (a[i] != 0) {
				swap(a, count++, i);
			}
		}
	}

	public void swap(int[] a, int i, int j) {
		if (i == j)
			return;

		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;

	}

	public static void main(String[] args) {
		MoveAllZeroesToEnd driver = new MoveAllZeroesToEnd();
		int a[] = { 1, 2, 0, 0, 3, 776, 0, 11 };

		driver.moveZeroesToEnd(a);

		// Print elements
		for (int i = 0; i < a.length; i++)
			System.out.print(a[i] + " ");

	}
}
