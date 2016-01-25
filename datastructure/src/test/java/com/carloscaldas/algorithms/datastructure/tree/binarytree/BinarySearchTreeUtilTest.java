package com.carloscaldas.algorithms.datastructure.tree.binarytree;

import org.junit.Assert;
import org.junit.Test;

public class BinarySearchTreeUtilTest {
	BinarySearchTreeUtil util = new BinarySearchTreeUtil();
	BinaryNode root = new BinaryNode("n1");
	
	@Test
	public void test01() {
		BinarySearchTreeUtil util = new BinarySearchTreeUtil();
		Assert.assertEquals(util.isBalanced(root), true);
	}

	@Test
	public void test02() {
		BinaryNode n2 = new BinaryNode("n2");
		root.setLeft(n2);
		
		BinaryNode n3 = new BinaryNode("n3");
		root.setRight(n3);

		Assert.assertEquals(util.isBalanced(root), true);
	}

	
	@Test
	public void test03() {
		BinaryNode n2 = new BinaryNode("n2");
		root.setLeft(n2);
		
		BinaryNode n3 = new BinaryNode("n3");
		n2.setLeft(n3);

		Assert.assertEquals(util.isBalanced(root), false);
	}

	@Test
	public void test04() {
		BinaryNode n2 = new BinaryNode("n2");
		root.setLeft(n2);
		
		BinaryNode n3 = new BinaryNode("n3");
		root.setRight(n3);

		BinaryNode n4 = new BinaryNode("n3");
		n2.setLeft(n4);

		BinaryNode n5 = new BinaryNode("n3");
		n2.setRight(n5);
		
		Assert.assertEquals(util.isBalanced(root), true);
	}

	@Test
	public void test06() {
		BinaryNode n2 = new BinaryNode("n2");
		root.setLeft(n2);
		
		BinaryNode n3 = new BinaryNode("n3");
		root.setRight(n3);

		BinaryNode n4 = new BinaryNode("n4");
		n2.setLeft(n4);

		BinaryNode n5 = new BinaryNode("n5");
		n2.setRight(n5);
		
		BinaryNode n6 = new BinaryNode("n6");
		n5.setLeft(n6);
		
		Assert.assertEquals(util.isBalanced(root), false);
	}

	@Test
	public void test07() {
		BinaryNode n2 = new BinaryNode("n2");
		root.setLeft(n2);
		
		BinaryNode n3 = new BinaryNode("n3");
		root.setRight(n3);

		BinaryNode n4 = new BinaryNode("n4");
		n2.setLeft(n4);

		BinaryNode n5 = new BinaryNode("n5");
		n2.setRight(n5);
		
		BinaryNode n6 = new BinaryNode("n6");
		n3.setLeft(n6);

		BinaryNode n7 = new BinaryNode("n7");
		n3.setRight(n7);

		Assert.assertEquals(util.isBalanced(root), true);
	}

	
}
