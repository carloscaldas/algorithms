import org.junit.Test;

import org.junit.Assert;

public class BitLengthTest {
	private static final int ITERATIONS = 9950000;

	@Test
	public void test0() {
		System.out.println(Long.toBinaryString(Long.parseLong("101", 16)));
	}
	
	@Test
	public void test1() {
		long l = Long.parseLong("B9AF7028FD", 16);
		for (int i = 0; i < ITERATIONS; i++) {
			method1(l);
		}
		System.out.println(method1(l));
	}

	@Test
	public void test2() {
		long l = Long.parseLong("B9AF7028FD", 16);
		for (int i = 0; i < ITERATIONS; i++) {
			method2(l);
		}
		System.out.println(method2(l));
	}

	private long method1(long value) {
		int count = 0;
		while (value > 0) {
		    count++;
		    value = value >> 1;
		}
		return count;
	}

	private long method2(long value) {
	    return Long.SIZE-Long.numberOfLeadingZeros(value);
	}
	
	@Test
	public void testSetBits() {
		long l = Long.parseLong("B9AF7028FD", 16);
		System.out.println(Long.toBinaryString(l));
		System.out.println(Long.bitCount(l));
	}
	
	@Test
	public void testCloneable() {
		FastBigInt x = new FastBigInt("BC9A9999FB9AF7028FD", 16);
		FastBigInt y = (FastBigInt) x.clone();

		Assert.assertNotEquals(x, y);
		Assert.assertEquals(x.getNumberOfBlocks(), y.getNumberOfBlocks());
		Assert.assertArrayEquals(x.getArray(), y.getArray());
	}

}
