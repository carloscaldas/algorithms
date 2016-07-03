import java.math.BigInteger;
import java.util.Scanner;

public class SolutionWithBigInteger {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		int queries = in.nextInt();
		for (int i = 0; i < queries; i++) {
			int K = in.nextInt();
			BigInteger A = in.nextBigInteger(16);
			BigInteger B = in.nextBigInteger(16);
			BigInteger C = in.nextBigInteger(16);

			findAndPrintValues(K, A, B, C);
		}
		in.close();
	}

	public static void findAndPrintValues(int K, BigInteger A0, BigInteger B0, BigInteger C) {
		int changes = 0;

		// remove all not compatible 1s from A
		BigInteger A = A0.and(C);
		changes += A0.bitCount() - A.bitCount();
		if (changes > K) {
			System.out.println(-1);
			return;
		}

		// remove all not compatible 1s from B
		BigInteger B = B0.and(C);
		int b2Count = B.bitCount();
		changes += B0.bitCount() - b2Count;
		if (changes > K) {
			System.out.println(-1);
			return;
		}

		// add missing 1s to B
		BigInteger missingOne = A.xor(B).xor(C);
		B = B.or(missingOne);
		changes += B.bitCount() - b2Count;

		if (changes > K) {
			System.out.println(-1);
		} else {
			int changesAvailable = K - changes;
			for (int i = A.bitLength() - 1; i > -1 && changesAvailable > 0; i--) {
				if (A.testBit(i) && !B.testBit(i) && (changesAvailable > 1)) {
					A = A.clearBit(i);
					B = B.setBit(i);
					changes += 2;
					changesAvailable -= 2;
				} else if (A.testBit(i) && B.testBit(i)) {
					A = A.clearBit(i);
					changesAvailable--;
				}
			}

			System.out.println(A.toString(16).toUpperCase());
			System.out.println(B.toString(16).toUpperCase());
		}
	}

	public static void findAndPrintValues2(int K, BigInteger A0, BigInteger B0, BigInteger C) {
		int changes = 0;
		int maxLength = Math.max(Math.max(A0.bitLength(), B0.bitLength()), C.bitLength());
		int[] swap = new int[maxLength];
		int later = 0;

		BigInteger A = new BigInteger(A0.toByteArray());
		BigInteger B = new BigInteger(B0.toByteArray());
		for (int i = maxLength - 1; i > -1; i--) {
			if (!C.testBit(i)) {
				if (A.testBit(i)) {
					A = A.clearBit(i);
					changes++;
				}
				if (B.testBit(i)) {
					B = B.clearBit(i);
					changes++;
				}
			} else {
				if (!A.testBit(i) && !B.testBit(i)) {
					B = B.setBit(i);
					changes++;
				} else if (A.testBit(i)) {
					swap[later++] = i;
				}
			}
			if (changes > K) {
				System.out.println(-1);
				return;
			}
		}
		if (changes > K) {
			System.out.println(-1);
			return;
		} else {
			for (int i = 0; i < later && changes < K; i++) {
				// duas hipoteses: 1-a possui e b nao; 2-ambos possuem
				if (!B.testBit(swap[i]) && (changes <= K - 2)) {
					A = A.clearBit(swap[i]);
					B = B.setBit(swap[i]);
					changes += 2;
				} else if (B.testBit(swap[i])) {
					A = A.clearBit(swap[i]);
					changes++;
				}
			}
			System.out.println(A.toString(16).toUpperCase());
			System.out.println(B.toString(16).toUpperCase());
		}
	}

	// public static void findAndPrintValues3(int k, BigInt a, BigInt b, BigInt
	// c) {
	// int changes = 0;
	// int maxLength = Math.max(Math.max(A0.bitLength(), B0.bitLength()),
	// C.bitLength());
	// int[] swap = new int[maxLength];
	// int later = 0;
	//
	// for (int i = maxLength - 1; i > -1; i--) {
	// if (!C.testBit(i)) {
	// if (A.testBit(i)) {
	// A = A.clearBit(i);
	// changes++;
	// }
	// if (B.testBit(i)) {
	// B = B.clearBit(i);
	// changes++;
	// }
	// } else {
	// if (!A.testBit(i) && !B.testBit(i)) {
	// B = B.setBit(i);
	// changes++;
	// } else if (A.testBit(i)) {
	// swap[later++] = i;
	// }
	// }
	// if (changes > K) {
	// System.out.println(-1);
	// return;
	// }
	// }
	// if (changes > K) {
	// System.out.println(-1);
	// return;
	// } else {
	// for (int i = 0; i < later && changes < K; i++) {
	// //duas hipoteses: 1-a possui e b nao; 2-ambos possuem
	// if (!B.testBit(swap[i]) && (changes <= K-2)) {
	// A = A.clearBit(swap[i]);
	// B = B.setBit(swap[i]);
	// changes += 2;
	// }
	// else if (B.testBit(swap[i])) {
	// A = A.clearBit(swap[i]);
	// changes++;
	// }
	// }
	// System.out.println(A.toString(16).toUpperCase());
	// System.out.println(B.toString(16).toUpperCase());
	// }
	// }

}
