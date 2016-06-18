package com.carloscaldas.algorithms.hackerrank.strings;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

import org.junit.Assert;
import org.junit.Test;

//Perfect
//https://www.hackerrank.com/challenges/two-strings
public class TwoStrings {

	public static String hasIntersection(String str1, String str2) {
		String result = "NO";
		Set<Character> all = new HashSet<Character>();
		for (Character c : str1.toCharArray()) {
			all.add(c);
		}
		for (Character c : str2.toCharArray()) {
			if (all.contains(c)) {
				result = "YES";
				break;
			}
		}
		return result;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int T = Integer.valueOf(in.nextLine());
		for (int i = 0; i < T; i++) {
			System.out.println(hasIntersection(in.nextLine(), in.nextLine()));
		}
		in.close();;
	}

}
