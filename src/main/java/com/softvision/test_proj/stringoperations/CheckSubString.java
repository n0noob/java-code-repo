package com.softvision.test_proj.stringoperations;

import java.io.*;
import java.util.*;

public class CheckSubString {

	public boolean checkSubstring(String s1, String s2) {
		int subItr = 0;

		for (int i = 0; i < s2.length(); i++) {
			if (s2.charAt(i) == s1.charAt(subItr)) {
				subItr++;
			}

			if (subItr == s1.length())
				return true;
		}

		return false;
	}

	public static void main(String[] args) {
		String s1 = "ab";
		String s2 = "bacd";
		CheckSubString driver = new CheckSubString();

		boolean res = driver.checkSubstring(s1, s2);

		System.out.println("RES : " + res);
	}
}