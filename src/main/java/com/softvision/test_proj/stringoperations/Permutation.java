package com.softvision.test_proj.stringoperations;

public class Permutation {

	public void permute(String test, String remaining) {
		System.out.println(test);
		//Base condition
		if (remaining.equals(""))
			return;
			//System.out.println(test);
		//Normal case
		else {
			for (int i = 0; i < remaining.length(); i++)
				permute(test + remaining.charAt(i), remaining.substring(0, i) + remaining.substring(i + 1, remaining.length()));
		}
	}

	public static void main(String[] args) {
		Permutation driver = new Permutation();

		driver.permute("", "abcd");
		// driver.permutations("abcd", 0);
	}
}