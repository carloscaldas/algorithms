import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		int queries = Integer.parseInt(in.nextLine());
		for (int i = 0; i < queries; i++) {
			int K = Integer.parseInt(in.nextLine());
			String line = in.nextLine();
			FastBigInt A = new FastBigInt(line, 16);
			FastBigInt B = new FastBigInt(in.nextLine(), 16);
			FastBigInt C = new FastBigInt(in.nextLine(), 16);
			findAndPrintValues(K, A, B, C);
		}
		in.close();
	}

	static void findAndPrintValues(int k, FastBigInt a, FastBigInt b, FastBigInt c) {
		int changes = 0;

		// remove all not compatible 1s from A
		long aCount = a.numberOfSetBits();
		a.and(c);
		changes += aCount - a.numberOfSetBits();
		if (changes > k) {
			System.out.println(-1);
			return;
		}

		// remove all not compatible 1s from B
		long bCount = b.numberOfSetBits();
		b.and(c);
		changes += bCount - b.numberOfSetBits();
		if (changes > k) {
			System.out.println(-1);
			return;
		}

		FastBigInt missingOne = b.clone();
		missingOne.xor(a).xor(c);

		long b2Count = b.numberOfSetBits();
		b.or(missingOne);
		changes += b.numberOfSetBits() - b2Count;

		if (changes > k) {
			System.out.println(-1);
		} else {
			int changesAvailable = k - changes;
			changes += swapWhenPossible(a, b, changesAvailable);
			String tmpStr1 = a.toString(16);
			String tmpStr2 = b.toString(16);
			System.out.println(tmpStr1.toUpperCase());
			System.out.println(tmpStr2.toUpperCase());
		}

	}

	private static int swapWhenPossible(FastBigInt a, FastBigInt b, int maxChanges) {
		int result = 0;
		int changesAvailable = maxChanges;
		for (int block = a.getNumberOfBlocks() - 1; block > -1 && changesAvailable > 0; block--) {
			int changesDone = swapBitByBit(a, b, block, changesAvailable);
			changesAvailable -= changesDone;
			result += changesDone;
		}
		return result;
	}

	private static int swapBitByBit(FastBigInt a, FastBigInt b, int block, int changesAvailable) {
		int changes = 0;
		for (long position = a.bitLength(block) - 1; (position > -1) && (changesAvailable > 0); position--) {
			if (a.testBit(block, position) && !b.testBit(block, position) && (changesAvailable > 1)) {
				a.clearBit(block, position);
				b.setBit(block, position);
				changes += 2;
				changesAvailable -= 2;
			} else if (a.testBit(block, position) && b.testBit(block, position)) {
				a.clearBit(block, position);
				changesAvailable--;
				changes++;
			}
		}
		return changes;
	}
}
