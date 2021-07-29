package com.comprog.arrayoperations;

public class MinLenSubArrayWithSumGE_K {

	public int minLenSubArrayWithSumGreaterThanK(int[] a, int k) {
		// Case when empty array
		if (a == null || a.length == 0)
			return -1;

		// Case when length is 1
		int start = 0;
		int end = 0;
		int curr_sum = 0;
		int min_len = Integer.MAX_VALUE;

		while (true) {
			// Till sum is less than k
			while (end < a.length && curr_sum < k) {
				curr_sum += a[end++];
			}

			// Reduce the window till size of subarray greater than or equal to k
			while (curr_sum >= k) {
				if (end - start < min_len)
					min_len = end - start;

				// Remove start from window
				curr_sum -= a[start++];
			}

			if (end >= a.length)
				break;
		}

		if (min_len == Integer.MAX_VALUE)
			min_len = -1;

		return min_len;

	}

	public static void main(String[] args) {
		MinLenSubArrayWithSumGE_K driver = new MinLenSubArrayWithSumGE_K();
		int[] a = { 1, 2, 3, 4 };

		int res = driver.minLenSubArrayWithSumGreaterThanK(a, 9);

		System.out.println("RES : " + res);
	}
}