package com.comprog.arrayoperations;

public class CalculateLandPerimeter {

	public int countLandArea(int[][] a) {

		int count = 0;

		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[0].length; j++) {

				// If the given point is a land
				if (a[i][j] == 1) {
					count += waterAround(a, i, j);
				}
			}
		}

		return count;
	}

	private int waterAround(int[][] a, int i, int j) {
		int maxRowNum = a.length - 1;
		int maxColNum = a[0].length - 1;

		int waterCount = 0;

		if (i - 1 < 0 || a[i - 1][j] == 0)
			waterCount++;
		if (i + 1 > maxRowNum || a[i + 1][j] == 0)
			waterCount++;

		if (j - 1 < 0 || a[i][j - 1] == 0)
			waterCount++;
		if (j + 1 > maxColNum || a[i][j + 1] == 0)
			waterCount++;

		return waterCount;
	}

	public static void main(String[] args) {
		int[][] a = { { 1, 0, 1, 1 }, { 1, 1, 1, 1 } };
		CalculateLandPerimeter solution = new CalculateLandPerimeter();
		int res = solution.countLandArea(a);

		// int res = solution.waterAround(a, 0, 0);

		System.out.println("Perimeter of land : " + res);

	}
}
