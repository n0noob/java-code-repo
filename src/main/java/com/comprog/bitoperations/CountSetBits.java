package com.comprog.bitoperations;

public class CountSetBits {

	final int[] CONST = { 0, 1, 1, 2, 1, 2, 2, 3, 1, 2, 2, 3, 2, 3, 3, 4 };

	public int countSetBits2(int n) {
		int count = 0;

		while (n != 0) {
			int nibble = n & 0xF;
			count += CONST[nibble];
			n = n >> 4;
		}

		return count;
	}

	// Count set bits in an integer
	public int countSetBits(int a) {
		int count = 0;
		while (a != 0) {
			if ((a & 1) == 1)
				count++;
			a = a >> 1;
		}
		return count;
	}

	/*
	 * public void printCountBits(int n) { for(int i = 0; i <= n; i++) {
	 * System.out.print(countSetBits(i) + ", "); } System.out.println(); }
	 */

	public static void main(String[] args) {
		CountSetBits driver = new CountSetBits();

		int res = driver.countSetBits2(17);
		System.out.println(res);
	}
}
