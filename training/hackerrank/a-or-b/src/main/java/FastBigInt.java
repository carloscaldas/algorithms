import java.util.Arrays;

public class FastBigInt implements Cloneable {
	private static final String STR_ZERO = "0";

	private long[] value;
	private int numberOfElements;

	public FastBigInt newFromSubset(int fromBlock, int toBlock) {
		int length = toBlock - fromBlock + 1;
		long[] tmp = new long[length];
		System.arraycopy(value, fromBlock, tmp, 0, length);
		return new FastBigInt(tmp, length);
	}

	public FastBigInt(long[] value, int numberOfElements) {
		this.value = value;
		this.numberOfElements = numberOfElements;
	}

	public FastBigInt(String str, int radix) {
		Radix r = Radix.getRadix(radix);
		numberOfElements = (str.length() + r.getBlockStringSize() - 1) / r.getBlockStringSize();
		value = new long[numberOfElements];
		int positions = 0;
		int skip = r.getBlockStringSize();
		for (int i = str.length() - skip; positions < numberOfElements; i -= skip) {
			if (i < 0) {
				skip += i;
				i = 0;
			}

			String tmp = str.substring(i, i + skip);
			value[positions++] = Long.parseLong(tmp, r.getRadix());
		}
	}

	public long numberOfSetBits() {
		long result = 0;
		for (int j = 0; j < numberOfElements; j++) {
			result += Long.bitCount(value[j]);
		}
		return result;
	}

	public long numberOfSetBits(int block) {
		return Long.bitCount(value[block]);
	}

	public boolean testBit(int block, long position) {
		long v = value[block];
		boolean isSet = ((v >> position) & 1) != 0;
		return isSet;
	}

	public void clearBit(int block, long position) {
		value[block] &= ~(1L << position);
	}

	public void setBit(int block, long position) {
		value[block] |= 1L << position;
	}

	public long bitLength(int block) {
		return Long.SIZE - Long.numberOfLeadingZeros(value[block]);
	}

	public long bitLength() {
		long result = 0;
		for (int block = 0; block < numberOfElements; block++) {
			result += Long.SIZE - Long.numberOfLeadingZeros(value[block]);
		}
		return result;
	}

	public FastBigInt and(FastBigInt otherObject) {
		numberOfElements = Math.min(numberOfElements, otherObject.getNumberOfBlocks());
		long[] other = otherObject.getArray();
		for (int i = 0; i < numberOfElements; i++) {
			value[i] &= other[i];
		}
		return this;
	}

	public FastBigInt and(int sourceBlock, FastBigInt otherObject, int otherBlock) {
		long otherValue = otherObject.getArray()[otherBlock];
		value[sourceBlock] &= otherValue;
		return this;
	}

	public FastBigInt xor(FastBigInt otherObject) {
		int max = Math.max(numberOfElements, otherObject.getNumberOfBlocks());
		if (value.length < max) {
			value = Arrays.copyOf(value, max);
		}
		long[] other = otherObject.getArray();
		for (int i = 0; i < numberOfElements; i++) {
			value[i] ^= other[i];
		}
		System.arraycopy(other, numberOfElements - 1, value, numberOfElements - 1, max - numberOfElements);
		numberOfElements = max;
		return this;
	}

	public FastBigInt xor(int sourceBlock, FastBigInt otherObject, int otherBlock) {
		long otherValue = otherObject.getArray()[otherBlock];
		value[sourceBlock] ^= otherValue;
		return this;
	}

	public FastBigInt or(FastBigInt otherObject) {
		int max = Math.max(numberOfElements, otherObject.getNumberOfBlocks());
		if (value.length < max) {
			value = Arrays.copyOf(value, max);
		}
		long[] other = otherObject.getArray();
		for (int i = 0; i < numberOfElements; i++) {
			value[i] |= other[i];
		}
		System.arraycopy(other, numberOfElements - 1, value, numberOfElements - 1, max - numberOfElements);
		numberOfElements = max;
		return this;
	}

	public FastBigInt or(int sourceBlock, FastBigInt otherObject, int otherBlock) {
		long otherValue = otherObject.getArray()[otherBlock];
		value[sourceBlock] |= otherValue;
		return this;
	}

	public String toString(int radix) {
		int totalDigits = Radix.getRadix(radix).getBlockStringSize();
		StringBuilder result = new StringBuilder();
		for (int block = numberOfElements - 1; block > -1; block--) {
			if (value[block] == 0L && block == numberOfElements - 1) {
				numberOfElements--;
				continue;
			}
			String tmp = Long.toString(value[block], radix);
			if (block < numberOfElements - 1) {
				for (int j = 0; j < totalDigits - tmp.length(); j++) {
					result.append(STR_ZERO);
				}
			}
			result.append(tmp);
		}

		String t = result.toString();
		if (t.length() == 0) {
			return "0";
		} else {
			return t;
		}
	}

	protected long[] getArray() {
		return value;
	}

	public int getNumberOfBlocks() {
		return numberOfElements;
	}

	public FastBigInt clone() {
		return new FastBigInt(value.clone(), this.numberOfElements);
	}

	private static enum Radix {
		R16(16, 15), R2(2, 63), R10(10, 18), R8(8, 21);

		private int radix;
		private int blockStringSize;

		Radix(int radix, int skip) {
			this.radix = radix;
			this.blockStringSize = skip;
		}

		int getRadix() {
			return radix;
		}

		public int getBlockStringSize() {
			return this.blockStringSize;
		}

		public static Radix getRadix(int radix) {
			switch(radix) {
			case 16:
					return R16;
			case 2:
					return R2;
			case 10:
					return R10;
			case 8 :
					return R8;
			default:
				break;
			}
			throw new IllegalArgumentException("Just radix 16 is supported for now");
		}
	}

}
