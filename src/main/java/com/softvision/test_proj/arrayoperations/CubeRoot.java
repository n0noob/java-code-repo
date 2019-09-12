package com.softvision.test_proj.arrayoperations;

public class CubeRoot {
	public double calculateCubeRoot(int n) {
		double num = (double) n;

		System.out.println(num);

		double precision = 0.0000001;
		double min = 0;
		double max = num;
		double mid = (max + min) / 2;
		while (true != false) {

			mid = (max + min) / 2;
			double d = diff(num, mid);
			if (d <= precision) {
				return mid;
			} else if (d > precision) {
				if (num > (mid * mid * mid))
					min = mid;
				else
					max = mid;
			}

		}

	}

	private double diff(double n, double mid) {
		return Math.abs(n - (mid * mid * mid));
	}

	public static void main(String[] args) {
		CubeRoot driver = new CubeRoot();
		double res = driver.calculateCubeRoot(3);
		System.out.println("Result : " + res);
	}
}
