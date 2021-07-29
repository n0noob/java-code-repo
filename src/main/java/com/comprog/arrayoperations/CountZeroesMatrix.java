package com.comprog.arrayoperations;

public class CountZeroesMatrix {

	public int countZeroes2(int[][] a) {

		int count = 0;
		int j = a[0].length - 1;

		for (int i = 0; i < a.length; i++) {

			while (j >= 0 && a[i][j] == 1) {
				j--;
			}

			if (j >= 0) {
				count += (j + 1);
				continue;
			} else {
				break;
			}

		}

		return count;
	}

	public int countZeroes(int[][] a) {
		int count = 0;
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[0].length; j++) {
				if (a[i][j] == 0)
					count++;
				else
					break;
			}
		}

		return count;
	}

	public static void main(String[] args) {
	    int mat[][] = { { 0, 0, 0, 0, 1 }, 
                		{ 0, 0, 0, 1, 1 }, 
                		{ 0, 1, 1, 1, 1 }, 
                		{ 1, 1, 1, 1, 1 }, 
                		{ 1, 1, 1, 1, 1 } }; 
		CountZeroesMatrix driver = new CountZeroesMatrix();

		int res = driver.countZeroes2(mat);

		System.out.println(res);
	}

}