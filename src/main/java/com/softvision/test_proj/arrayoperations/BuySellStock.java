package com.softvision.test_proj.arrayoperations;

public class BuySellStock {

	class Pair<T> {
		T buy, sell;

		public Pair(T buy, T sell) {
			this.buy = buy;
			this.sell = sell;
		}
	}

	public void buySellStock(int[] a) {
		// Case when data is invalid
		if (a == null || a.length < 2) {
			System.out.println("Invalid data");
			return;
		}

		// Normal data
		int localMinima = -1;
		int localMaxima = -1;
		int i = 1;

		// Special case
		if (a[0] < a[1])
			localMinima = 0;

		while (i < a.length) {

			// Loop till minima is encountered
			while (i < a.length && a[i] <= a[i - 1]) {
				i++;
			}

			if (i < a.length)
				localMinima = i - 1;

			while (i < a.length && a[i] > a[i - 1]) {
				i++;
			}
			if (i < a.length - 1)
				localMaxima = i - 1;
			else if (a[a.length - 1] > a[a.length - 2])
				localMaxima = a.length - 1;

			System.out.println("Minima at : " + localMinima + " Maxima at : " + localMaxima);

		}

	}

	public static void main(String[] args) {

		BuySellStock driver = new BuySellStock();
		int[] a = { 100, 180, 260, 310, 40, 535, 695 };
		driver.buySellStock(a);

	}

}