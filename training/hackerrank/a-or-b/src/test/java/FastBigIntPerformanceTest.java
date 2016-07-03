import java.math.BigInteger;

import org.junit.Test;

import org.junit.Assert;

public class FastBigIntPerformanceTest {
	final int ITERATIONS = 500000;
	String str1 = "CAF7028FD", str2 = "59B5AC1CE", str3 = "CAF1B7B7F";

	@Test
	public void stressMy() {
		for (int i = 0; i < ITERATIONS; i++) {
			myBigIntegerTest();
		}
	}

	@Test
	public void stressBigInteger() {
		for (int i = 0; i < ITERATIONS; i++) {
			bigIntegerJava();
		}
	}

	// @Test
	// public void myTest01() {
	// MyBigInteger16 my1 = new MyBigInteger16("BA1");
	// MyBigInteger16 my2 = new MyBigInteger16("A0");
	// my1.XOR(my2).printValue();
	// }

	public void myBigIntegerTest() {
		FastBigInt A = new FastBigInt(str1, 16);
		FastBigInt B = new FastBigInt(str2, 16);
		FastBigInt C = new FastBigInt(str3, 16);

		System.out.println(A.and(C).toString());
		System.out.println(B.and(C).xor(A).xor(C).toString());
	}

	public void bigIntegerJava() {
		BigInteger A = new BigInteger(str1, 16);
		BigInteger B = new BigInteger(str2, 16);
		BigInteger C = new BigInteger(str3, 16);
		System.out.println(A.and(C));
		System.out.println(B.and(C).xor(A).xor(C));
		// BigInteger C = new BigInteger("CAF1B7B7F", 16);
	}

	@Test
	public void testIsSet01() {
		FastBigInt A = new FastBigInt("7028FD", 16);
		Assert.assertTrue(A.testBit(0, 0));
		Assert.assertFalse(A.testBit(0, 1));
		Assert.assertFalse(A.testBit(0, 8));
		Assert.assertTrue(A.testBit(0, 11));
	}

	@Test
	public void testIsSet02() {
		FastBigInt A = new FastBigInt("A21AAAAAAAAA7028FD", 16);
		Assert.assertTrue(A.testBit(0, 0));
		Assert.assertFalse(A.testBit(0, 1));
		Assert.assertFalse(A.testBit(0, 8));
		Assert.assertTrue(A.testBit(0, 11));

		Assert.assertTrue(A.testBit(1, 0));
		Assert.assertFalse(A.testBit(1, 2));
		Assert.assertTrue(A.testBit(1, 5));
		Assert.assertFalse(A.testBit(1, 6));

		Assert.assertEquals(A.getNumberOfBlocks(), 2);
	}

	@Test
	public void testClearBit01() {
		FastBigInt A = new FastBigInt("F7028FD", 16);
		Assert.assertEquals("1111011100000010100011111101", A.toString(2));
		A.clearBit(0, 5);
		Assert.assertEquals("1111011100000010100011011101", A.toString(2));
	}

	@Test
	public void testBitLength() {
		
		// MyBigInteger16 A = new MyBigInteger16("0F7028FD");
		// A.printValue(2);
		Integer l = Integer.parseInt("10", 5);
		System.out.println(l);
		System.out.println(Integer.toBinaryString(l));
		System.out.println(bitLength(l));
		System.out.println(Long.toBinaryString(Long.highestOneBit(l)));
		System.out.println(1 + Math.floor(Math.log(l) / Math.log(2)));
		System.out.println(Long.SIZE-Long.numberOfLeadingZeros(l));
		// System.out.println(Long.toBinaryString(l2));
	}

	public static long bitLength(long i) {
	    long len = 0;

	    while (i != 0) {
//	        len += (i & 1);
	    	len++;
	        i >>>= 1;
	    }

	    return len;
	}
	
	long length(long value) {
		value |= (value >> 1);
		value |= (value >> 2);
		value |= (value >> 4);
		value |= (value >> 8);
		value |= (value >> 16);
		value |= (value >> 32);
		return value;
	}

}
