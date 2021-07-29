package com.comprog.arrayoperations;

public class FindElementWhereLeftSumEqualRightSum {

	public void findElementLeftSumRightSumEqual(int[] a) {

		// Calculate sum of all elements first
		int totalSum = 0;
		for (int i = 0; i < a.length; i++) {
			totalSum += a[i];
		}

		// Take one element at a time
		int leftSum = 0;
		int rightSum = totalSum;
		for (int i = 0; i < a.length; i++) {
			// a[i] is the test element for now
			rightSum -= a[i];

			// Except first iteration
			if (i != 0) {
				leftSum += a[i - 1];
			}

			if (leftSum == rightSum) {

				System.out.println("Exists and that element is " + a[i]);
				return;
			}
		}

	}

	public static void main(String[] args) {
		FindElementWhereLeftSumEqualRightSum driver = new FindElementWhereLeftSumEqualRightSum();
		int[] a = { 1, 4, 2, 5 };

		driver.findElementLeftSumRightSumEqual(a);

	}
}
