package com.comprog.arrayoperations;

public class KadanesAlgorithm {

	// Kadane's algorithm
	public int maxSumSubArray(int[] a) {

		int maxSoFar = 0;
		int maxEndingHere = 0;

		for (int i = 0; i < a.length; i++) {
			maxEndingHere += a[i];

			if (maxEndingHere < 0)
				maxEndingHere = 0;

			maxSoFar = Math.max(maxEndingHere, maxSoFar);
			// System.out.println("At position : " + i + " maxEndingHere : " +
			// maxEndingHere);
		}

		return maxSoFar;
	}

	// Kadane's algorithm (printing max sum subarray)
	public int prinMaxSumSubArray(int[] a) {

		int maxSoFar = 0;
		int maxEndingHere = 0;
		int start = 0;
		int bestStart = 0;

		for (int i = 0; i < a.length; i++) {
			maxEndingHere += a[i];

			if (maxEndingHere < 0) {
				start = i + 1;
				maxEndingHere = 0;
			}

			if (maxEndingHere > maxSoFar) {
				maxSoFar = maxEndingHere;
				bestStart = start;
			}
		}

		// Printing max sum subarray
		int tempSum = maxSoFar;
		for (int i = bestStart; tempSum > 0 && i < a.length; i++) {
			tempSum -= a[i];
			System.out.print(" " + a[i]);
		}

		return maxSoFar;
	}

	public static void main(String[] args) {
		KadanesAlgorithm driver = new KadanesAlgorithm();
		int[] a = { -2, -3, 4, -1, -2, 1, 5, -3 };
		int res = driver.maxSumSubArray(a);
		System.out.println("Result : " + res);
	}
}
