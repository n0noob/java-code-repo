package com.softvision.test_proj.arrayoperations;

import java.util.Arrays;

public class WaveSort {

	public void sortWave(int[] a) {
		if (a == null || a.length < 2)
			return;

		for (int i = 1; i < a.length; i++) {
			// if even index -> current element should be greater than previous
			if (i % 2 == 0 && a[i] < a[i - 1]) {
				swap(a, i, i - 1);
			}
			if (i % 2 != 0 && a[i] > a[i - 1]) {
				swap(a, i, i - 1);
			}
		}
	}

	private void swap(int[] a, int i, int j) {

		if (i == j || a[i] == a[j]) {
			return;
		}

		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}

	public static void main(String[] args) {
		WaveSort driver = new WaveSort();
		int[] a = { 3, 6, 5, 10, 7, 20 };

		System.out.println(Arrays.toString(a));

		driver.sortWave(a);

		System.out.println(Arrays.toString(a));
	}

}
