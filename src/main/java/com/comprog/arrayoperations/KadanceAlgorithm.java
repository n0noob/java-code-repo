package com.comprog.arrayoperations;

public class KadanceAlgorithm {

	public int getMaxSumFromSubArray(int[] a) {
		int i = 1;
		int sum = a[0];
		int max_so_far = a[0];

		while (i < a.length) {
			sum = Math.max(a[i], a[i] + sum);
			max_so_far = Math.max(sum, max_so_far);
			i++;
		}
		return max_so_far;
	}
	
	public void printMaxSumSubArray(int[] a) {
		int i = 1;
		int sum = a[0];
		int max_so_far = a[0];
		int len = 0;
		int start = 0;
		int START = 0;
		
		while (i < a.length) {
			if(a[i] > a[i] + sum) {
				sum = a[i];
				start = i;
			}
			else {
				sum = a[i] + sum;
			}
			if(max_so_far < sum) {
				max_so_far = sum;
				START = start;
			}
			i++;
		}
		
		sum = 0;
		i = START;
		while(sum != max_so_far) {
			System.out.print(a[i] + " ");
			sum += a[i++];
		}
	}
	
	public static void main(String[] args) {
		int[] a = { -2, -1, -3, 10, 3, -2, 41, -10 };
		KadanceAlgorithm driver = new KadanceAlgorithm();

		int res = driver.getMaxSumFromSubArray(a);

		System.out.println(res);
	}

}