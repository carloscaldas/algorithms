package com.carloscaldas.algorithms.datastructure.tree.binarytree;

public class BinarySearchTreeUtil {
	
	public Integer calculateHeightIfIsBalanced(BinaryNode root) {
		if (root == null) 
		{
			return 0;
		}

		Integer leftHeight = calculateHeightIfIsBalanced(root.getLeft());
		if (leftHeight == null) {
			return null;
		}
		
		Integer rightHeight = calculateHeightIfIsBalanced(root.getRight());
		if (rightHeight == null) {
			return null;
		}

		Integer result = null;
		Integer heightDiff = Math.abs(rightHeight-leftHeight);
		if (heightDiff <= 1) {
			result = Math.max(leftHeight, rightHeight) + 1;
		}
		return result;
	}
	
	public boolean isBalanced(BinaryNode root) {
		Integer height = calculateHeightIfIsBalanced(root);
		return (height==null) ? false : true; 
	}
	
	
	public static void main(String[] args) {
	}
	
}
