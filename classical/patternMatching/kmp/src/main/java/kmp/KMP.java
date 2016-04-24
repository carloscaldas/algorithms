package kmp;

import java.util.Map;

public class KMP {
    private final int m;
    private final char[] P;
    private int[] pi;

    public KMP(String pattern) {
        m = pattern.length();
        P = pattern.toCharArray();
        pi = new int[m];
    }

    public void computePrefix() {
        pi[0] = -1;
        int k = -1;
        for (int q = 1; q <= m - 1; q++) {
            while(k >= 0 && P[k+1]!=P[q]) {
                k = pi[k];
            }
            
            if (P[k+1] == P[q]) {
                k++;
            }
            
            pi[q] = k;
        }
    }

    public static void main(String[] args) {
//         String pattern = "ababaca";
        String pattern = "acababa";

        KMP kmp = new KMP(pattern);
        kmp.computePrefix();
        kmp.printPrefix();

    }

    private void printPrefix() {
        for (char c : P) {
            System.out.print(c + "\t");
        }
        System.out.println();

        for (int v : pi) {
            System.out.print((v+1) + "\t");
        }
    }

}
