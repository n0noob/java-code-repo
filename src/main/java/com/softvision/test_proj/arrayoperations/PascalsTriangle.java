package com.softvision.test_proj.arrayoperations;

public class PascalsTriangle {

	public void printPascalsTriangle1(final int n) {

		// Case when n is 0 or less
		if (n < 1)
			return;

		// Case when n is 1
		if (n == 1) {
			System.out.println(1);
			return;
		}

		// Case when n is 2
		if (n == 2) {
			System.out.println("1");
			System.out.println("1 1");
			return;
		}

		// For number of rows to print
		int[] temp1 = { 1, 1 };
		int[] temp2;

		System.out.println("1");
		System.out.println("1 1");
		for (int i = 2; i < n; i++) {

			temp2 = new int[temp1.length + 1];
			// To print each row
			temp2[0] = 1;

			for (int j = 1; j < temp1.length; j++) {
				temp2[j] = temp1[j - 1] + temp1[j];
			}

			temp2[temp2.length - 1] = 1;

			// Print temp2
			for (int j = 0; j < temp2.length; j++) {
				System.out.print(temp2[j] + " ");
			}
			System.out.println();

			temp1 = temp2;

		}

	}

	public static void main(String[] args) {
		PascalsTriangle driver = new PascalsTriangle();

		driver.printPascalsTriangle1(6);
	}
}