package com.softvision.test_proj.arrayoperations;

import java.io.*;
import java.util.*;

public class MeanAndMedian {

	public void printMeanAndMedian(int[] input) {
		Integer[] a = new Integer[input.length];
		int sum = 0;
		float mean = -1;
		float median = -1;

		for (int i = 0; i < a.length; i++) {
			a[i] = input[i];
			sum += input[i];
		}

		mean = (float) sum / a.length;
		System.out.println("MEAN : " + mean);

		Arrays.sort(a);

		if (a.length % 2 == 0) {
			int temp = (a.length - 1) / 2;
			median = (float) (a[temp] + a[temp + 1]) / (float) 2.0;
		} else {
			median = (float) a[a.length / 2];
		}
		System.out.println("MEDIAN : " + median);

	}

	public static void main(String[] args) {
		MeanAndMedian driver = new MeanAndMedian();
		int[] a = { 2, 1, 4, 3, 5, 6 };

		driver.printMeanAndMedian(a);

	}

}