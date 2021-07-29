package com.comprog.arrayoperations;

public class MedianOfTwoArrays {

	public float getMedianOfTwo(int[] a, int[] b, int start1, int end1, int start2, int end2) {

		int l1 = end1 - start1 + 1;
		int l2 = end2 - start2 + 1;

		System.out.println("L1 = " + l1);
		System.out.println("L2 = " + l2);

		if (l1 != l2 || l1 == 0) {
			throw new RuntimeException();
		}

		// If length of both the array is one
		if (l1 == 1) {
			System.out.println("Base condition reached with " + a[start1] + " " + b[start2]);

			return (float) (a[start1] + b[start2]) / 2;
		}

		// If length is greater than one
		float median1 = getMedianOfOne(a, start1, end1);
		float median2 = getMedianOfOne(b, start2, end2);

		System.out.println("start1 = " + a[start1] + " end1 = " + a[end1]);
		System.out.println("start2 = " + b[start2] + " end2 = " + b[end2]);

		if (median1 > median2) {
			if (l1 % 2 == 0)
				return getMedianOfTwo(a, b, start1, start1 + (l1 / 2) - 1, start2 + (l2 / 2), end2);
			return getMedianOfTwo(a, b, start1, start1 + (l1 / 2), start2 + (l2 / 2), end2);
		} else if (median2 > median1) {
			if (l1 % 2 == 0)
				return getMedianOfTwo(a, b, start1 + (l1 / 2), end1, start2, start2 + (l1 / 2) - 1);
			return getMedianOfTwo(a, b, start1 + (l1 / 2), end1, start2, start2 + (l1 / 2));
		}

		// Case when both the medians are equal
		return median1;
	}

	private float getMedianOfOne(int[] a, int start, int end) {
		int n = end - start + 1;

		if (n == 1)
			return a[0];

		int mid;

		if (n % 2 == 0) {
			mid = (n - 1) / 2;
			return (float) (a[start + mid] + a[start + mid + 1]) / 2;
		} else {
			mid = n / 2;
			return (float) a[start + mid];
		}
	}

	public static void main(String[] args) {
		MedianOfTwoArrays driver = new MedianOfTwoArrays();

		int[] a = { 2, 3, 4, 5, 6 };
		int[] b = { 1, 2, 3, 8, 10 };

		// 1, 2, 2, 3, 3, 4, 5, 6, 8, 10

		// float res = driver.getMedianOfOne(a, 0, a.length - 1);

		float res = driver.getMedianOfTwo(a, b, 0, a.length - 1, 0, b.length - 1);
		System.out.println("RESULT : " + res);
	}
}