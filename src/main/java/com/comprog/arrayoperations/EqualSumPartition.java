package com.comprog.arrayoperations;

public class EqualSumPartition {

	public int equalSumPartition(int[] a) {

		// Case when required elements are not there
		if (a == null || a.length == 0) {
			System.out.println("Error everywhere");
			return -1;
		}

		// Case when required number of elements are there
		int right_sum = 0;
		for (int i = 0; i < a.length; i++) {
			right_sum += a[i];
		}

		int left_sum = 0;
		for (int i = 0; i < a.length; i++) {
			// Pick one test element at a time i.e. a[i]
			right_sum -= a[i];
			if (left_sum == right_sum)
				return a[i];
			left_sum += a[i];
		}

		System.out.println("No elements are there");
		return -1;

	}

	public static void main(String[] args) {
		EqualSumPartition driver = new EqualSumPartition();
		int[] a = { 3, 0 };

		int res = driver.equalSumPartition(a);

		System.out.println("RES : " + res);
	}

}