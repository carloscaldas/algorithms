package com.carloscaldas.algorithms.hackerrank.strings;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

//TODO: still not working
//https://www.hackerrank.com/challenges/sherlock-and-anagrams
public class SherlockAndAnagrams {

	static class Anagram {
		private String orderedValue;
		public String getValue() {
			return this.orderedValue;
		}
		
		public Anagram(String txt) {
			char[] arr = txt.toCharArray();
			Arrays.sort(arr);
			this.orderedValue = new String(arr);
		}

		@Override
		public int hashCode() {
			return this.orderedValue.hashCode();
		}

		@Override
		public boolean equals(Object other) {
			if (other == null)
				return false;
			if (other instanceof Anagram == false)
				return false;
			return ((Anagram)other).getValue().equals(this.orderedValue);
		}
	}
	
	private static int unorderedPairs(String str) {
		int result = 0;
		Set<Anagram> anagrams = new HashSet<Anagram>();
//		Map<Integer, Anagram> all = new HashMap<Integer, Anagram>();
		
		for (int span = 1; span <= str.length(); span++) {
			for (int left = 0; left <= str.length() - span; left++) {
				int right = left + span - 1;
				String sub = str.substring(left, right+1);
				Anagram an = new Anagram(sub);
				if (!anagrams.add(an)) {
					result++;
				}
			}
		}
		
		return result;
	}
	
	//------------------------------------------
	static int calculate(String s) {
		int count=0;
        for(int i=0;i < s.length();i++){
            for(int k=i+1;k < s.length();k++){
            	System.out.printf("i=%d\tk=%d\t%s\t%s\t%n", i, k, s.substring(i,k), s.substring(i+1));
                int num=anagram(s.substring(i,k),s.substring(i+1),s.substring(i,k).length());
                count=count+num;
            }
        }
        return count;
	}
	
	static int anagram(String s1,String s2,int len){
	    int count = 0;

	    char[] c1=s1.toCharArray();
	    Arrays.sort(c1);
	    String ss1=new String(c1);
	    int length=s2.length();

	    for(int i=0;i<length;i++){
	        if(i+len<=length){
	        String sub=s2.substring(i,i+len);
	        char[] c2=sub.toCharArray();
	        Arrays.sort(c2);
	        String ss2=new String(c2);
	        if(ss1.compareTo(ss2)==0)
	            count++;
	        }
	    }
	return count;
	}
	
	public static void main(String[] args) {
		/*System.out.println(unorderedPairs("abba"));
		System.out.println(unorderedPairs("abcd"));
		System.out.println(unorderedPairs("a"));
		System.out.println(unorderedPairs("aa"));
		System.out.println(unorderedPairs("aba"));
		*/
//		System.out.println(unorderedPairs("ifailuhkqqhucpoltgtyovarjsnrbfpvmupwjjjfiwwhrlkpekxxnebfrwibylcvkfealgonjkzwlyfhhkefuvgndgdnbelgruel"));
		System.out.println(calculate("ifailuhkqqhucpoltgtyovarjsnrbfpvmupwjjjfiwwhrlkpekxxnebfrwibylcvkfealgonjkzwlyfhhkefuvgndgdnbelgruel"));
/*		
		System.out.println(unorderedPairs("ifailugtyovhdfuhdouarjsnrbfpvmupwjjjfiwneogwnoegnoegneognoewhrlkpekxxnebfrwibylcvkfealgonjkzw"));
		System.out.println(unorderedPairs("gffryqktmwocejbrexfidpjfgrrkpowoxwggxaknmltjcpazgtnakcfbveieivoenwvpnoevvneocogzatyskqjyorcftw"));
		System.out.println(unorderedPairs("uqlzvuzgkwhkkrrfpwarkckansgabfclzgnumdrojexnofeqjnqnxwidhbvbenevun9evnnv9euxxhfwargwkikjq"));
		System.out.println(unorderedPairs("sygjxynvofnvirarcoacwnhxyqlrviikfuiuotifznqmzpjrxycnqkeibvibvewioebvitkryutpqvbgbgthfges"));
		System.out.println(unorderedPairs("mkenscyiamnwlpxytkndjsygifmqlqibxxqlauxamfviftquntvkwppxrzuncyenavebiobeviobeiobeibvcfivtigv"));
		System.out.println(unorderedPairs("mkenscyiamnwlpxytkndjsygifmqlqibxxqlauxamfviftquntvkwppxrzuncyenavebiobeviobeiobeibvcfivtigvmkenscy"));
		System.out.println(unorderedPairs("mkenscyiamnwlpxytkndjsygifmqlqibxxqlauxamfviftquntvkwppxrzuncyenavebiobeviobeiobeibvcfivtigvmkenscy"));
		System.out.println(unorderedPairs("mkenscyiamnwlpxytkndjsygifmqlqibxxqlauxamfviftquntvkwppxrzuncyenavebiobeviobeiobeibvcfivtigv"));
		System.out.println(unorderedPairs("mkenscyiamnwlpxytkndjsygifmqlqibxxqlauxamfviftquntvkwppxrzuncyenavebiobeviobeiobeibvcfivtigvmkenscy"));
		System.out.println(unorderedPairs("mkenscyiamnwlpxytkndjsygifmqlqibxxqlauxamfviftquntvkwppxrzuncyenavebiobeviobeiobeibvcfivtigvmkenscy"));
		*/
	}
	
}
