package com.softvision.test_proj.stringoperations;

import java.util.HashSet;
import java.util.Set;

public class PrintPalindromes {

	public void printPossiblePalindrome(String s) {

		Set<String> p = new HashSet<>();

		int prev1 = 0;
		int prev2 = -1;

		for (int i = 1; i < s.length(); i++) {
			// if palindrome is of even length
			if (s.charAt(i) == s.charAt(prev1)) {

				int fw = i;
				int bw = prev1;
				while (bw >= 0 && fw < s.length() && s.charAt(fw) == s.charAt(bw)) {
					p.add(s.substring(bw, fw + 1));
					fw++;
					bw--;
				}

			}
			// if palindrome is of odd length
			if (prev2 != -1 && s.charAt(i) == s.charAt(prev2)) {
				int fw = i;
				int bw = prev2;
				while (bw >= 0 && fw < s.length() && s.charAt(fw) == s.charAt(bw)) {
					p.add(s.substring(bw, fw + 1));
					fw++;
					bw--;
				}
			}
			prev1++;
			prev2++;
		}

		for (String str : p) {
			System.out.println(str);
		}

	}

	public static void main(String[] args) {
		PrintPalindromes driver = new PrintPalindromes();
		driver.printPossiblePalindrome("cabacdde");
	}
}