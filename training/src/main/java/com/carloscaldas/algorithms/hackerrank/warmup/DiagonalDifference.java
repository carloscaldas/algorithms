package com.carloscaldas.algorithms.hackerrank.warmup;

import java.util.Scanner;

//https://www.hackerrank.com/challenges/diagonal-difference
public class DiagonalDifference {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int acc1 = 0;
        int acc2 = 0;
        for(int a_i=0; a_i < n; a_i++){
            for(int a_j=0; a_j < n; a_j++){
                int tmp = in.nextInt();
                if (a_i==a_j) {
                    acc1 += tmp;
                }
                if (a_i+a_j == n-1) {
                    acc2 += tmp;
                }
            }
        }
        in.close();

        System.out.println(Math.abs(acc1 - acc2));
    }
}
