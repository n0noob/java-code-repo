package com.comprog.arrayoperations;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class Sort {

	public void bubbleSort(int[] a) {
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a.length - i - 1; j++) {
				if (a[j] > a[j + 1]) {
					swap(a, j, j + 1);
				}
			}
			System.out.println(Arrays.toString(a));
		}

	}

	public void selectionSort(int[] a) {
		int max = 0;

		for (int i = 0; i < a.length; i++) {
			max = 0;
			for (int j = 0; j < a.length - i; j++) {
				if (a[j] > a[max])
					max = j;
			}
			System.out.println("MAX : " + a[max]);
			swap(a, max, a.length - i - 1);
			System.out.println(Arrays.toString(a));
		}
	}

	public void insertionSort(int[] a) {

		for (int i = 0; i < a.length; i++) {

			int j = i - 1;

			// Iterate from i-1 to 0
			while (j >= 0 && a[j] > a[j + 1]) {
				swap(a, j, j + 1);
				j--;
			}
			System.out.println(Arrays.toString(a));
			System.out.println("Sorted array extent : " + i);
		}

	}

	public void quickSort(int[] a, int start, int end) {
		// If array has only one element
		// if(start == end || start < 0 || end < 0 || start >= a.length || start >=
		// a.length)
		// return;
		if (start < end) {
			System.out.println(start + "<>" + end);
			System.out.println(Arrays.toString(a));
			int p = partition(a, start, end);

			if (p != -1) {
				System.out.println("Pivot : " + p);
				quickSort(a, start, p - 1);
				quickSort(a, p + 1, end);
			}
		}
	}

	public void heapSort(int[] a) {
		Queue<Integer> q = new PriorityQueue<>();
		for (int i = 0; i < a.length; i++) {
			q.add(a[i]);
		}

		int i = 0;
		while (q.size() != 0) {
			a[i++] = q.poll();
		}

	}

	public void countSort(int[] a) {
		int max = Arrays.stream(a).max().getAsInt();
		int[] op = new int[a.length];

		System.out.println(Arrays.toString(a));

		int[] freq = new int[max + 1];
		// Populate the frequency map
		for (int i = 0; i < a.length; i++) {
			freq[a[i]]++;
		}

		// Make changes in map
		for (int i = 1; i < freq.length; i++) {
			freq[i] = freq[i] + freq[i - 1];
		}

		for (int i = a.length - 1; i >= 0; i--) {
			op[freq[a[i]] - 1] = a[i];
			freq[a[i]]--;
		}

		for (int i = 0; i < a.length; i++) {
			a[i] = op[i];
		}
	}

	// Utility function used by quickSort method
	// NOTE : start and end are inclusive bounds
	private int partition(int[] a, int start, int end) {
		if (start == end || start < 0 || end < 0 || start >= a.length || start >= a.length)
			return -1;

		if (start == end - 1) {
			if (a[start] > a[end])
				swap(a, start, end);
			return -1;
		}

		int pivot = end;
		end--;
		while (start < end) {
			while (start < a.length && a[start] < a[pivot])
				start++;
			while (end >= 0 && a[end] >= a[pivot])
				end--;

			// System.out.println(a[start] + "<>" + a[end]);
			if (start < end) {
				swap(a, start, end);
			}
		}
		swap(a, start, pivot);
		return start;
	}

	private void swap(int[] a, int i, int j) {
		if (i == j || a[i] == a[j])
			return;
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}

	public static void main(String[] args) {
		Sort driver = new Sort();
		int[] a = { 6, 1, 2, 13, 0 };
		driver.countSort(a);
		System.out.println(Arrays.toString(a));
	}
}
