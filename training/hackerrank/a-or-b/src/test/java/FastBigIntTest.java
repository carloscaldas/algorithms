import java.math.BigInteger;

import org.junit.Assert;
import org.junit.Test;

public class FastBigIntTest {
	private static final String ZERO = "0";
	private static final String ONE_LONG2 = "FFFFFFFFFFFFFFF";
	private static final String TWO_LONG1 = "FFFFFFFFFFFFFFFFFFFFFFFFFFFFFF";

	// 111100000000000000000000000000000000000000000000000010010000111100000000000000000000000000000000000000000000000010010000
	private static final String twoBlocks = "F00000000000090F00000000000090";
	// 110000111100000000000000000000000000000000000000000000000010010000
	private static final String twoBlocks2 = "30F00000000000090";

	@Test
	public void testConstructor() {
		FastBigInt fbi;

		fbi = new FastBigInt(ZERO, 16);
		Assert.assertEquals(fbi.getNumberOfBlocks(), 1);

		fbi = new FastBigInt(ONE_LONG2, 16);
		Assert.assertEquals(fbi.getNumberOfBlocks(), 1);

		fbi = new FastBigInt(TWO_LONG1, 16);
		Assert.assertEquals(fbi.getNumberOfBlocks(), 2);

		BigInteger big = new BigInteger(twoBlocks, 16);
		fbi = new FastBigInt(twoBlocks, 16);
		Assert.assertEquals(big.toString(2), fbi.toString(2));
		// fbi.asString(2)
	}

	@Test
	public void testBitTest() {
		FastBigInt fbi = new FastBigInt("0", 16);
		Assert.assertFalse(fbi.testBit(0, 0));
		Assert.assertFalse(fbi.testBit(0, 1));

		fbi = new FastBigInt("1", 16);
		Assert.assertTrue(fbi.testBit(0, 0));
		Assert.assertFalse(fbi.testBit(0, 1));

		// ‭1010‬
		fbi = new FastBigInt("A", 16);
		Assert.assertFalse(fbi.testBit(0, 0));
		Assert.assertTrue(fbi.testBit(0, 1));
		Assert.assertFalse(fbi.testBit(0, 2));
		Assert.assertTrue(fbi.testBit(0, 3));
		Assert.assertFalse(fbi.testBit(0, 4));

		fbi = new FastBigInt(twoBlocks, 16);
		Assert.assertFalse(fbi.testBit(0, 0));
		Assert.assertFalse(fbi.testBit(0, 1));
		Assert.assertFalse(fbi.testBit(0, 2));
		Assert.assertFalse(fbi.testBit(0, 3));
		Assert.assertTrue(fbi.testBit(0, 4));
		Assert.assertFalse(fbi.testBit(0, 5));

		Assert.assertFalse(fbi.testBit(1, 0));
		Assert.assertFalse(fbi.testBit(1, 1));
		Assert.assertFalse(fbi.testBit(1, 2));
		Assert.assertFalse(fbi.testBit(1, 3));
		Assert.assertTrue(fbi.testBit(1, 4));
		Assert.assertFalse(fbi.testBit(1, 5));
		Assert.assertFalse(fbi.testBit(1, 6));
		Assert.assertTrue(fbi.testBit(1, 7));
		Assert.assertFalse(fbi.testBit(1, 5));
		Assert.assertFalse(fbi.testBit(1, 55));
		Assert.assertTrue(fbi.testBit(1, 56));
		Assert.assertTrue(fbi.testBit(1, 57));
		Assert.assertTrue(fbi.testBit(1, 58));
		Assert.assertTrue(fbi.testBit(1, 59));
		Assert.assertFalse(fbi.testBit(1, 60));
	}

	@Test
	public void clearBitTest() {
		FastBigInt fbi = new FastBigInt(twoBlocks, 16);
		fbi.clearBit(0, 4);
		fbi.clearBit(1, 57);
		Assert.assertFalse(fbi.testBit(0, 0));
		Assert.assertFalse(fbi.testBit(0, 1));
		Assert.assertFalse(fbi.testBit(0, 2));
		Assert.assertFalse(fbi.testBit(0, 3));
		Assert.assertFalse(fbi.testBit(0, 4));
		Assert.assertFalse(fbi.testBit(0, 5));

		Assert.assertFalse(fbi.testBit(1, 0));
		Assert.assertFalse(fbi.testBit(1, 1));
		Assert.assertFalse(fbi.testBit(1, 2));
		Assert.assertFalse(fbi.testBit(1, 3));
		Assert.assertTrue(fbi.testBit(1, 4));
		Assert.assertFalse(fbi.testBit(1, 5));
		Assert.assertFalse(fbi.testBit(1, 6));
		Assert.assertTrue(fbi.testBit(1, 7));
		Assert.assertFalse(fbi.testBit(1, 5));
		Assert.assertFalse(fbi.testBit(1, 55));
		Assert.assertTrue(fbi.testBit(1, 56));

		// only change
		Assert.assertFalse(fbi.testBit(1, 57));

		Assert.assertTrue(fbi.testBit(1, 58));
		Assert.assertTrue(fbi.testBit(1, 59));
		Assert.assertFalse(fbi.testBit(1, 60));
	}

	@Test
	public void setBitTest() {
		FastBigInt fbi = new FastBigInt(twoBlocks, 16);
		fbi.setBit(0, 3);
		fbi.setBit(1, 55);
		Assert.assertFalse(fbi.testBit(0, 0));
		Assert.assertFalse(fbi.testBit(0, 1));
		Assert.assertFalse(fbi.testBit(0, 2));
		Assert.assertTrue(fbi.testBit(0, 3));
		Assert.assertTrue(fbi.testBit(0, 4));
		Assert.assertFalse(fbi.testBit(0, 5));

		Assert.assertFalse(fbi.testBit(1, 0));
		Assert.assertFalse(fbi.testBit(1, 1));
		Assert.assertFalse(fbi.testBit(1, 2));
		Assert.assertFalse(fbi.testBit(1, 3));
		Assert.assertTrue(fbi.testBit(1, 4));
		Assert.assertFalse(fbi.testBit(1, 5));
		Assert.assertFalse(fbi.testBit(1, 6));
		Assert.assertTrue(fbi.testBit(1, 7));
		Assert.assertFalse(fbi.testBit(1, 5));
		Assert.assertTrue(fbi.testBit(1, 55));
		Assert.assertTrue(fbi.testBit(1, 56));
		Assert.assertTrue(fbi.testBit(1, 57));
		Assert.assertTrue(fbi.testBit(1, 58));
		Assert.assertTrue(fbi.testBit(1, 59));
		Assert.assertFalse(fbi.testBit(1, 60));
	}

	@Test
	public void NumberOfSetBitsTest() {
		// 111100000000000000000000000000000000000000000000000010010000
		// 111100000000000000000000000000000000000000000000000010010000
		FastBigInt fbi = new FastBigInt(twoBlocks, 16);
		Assert.assertEquals(12, fbi.numberOfSetBits());
		Assert.assertEquals(6, fbi.numberOfSetBits(0));

		fbi = new FastBigInt(ZERO, 16);
		Assert.assertEquals(0, fbi.numberOfSetBits());

		// 000000000000000000000000000000000000000000000000000000110000
		// 111100000000000000000000000000000000000000000000000010010000
		fbi = new FastBigInt(twoBlocks2, 16);
		Assert.assertEquals(8, fbi.numberOfSetBits());
		Assert.assertEquals(2, fbi.numberOfSetBits(1));
		Assert.assertEquals(6, fbi.numberOfSetBits(0));
		fbi.clearBit(1, 4);
		Assert.assertEquals(1, fbi.numberOfSetBits(1));
		Assert.assertEquals(7, fbi.numberOfSetBits());
	}

	// still positive. find limits of negative and positive
	// long myLong = 0x7FFFFFFFFFFFFFFFL;
	@Test
	public void bitLengthTest() {
		String tmp1 = "30F00000000000090";
		FastBigInt fbi = new FastBigInt(tmp1, 16);
		Assert.assertEquals(66, fbi.bitLength());
		Assert.assertEquals(60, fbi.bitLength(0));
		Assert.assertEquals(6, fbi.bitLength(1));
	}

	//TODO: make a random test with a thousand interations
	@Test
	public void asString16() {
		int radix = 16;
		String test1 = "FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFF";
		String test2 = "10FFFFFFFFFFFFFF";
		
		Assert.assertEquals(new BigInteger(test1, radix).toString(radix), new FastBigInt(test1, 16).toString(radix));
		Assert.assertEquals(new BigInteger(test2, radix).toString(radix), new FastBigInt(test2, 16).toString(radix));
	}

	@Test
	public void asString2() {
		String test3 = "0";
		FastBigInt fbi = new FastBigInt(test3, 16);
		System.out.println(fbi.toString(16));
	}

	public void xorTest() {

	}

	@Test
	public void andTest() {
		String A = "B631EB5AE";
		String B = "601C227E1";
		String C = "707AC8792";
		
		FastBigInt fbiA = new FastBigInt(A, 16);
		FastBigInt fbiB = new FastBigInt(B, 16);
		FastBigInt fbiC = new FastBigInt(C, 16);
		BigInteger bigA = new BigInteger(A, 16);
		BigInteger bigB = new BigInteger(B, 16);
		BigInteger bigC = new BigInteger(C, 16);

		Assert.assertEquals(fbiA.and(fbiC).toString(16), bigA.and(bigC).toString(16));
		Assert.assertEquals(fbiB.and(fbiC).toString(16), bigB.and(bigC).toString(16));
	}

	public void orTest() {

	}
}
