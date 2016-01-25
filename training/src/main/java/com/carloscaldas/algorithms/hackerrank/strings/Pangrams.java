package com.carloscaldas.algorithms.hackerrank.strings;

import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

//OK
//https://www.hackerrank.com/challenges/pangrams
public class Pangrams {

	private static boolean isPangram(String phrase) {
		final int ALPHABET_SYMBOLS = 26;

		Set<Character> allSymbols = new HashSet<Character>();
		Pattern pattern = Pattern.compile("[a-z]", Pattern.CASE_INSENSITIVE);
		Matcher matcher = pattern.matcher(phrase);
		
		while (matcher.find() && allSymbols.size()<ALPHABET_SYMBOLS) {
			allSymbols.add(matcher.group().toLowerCase().charAt(0));
		}
		
		System.out.println(allSymbols.size());
		return (allSymbols.size() == ALPHABET_SYMBOLS);
	}
	
	public static void main(String[] args) {
		final String txt = "This is my small A B C D E F G H I J K L M N O P Q R S T U V W X Y Zexample string which I'm going ball cause dead lol mart w v p zebra to use for pattern matching.";
		System.out.println(isPangram(txt));
		//System.out.println();
	}
	
}
