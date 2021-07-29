package com.comprog.arrayoperations;

public class SumOfProductOfPairs {

	public int getSumOfPairProduct(int[] a) {
		// If empty array or contains one element only
		if (a == null || a.length == 0 || a.length == 1) {
			return 0;
		}

		// If array contains two or more elements
		int prod = 1;
		int sum = 0;
		int temp_sum = a[0];
		for (int i = 1; i < a.length; i++) {
			prod = a[i] * temp_sum;
			temp_sum += a[i];
			sum += prod;
			prod = 1;
		}

		return sum;
	}

	public static void main(String[] args) {
		SumOfProductOfPairs driver = new SumOfProductOfPairs();
		int a[] = { 1, 2, 3, 4 };

		int sum = driver.getSumOfPairProduct(a);

		System.out.println("Sum = " + sum);
	}
}
