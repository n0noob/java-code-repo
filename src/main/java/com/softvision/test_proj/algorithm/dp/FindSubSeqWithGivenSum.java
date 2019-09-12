package com.softvision.test_proj.algorithm.dp;

import java.util.ArrayList;
import java.util.List;

public class FindSubSeqWithGivenSum {

	// Perfect Sum Problem (Print all subsets with given sum)
	public void findSubSeqWithGivenSum(int[] a, int n, int k, List<Integer> chosen) {
		// base case
		// Remaining sum == 0
		if (k == 0) {
			System.out.println("Combination found : " + chosen);
			return;
		}

		// if remaining elements == 0
		if (n == -1) {
			System.out.println("Hitting end");
			return;
		}

		List<Integer> withCurrent = new ArrayList<>();
		withCurrent.addAll(chosen);
		withCurrent.add(a[n]);

		List<Integer> withoutCurrent = new ArrayList<>();
		withoutCurrent.addAll(chosen);

		// If a[n] is chosen
		if (a[n] <= k)
			findSubSeqWithGivenSum(a, n - 1, k - a[n], withCurrent);

		findSubSeqWithGivenSum(a, n - 1, k, withoutCurrent);

	}

	public static void main(String[] args) {
		FindSubSeqWithGivenSum driver = new FindSubSeqWithGivenSum();
		int[] a = { 2, 3, 5, 6, 8, 10 };// {1, 2, 3, 4, 5};
		int sum = 10;

		driver.findSubSeqWithGivenSum(a, a.length - 1, sum, new ArrayList<>());
	}
}
