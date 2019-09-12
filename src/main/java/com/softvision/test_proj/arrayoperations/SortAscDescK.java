package com.softvision.test_proj.arrayoperations;

import java.io.*;
import java.util.*;

public class SortAscDescK {
	public void sortAscDesc(int[] a, int k) {

		Arrays.sort(a, 0, k);
		Arrays.sort(a, k, a.length - 1);
		System.out.println(Arrays.toString(a));
		reverse(a, k, a.length - 1);

	}
	
	private void reverse(int[] a, int start, int end) {
		if(start == end || start + 1 == end) {
			return;
		}
		
		int mid = (start + end)/2;
		
		for(int i = start; i <= mid; i++) {
			int tempIndex = i - start;
			int endAbsIndex = end - tempIndex;
			int temp = a[i];
			a[i] = a[endAbsIndex];
			a[endAbsIndex] = temp;
		}
	} 

	public static void main(String[] args) {
		SortAscDescK driver = new SortAscDescK();
		int a[] = { 5, 4, 6, 2, 1, 3, 8, 9, -1 };

		System.out.println(Arrays.toString(a));
		
		driver.sortAscDesc(a, 4);

		System.out.println(Arrays.toString(a));
	}

}
