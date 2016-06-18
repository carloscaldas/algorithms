package com.carloscaldas.algorithms.hackerrank.warmup;

import java.util.Scanner;

//https://www.hackerrank.com/challenges/staircase
public class Staircase {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
		for (int i=1;i<=n;i++) {
			String x = new String(new char[i]).replace("\0", "#");
			System.out.printf("%"+ n + "s\n", x);			
		}
		in.close();
    }
}
