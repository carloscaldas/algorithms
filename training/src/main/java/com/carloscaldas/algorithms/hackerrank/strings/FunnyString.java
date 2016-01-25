package com.carloscaldas.algorithms.hackerrank.strings;

import java.io.FileNotFoundException;
import java.util.Scanner;


//Perfect
//https://www.hackerrank.com/challenges/funny-string
public class FunnyString {
	public static final String FUNNY = "Funny";
	public static final String NOT_FUNNY = "Not Funny";
	
	public static String isFunnyOrNotFunny(String value) {
		for (int i = 0; i < value.length() / 2; i++) {
			int left = Math.abs(value.charAt(i) - value.charAt(i + 1));
			int right = Math.abs(value.charAt(value.length() - i - 1) - value.charAt(value.length() - i - 2));
			if (left!=right) {
				return NOT_FUNNY;
			}
		}
		return FUNNY;
	}

	public static void main(String[] args) throws FileNotFoundException {
		Scanner in = new Scanner(System.in);
		int T = Integer.valueOf(in.nextLine());
		for (int i=1;i<=T;i++) {
			String S = in.nextLine();
			System.out.println(isFunnyOrNotFunny(S));
		}
		in.close();
	}

	

}
