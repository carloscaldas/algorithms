package com.carloscaldas.algorithms.hackerrank.warmup;

import java.util.Scanner;

//https://www.hackerrank.com/challenges/a-very-big-sum
public class AVeryBigSum {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        long acc = 0;
        for(int arr_i=0; arr_i < n; arr_i++){
            acc += in.nextLong();
        }
        in.close();
        
        System.out.println(acc);
    }

}
