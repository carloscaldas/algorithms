import java.math.BigInteger;

import org.junit.Test;

public class AorBOldTest {

	@Test
	public void test01a() {
		int K = 25;
		BigInteger A = new BigInteger("B631EB5AE", 16);
		BigInteger B = new BigInteger("601C227E1", 16);
		BigInteger C = new BigInteger("707AC8792", 16);

		for (int i = 0; i < 1000000; i++) {
			SolutionWithBigInteger.findAndPrintValues(K, A, B, C);
		}

	}

	
	@Test
	public void test01b() {
		int K = 25;
		BigInteger A = new BigInteger("B631EB5AE", 16);
		BigInteger B = new BigInteger("601C227E1", 16);
		BigInteger C = new BigInteger("707AC8792", 16);

		for (int i = 0; i < 1000000; i++) {
			SolutionWithBigInteger.findAndPrintValues2(K, A, B, C);
		}
	}
	


//	@Test
	public void test02() {
		int K = 12;
		BigInteger A = new BigInteger("CAF7028FD", 16);
		BigInteger B = new BigInteger("59B5AC1CE", 16);
		BigInteger C = new BigInteger("CAF1B7B7F", 16);

		SolutionWithBigInteger.findAndPrintValues(K, A, B, C);
//		Expected: 8AF10287D, 48B1B534E
	}
	
	
	public void test02a() {
		int K = 5;
		BigInteger A = new BigInteger("B9", 16);
		BigInteger B = new BigInteger("40", 16);
		BigInteger C = new BigInteger("5A", 16);
		SolutionWithBigInteger.findAndPrintValues(K, A, B, C);
	}
	
	@Test
	public void test03() {
		int K = 2;
		BigInteger A = new BigInteger("91", 16);
		BigInteger B = new BigInteger("BE", 16);
		BigInteger C = new BigInteger("A8", 16);
		SolutionWithBigInteger.findAndPrintValues(K, A, B, C);
	}
	
	@Test
	public void test04() {
		int K = 4;
		BigInteger A = new BigInteger("1001", 2);
		BigInteger B = new BigInteger("10100", 2);
		BigInteger C = new BigInteger("100001", 2);
		
		SolutionWithBigInteger.findAndPrintValues(K, A, B, C);
	}

	
	public void test05() {
		int K = 50000;
		BigInteger tmp = new BigInteger("16", 10).pow(40000);
		BigInteger A = tmp;
		BigInteger B = new BigInteger("111010100", 2).pow(30);
		BigInteger C = tmp.add(new BigInteger("F459A2", 16));
		
		SolutionWithBigInteger.findAndPrintValues(K, A, B, C);
	}

	public void test06() {
		int K = 7;
		BigInteger A = new BigInteger("F", 16);
		BigInteger B = new BigInteger("0", 16);
		BigInteger C = new BigInteger("F1", 16);
		
		SolutionWithBigInteger.findAndPrintValues(K, A, B, C);
	}

	@Test
	public void test07() {
		int K = 8;
		BigInteger A = new BigInteger("2B", 16);
		BigInteger B = new BigInteger("9F", 16);
		BigInteger C = new BigInteger("58", 16);
		SolutionWithBigInteger.findAndPrintValues(K, A, B, C);
	}

}
