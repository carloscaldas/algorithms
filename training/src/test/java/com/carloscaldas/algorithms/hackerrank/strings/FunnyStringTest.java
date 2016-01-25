package com.carloscaldas.algorithms.hackerrank.strings;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import org.junit.Assert;
import org.junit.Test;

//import com.carloscaldas.algorithms.hackerrank.FileTester;

//public class FunnyStringTest extends FileTester {
public class FunnyStringTest {
	@Test
	public void testNotFunnyFunny() {
		String[] values = new String[]{"cabde", "ZXHE", "bcxz", "ivvkxq", "ivvkx"};
		for(String s: values) {
			Assert.assertEquals(FunnyString.NOT_FUNNY, FunnyString.isFunnyOrNotFunny(s));	
		}
	}
	
	@Test
	public void testFunny() {
		String[] values = new String[]{"acxz", "aa", "aca", "ace", "a", "caxz", "cabce"};
		for(String s: values) {
			Assert.assertEquals(FunnyString.FUNNY, FunnyString.isFunnyOrNotFunny(s));	
		}
	}
	
	@Test
	public void testFile01() throws FileNotFoundException {
/*		StringBuffer expected = new StringBuffer();
		expected.append(FunnyString.FUNNY);
		expected.append(FunnyString.NOT_FUNNY);
		
		File f = getResourceFile(this.getClass(), "FunnyString_in00.txt");
		StringBuffer result = new StringBuffer();
		Scanner in = new Scanner(f);
		int T = Integer.valueOf(in.nextLine());
		for (int i=1;i<=T;i++) {
			String S = in.nextLine();
			result.append(FunnyString.isFunnyOrNotFunny(S));
		}
		in.close();
		Assert.assertEquals(expected.toString(), result.toString());
		*/
	}
	

}
