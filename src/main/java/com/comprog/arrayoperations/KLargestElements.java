package com.comprog.arrayoperations;

import java.util.PriorityQueue;
import java.util.Queue;

public class KLargestElements {
	public void findThreeLargest(int[] a) {
		int k = 3;

		// Invalid data
		if (a == null || a.length < 3) {
			System.out.println("Invalid data");
			return;
		}

		Queue<Integer> q = new PriorityQueue<>(k, (x, y) -> y - x);
		for (int i = 0; i < a.length; i++) {
			q.add(a[i]);
		}

		for (int i = 0; i < k; i++) {
			System.out.println(q.poll());
		}

	}

	public static void main(String[] args) {
		KLargestElements driver = new KLargestElements();
		int[] a = { 8, 7, 6, 5, 4, 3, 2, 1 };
		driver.findThreeLargest(a);
	}
}
