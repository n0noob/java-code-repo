package com.comprog.bitoperations;

public class BinToDec {

	public int binToDec(int n) {
		int res = 0;
		int i = 0;
		while (n != 0) {
			int lsb = n % 10;
			res = res + (lsb * (int) Math.pow(2, i++));
			n = n / 10;
		}

		return res;
	}

	public static void main(String[] args) {
		BinToDec driver = new BinToDec();

		int res = driver.binToDec(1001);
		System.out.println(res);
	}
}
