package com.carloscaldas.algorithms.hackerrank.strings;

//Perfect
//https://www.hackerrank.com/challenges/the-love-letter-mystery
public class TheLoveLetter {

	public static int getMinimumTransitions(String str) {
		int result = 0;
		if (str != null && str.length() > 0) {
			int left = 0;
			int right = str.length() - 1;
			do {
				if (str.charAt(left) != str.charAt(right)) {
					int distance = Math.abs(str.charAt(left) - str.charAt(right));
					result += distance;
				}
				left++;
				right--;
			} while (left < right);
		}
		return result;
	}

	public static void main(String[] args) {
		System.out.println(getMinimumTransitions("abadaab"));

	}



}
