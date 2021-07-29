package com.comprog.algorithm.dp;

public class LISProblem {

	public int LIS_DP(int[] a) {
		int[] dp = new int[a.length + 1];

		// In worst case min length of LIS is one
		for (int i = 0; i < a.length; i++) {
			dp[i] = 1;
		}

		for (int i = 1; i < a.length; i++) {

			int j = i - 1;
			while (j >= 0 && a[j] > a[i]) {
				j--;
			}
			if (j != -1) {
				dp[i] = 1 + dp[j];
			}
		}

		return dp[a.length - 1];

	}

	public int LIS(int[] a, int n) {
		// When no elements are there in input
		if (n == -1) {
			return 0;
		}

		// When one element is present
		if (n == 0) {
			return 1;
		}

		int maxLength = 1;

		for (int i = 0; i <= n - 1; i++) {

			if (a[n] > a[i]) {
				int res = 1 + LIS(a, i);
				if (res > maxLength) {
					maxLength = res;
				}
			}

		}

		return maxLength;
	}

	public static void main(String[] args) {
		LISProblem driver = new LISProblem();
		int[] a = { 50, 3, 10, 7, 40, 80 };

		//int res = driver.LIS(a, a.length - 1);
		int res = driver.LIS_DP(a);
		System.out.println("RESULT : " + res);
	}
}