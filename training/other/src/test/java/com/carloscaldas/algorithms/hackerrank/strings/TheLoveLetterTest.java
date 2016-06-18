package com.carloscaldas.algorithms.hackerrank.strings;

import org.junit.Assert;
import org.junit.Test;

public class TheLoveLetterTest {
	@Test
	public void test01() {
		Assert.assertEquals(0, TheLoveLetter.getMinimumTransitions(""));
		Assert.assertEquals(0, TheLoveLetter.getMinimumTransitions("a"));
		Assert.assertEquals(2, TheLoveLetter.getMinimumTransitions("abc"));
		Assert.assertEquals(0, TheLoveLetter.getMinimumTransitions("abcba"));
		Assert.assertEquals(4, TheLoveLetter.getMinimumTransitions("abcd"));
		Assert.assertEquals(2, TheLoveLetter.getMinimumTransitions("cba"));
		Assert.assertEquals(2, TheLoveLetter.getMinimumTransitions("abaaab"));

	}
}
