package com.comprog.arrayoperations;

public class BinarySearch {

	public int binarySearch(int[] a, int x) {
		return BS(a, 0, a.length, x);
	}

	private int BS(int[] a, int start, int end, int x) {

		if (start < end) {
			int mid = (start + end) / 2;

			if (a[mid] == x)
				return mid;
			else if (a[mid] < x) {
				start = mid + 1;
			} else {
				end = mid;
			}
			return BS(a, start, end, x);
		}
		return -1;
	}

	public static void main(String[] args) {
		BinarySearch driver = new BinarySearch();
		int[] a = { 1, 2, 3, 4, 5, 6, 7 };
		int res = driver.binarySearch(a, 5);
		System.out.println("res : " + res);
	}
}
