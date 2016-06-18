package com.carloscaldas.algorithms.hackerrank.sorting.MaximizeSum;

import org.junit.Test;

import com.carloscaldas.algorithms.hackerrank.sorting.MaximiseSum;

import org.junit.Assert;

public class MaximizeSumTestArrays {

	// @Test
	public void test_result6() {
		// Assert.assertEquals(6, MaximiseSum.max_mod_sum(new long[] { 3, 1, 5
		// }, 7));
		// Assert.assertEquals(6,
		// MaximiseSum.calculatesBestContiguousSumModule(new long[] { 1, 2, 5, 1
		// }, 7));
		// Assert.assertEquals(6,
		// MaximiseSum.calculatesBestContiguousSumModule(new long[] { 1, 1, 5, 2
		// }, 7));
		// Assert.assertEquals(6,
		// MaximiseSum.calculatesBestContiguousSumModule(new long[] { 1, -1, 5,
		// 1 }, 7));
		// System.out.println(MaximiseSum.calculatesBestContiguousSumModule(new
		// long[] { 3, 1, 5 }, 7));
	}

	// @Test
	public void test_result6b() {

		Assert.assertEquals(6, MaximiseSum.sum_mod(new long[] { 1, 1, 5, 2 }, 7));
		Assert.assertEquals(6, MaximiseSum.sum_mod(new long[] { 3, 1, 5 }, 7));
		Assert.assertEquals(6, MaximiseSum.sum_mod(new long[] { 1, 2, 5, 1 }, 7));
		Assert.assertEquals(6, MaximiseSum.sum_mod(new long[] { 1, -1, 5, 1 }, 7));
		Assert.assertEquals(6, MaximiseSum.sum_mod(new long[] { 3, 1, 5 }, 7));
	}

	// @Test
	public void test_result6c() {
		Assert.assertEquals(6, MaximiseSum.bruteForce(new long[] { 1, 1, 5, 2 }, 7));
		// Assert.assertEquals(6, MaximiseSum.bruteForce(new long[] { 3, 1, 5 },
		// 7));
		// Assert.assertEquals(6, MaximiseSum.bruteForce(new long[] { 1, 2, 5, 1
		// }, 7));
		// Assert.assertEquals(6, MaximiseSum.bruteForce(new long[] { 1, -1, 5,
		// 1 }, 7));
		// Assert.assertEquals(6, MaximiseSum.bruteForce(new long[] { 3, 1, 5 },
		// 7));
	}

	@Test
	public void test02() {
		// todo:verify the expected values
		// Assert.assertEquals(2, MaximiseSum.sum_mod(new long[] { 1, -1, 5, 1
		// }, 3));
		// Assert.assertEquals(8, MaximiseSum.sum_mod(new long[] { 3, 5, 7 },
		// 11));
		//MaximiseSum.modulo(new long[] { 6, 6, 11, 2, 12, 1 }, 13L);
		System.out.println(MaximiseSum.modulo3(new long[] { 4, 5, 3, 3 }, 7L));
	}

}
