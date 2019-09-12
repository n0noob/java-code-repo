package com.softvision.test_proj.arrayoperations;

public class CountPairsWithSumGTK {

	
	
	public int countPairsWithSumGTK(int[] a, int k) {
		int invertPair = countPairsWithSumLessThanK2(a, k);

		int totalPairs = comb(a.length, 2);
		// System.out.println("Total Pairs : " + totalPairs);

		// System.out.println("Pairs with less than K sum : " + invertPair);
		return totalPairs - invertPair;

	}

	private int comb(int n, int r) {
		int up = fact(n);
		int down = fact(r) * fact(n - r);

		return up / down;
	}

	private int fact(int n) {
		if (n == 0)
			return 1;

		int prod = 1;
		for (int i = 1; i <= n; i++) {
			prod *= i;
		}

		return prod;
	}

	public int countPairsWithSumLessThanK2(int[] a, int k) {

		int start = 0, end = a.length - 1, count = 0;

		while (start < end) {
			if (a[start] + a[end] <= k) {
				count += (end - start);
				// System.out.println(a[start] + "<>" + a[end]);
				start++;
			} else {
				end--;
			}
		}

		return count;

	}

	/*
	 * public int countPairsWithSumLessThanK(int[] a, int k) {
	 * 
	 * int count = 0;
	 * 
	 * for(int i = 0; i < a.length; i++) { for(int j = i+1; j < a.length; j++) {
	 * if(a[i] + a[j] < k) { count++; } } }
	 * 
	 * return count; }
	 */

	public static void main(String[] args) {
		CountPairsWithSumGTK driver = new CountPairsWithSumGTK();
		int[] a = { 1, 2, 3, 4 };
		int res = driver.countPairsWithSumGTK(a, 5);

		System.out.println("RES : " + res);
	}
}