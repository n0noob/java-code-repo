package com.softvision.test_proj.arrayoperations;

public class PrintLargestThree {

	public void printLargestThreeElements(int[] a) {
		int first = Integer.MIN_VALUE;
		int second = Integer.MIN_VALUE;
		int third = Integer.MIN_VALUE;

		for (int i = 0; i < a.length; i++) {

			if (a[i] > first) {
				third = second;
				second = first;
				first = a[i];
			} else if (first > a[i] && a[i] > second) {
				third = second;
				second = a[i];
			} else if (second > a[i] && a[i] > third) {
				third = a[i];
			}
		}

		System.out.println("FIRST : " + first);
		System.out.println("SECOND : " + second);
		System.out.println("THIRD : " + third);

	}

	public static void main(String[] args) {
		PrintLargestThree driver = new PrintLargestThree();
		int[] a = { 9, 12, 2, 6, 76, 45, 1, 8 };

		driver.printLargestThreeElements(a);
	}

}