package com.softvision.test_proj.stringoperations;

import java.io.*;
import java.util.*;

public class FirstNonRepeatingChar {

	public Character getNonRepeatingChar(String str) {
		// If empty string
		if (str == null || str.equals(""))
			return null;

		// If contains one char
		if (str.length() == 1)
			return str.charAt(0);

		// Normal case
		Map<Character, Integer> map = new HashMap<>();
		int counter = 1;
		for (int i = 0; i < str.length(); i++) {
			if (!map.containsKey(str.charAt(i))) {
				map.put(str.charAt(i), i + 1);
			} else {
				map.put(str.charAt(i), -1);
			}
		}

		int min_value = Integer.MAX_VALUE;
		for (Map.Entry<Character, Integer> e : map.entrySet()) {
			if (e.getValue() > 0 && min_value > e.getValue()) {
				min_value = e.getValue();
			}
		}

		if (Integer.MAX_VALUE == min_value)
			return null;

		return str.charAt(min_value - 1);

	}

	public static void main(String[] args) {
		FirstNonRepeatingChar driver = new FirstNonRepeatingChar();
		String str = "aacaaba";

		Character res = driver.getNonRepeatingChar(str);
		if (res != null)
			System.out.println("RES : " + res);
		else
			System.out.println("Empty result");

	}
}
