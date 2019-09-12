package com.softvision.test_proj.stringoperations;

import java.io.*;
import java.util.*;

public class EncodeString {

	public String encode(String s) {

		// Empty string
		if (s == null || s.isEmpty()) {
			return "";
		}

		StringBuilder sb = new StringBuilder();
		int count = 1;

		for (int i = 1; i < s.length(); i++) {
			if (s.charAt(i) == s.charAt(i - 1))
				count++;
			if (s.charAt(i) != s.charAt(i - 1) || i == (s.length() - 1)) {
				sb.append(s.charAt(i - 1) + "" + count);
				count = 1;
			}
		}

		return sb.toString();

	}

	public static void main(String[] args) {
		EncodeString driver = new EncodeString();

		System.out.println(driver.encode("HHHHELLOO"));
	}
}
