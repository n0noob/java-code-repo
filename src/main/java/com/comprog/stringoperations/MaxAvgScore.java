package com.comprog.stringoperations;

import java.util.*;

public class MaxAvgScore {

	public void printMaxScoreStudent(String[] input) {

		// Case when even one student information is not complete
		if (input == null || (input[0].charAt(0) < 'A' && input[0].charAt(0) > 'z') || input.length <= 4) {
			System.out.println("Error in input");
			return;
		}

		int max_score = Integer.MIN_VALUE;
		List<String> toppers = new ArrayList<String>();
		int temp_sum = 0;
		int n = 0;
		boolean isName = false;
		String lastName = "DUMMY";

		for (int i = 0; i < input.length; i++) {
			String s = input[i];

			// Case when string is name
			if (isName(s)) {
				if (i != 0) {
					int score = temp_sum / n;
					if (score > max_score) {
						max_score = score;
						toppers.clear();
						toppers.add(lastName);
					} else if (score == max_score) {
						toppers.add(lastName);
					}
				}

				lastName = s;
				n = 0;
				temp_sum = 0;
			} else {
				temp_sum += Integer.parseInt(s);
				n++;
				// If end is encountered
				if (i == input.length - 1) {
					int score = temp_sum / n;
					if (score > max_score) {
						max_score = score;
						toppers.clear();
						toppers.add(lastName);
					} else if (score == max_score) {
						toppers.add(lastName);
					}
				}
			}

		}

		for (String s : toppers) {
			System.out.print(s + " ");
		}
		System.out.println(max_score);
	}

	private boolean isName(String s) {
		if ((s.charAt(0) >= 'A' && s.charAt(0) <= 'Z') || (s.charAt(0) >= 'A' && s.charAt(0) <= 'Z'))
			return true;

		else
			return false;
	}

	public static void main(String[] args) {
		String[] input = { "Ramesh", "90", "70", "40", "Adam", "50", "10", "40", "Suresh", "22", "1", "56", "Rocky",
				"100", "90", "10" };

		MaxAvgScore driver = new MaxAvgScore();

		driver.printMaxScoreStudent(input);
	}
}
