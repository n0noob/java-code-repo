package com.softvision.test_proj.arrayoperations;

import java.util.Arrays;

public class ReverseArray {

	public void reverseArray(int[] a) {
		System.out.println(Arrays.toString(a));

		for (int i = 0; i < a.length / 2; i++) {
			swap(a, i, a.length - i - 1);
		}

		System.out.println(Arrays.toString(a));
	}

	private void swap(int[] a, int i, int j) {
		if (i == j || a[i] == a[j])
			return;

		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;

	}

	public static void main(String[] args) {
		ReverseArray driver = new ReverseArray();
		int[] a = { 1, 9, 2, 8, 6, 4 };
		driver.reverseArray(a);
	}
}