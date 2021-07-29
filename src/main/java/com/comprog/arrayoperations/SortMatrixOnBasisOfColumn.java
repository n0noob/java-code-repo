package com.comprog.arrayoperations;

import java.util.*;

public class SortMatrixOnBasisOfColumn {

	public void sort2DArray(int[][] a, int col) {
		Arrays.sort(a, (x, y) -> {
			return x[col] - y[col];
		});
	}

	public static void main(String[] args) {
		SortMatrixOnBasisOfColumn driver = new SortMatrixOnBasisOfColumn();
		int[][] a = { { 2, 3, 4 }, { 12, 45, 78 }, { 1, 2, 3 } };

		driver.sort2DArray(a, 2);

		for (int i = 0; i < a.length; i++) {
			System.out.println(Arrays.toString(a[i]));
		}
	}

}