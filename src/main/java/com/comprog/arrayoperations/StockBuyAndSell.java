package com.comprog.arrayoperations;

public class StockBuyAndSell {

	public void printMaxProfitStrategy(int[] prices) {
		int start = 0;
		int end = 1;
		int[] a = prices;

		while (start < a.length) {
			// Expand window
			while (end < a.length && a[end] <= a[end - 1]) {
				end++;
			}

			if (end == a.length)
				break;

			start = end - 1;
			if (end != a.length) {
				while (end < a.length && a[end] >= a[end - 1]) {
					end++;
				}
				System.out.println("Buy at : " + a[start] + " Sell at : " + a[end - 1]);
			}
		}

	}

	public static void main(String[] args) {
		StockBuyAndSell driver = new StockBuyAndSell();
		int[] a = { 100, 180, 260, 310, 40, 535, 695 };

		driver.printMaxProfitStrategy(a);

	}
}
