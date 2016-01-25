package com.carloscaldas.algorithms.hackerrank.strings;

import java.util.HashMap;
import java.util.Map;

//Perfect
//https://www.hackerrank.com/challenges/make-it-anagram
public class MakeItAnagram {

	private static int minimumChanges(String str1, String str2) {
		return minimumDelete(str1, str2) / 2;
	}

	private static int minimumChanges(String str) {
		int result = -1;
		if (str.length() % 2 == 0) {
			String str1 = str.substring(0, str.length() / 2);
			String str2 = str.substring(str.length() / 2);
			result = minimumChanges(str1, str2);
		}
		return result;
	}

	// minimum do delete
	private static int minimumDelete(String str1, String str2) {
		Map<Character, Integer> mySet = new HashMap<Character, Integer>();

		for (int i = 0; i < str1.length(); i++) {
			Character key = str1.charAt(i);
			Integer v = mySet.get(key);
			if (v == null) {
				v = 1;
			} else {
				v = v + 1;
			}
			mySet.put(key, v);
		}

		for (int i = 0; i < str2.length(); i++) {
			Character key = str2.charAt(i);
			Integer v = mySet.get(key);
			if (v == null) {
				v = -1;
			} else {
				v = v - 1;
			}
			mySet.put(key, v);
		}

		int result = 0;
		for (Integer v : mySet.values()) {
			result += Math.abs(v);
		}

		return result;
	}

	public static void main(String[] args) {
		System.out.println(minimumChanges("aaabbb"));
		System.out.println(minimumChanges("a"));
		System.out.println(minimumChanges("abc"));
		System.out.println(minimumChanges("bc"));
		System.out.println(minimumChanges("abcd"));
		System.out.println(minimumChanges("abcde"));
		System.out.println(minimumChanges("abda"));
		/*
		 * System.out.println("------------");
		 * System.out.println(mininumChange("aaa", "bbb"));
		 * System.out.println(mininumChange("a", "b"));
		 * System.out.println(mininumChange("ab", "c"));
		 * System.out.println(mininumChange("mn", "op"));
		 * System.out.println(mininumChange("xy", "yx"));
		 * System.out.println(mininumChange("xaxb", "bbxx"));
		 * System.out.println("------------");
		 * 
		 */
	};

}