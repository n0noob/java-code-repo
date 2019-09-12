package com.softvision.test_proj.stringoperations;

import java.io.*;
import java.util.*;

public class CheckAnagrams {

	public boolean checkAnagram(String s1, String s2) {
		Map<Character, Integer> map = new HashMap<>();

		for (int i = 0; i < s1.length(); i++) {
			char ch = s1.charAt(i);
			if (map.containsKey(ch)) {
				map.put(ch, map.get(map.get(ch)) + 1);
			} else {
				map.put(ch, 1);
			}
		}

		// Check now
		for (int i = 0; i < s2.length(); i++) {
			char ch = s2.charAt(i);

			// If character is not present in another string
			if (!map.containsKey(ch)) {
				return false;
			} else {
				if (map.get(ch) > 1) {
					map.put(ch, map.get(ch) - 1);
				} else {
					map.remove(ch);
				}
			}
		}

		if (map.entrySet().size() > 0)
			return false;

		return true;
	}

	public static void main(String[] args) {
		CheckAnagrams driver = new CheckAnagrams();

		boolean res = driver.checkAnagram("LISTEN", "SILENT");

		System.out.println(res);
	}
}