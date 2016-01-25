package com.carloscaldas.algorithms.hackerrank.warmup;

import java.util.Scanner;

//https://www.hackerrank.com/challenges/plus-minus
public class PlusMinus {
    public static void main(String[] args) {
        int less = 0;
        int more = 0;
        int same = 0;
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        for(int arr_i=0; arr_i < n; arr_i++){
            int tmp = in.nextInt();
            if (tmp == 0) {
                same++;
            }
            else if (tmp >0) {
                more++;     
            }
            else {
                less++;
            }
        }
        in.close();
        System.out.printf("%.6f\n", (double)more/(double)n);
        System.out.printf("%.6f\n", (double)less/(double)n);
        System.out.printf("%.6f\n", (double)same/(double)n);
    }
}
