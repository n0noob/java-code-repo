package com.softvision.test_proj.arrayoperations;

import java.io.*;
import java.util.*;

public class SecondMin {

	public void findSecondSmallest(int[] a) {
		// If array is empty
		if (a == null || a.length < 2) {
			System.out.println("Invalid data");
		}

		int min = a[0];
		int smin = Integer.MAX_VALUE;

		for (int i = 1; i < a.length; i++) {
			if (a[i] < min) {
				smin = min;
				min = a[i];
			} else if (a[i] > min && a[i] < smin) {
				smin = a[i];
			}

		}

		if (smin == Integer.MAX_VALUE)
			System.out.println("No second minimum found");
		else
			System.out.println("Second min : " + smin);
	}

	public static void main(String[] args) {
		SecondMin driver = new SecondMin();
		int[] a = { 2, 3, 6, 78, 1, 10 };
		driver.findSecondSmallest(a);
	}
}
