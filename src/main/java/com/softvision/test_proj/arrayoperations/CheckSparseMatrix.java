package com.softvision.test_proj.arrayoperations;

import java.io.*;
import java.util.*;

public class CheckSparseMatrix {

	public boolean checkSparseMatrix(int mat[][]) {
		// Check if mat is proper
		if (mat == null || mat.length < 1 || mat[0].length < 1)
			return false;

		// Normal matrix
		int numOfElements = mat.length * mat[0].length;
		int numOfZeroes = 0;

		for (int i = 0; i < mat.length; i++) {
			for (int j = 0; j < mat[i].length; j++) {
				if (mat[i][j] == 0)
					numOfZeroes++;
			}
		}

		if (numOfZeroes > numOfElements / 2)
			return true;

		return false;
	}

	public static void main(String[] args) {
		CheckSparseMatrix driver = new CheckSparseMatrix();
		int[][] a = { { 0, 1, 0, 2 }, { 0, 0, 1, 0 } };

		boolean res = driver.checkSparseMatrix(a);

		System.out.println("Result : " + res);
	}
}