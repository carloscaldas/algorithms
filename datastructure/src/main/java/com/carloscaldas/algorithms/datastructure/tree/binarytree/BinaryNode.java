package com.carloscaldas.algorithms.datastructure.tree.binarytree;

public class BinaryNode {
	private String id;
	private BinaryNode left;
	private BinaryNode right;
	
	public BinaryNode(String id) {
		this.setId(id);
	}
	
	public BinaryNode getLeft() {
		return left;
	}
	public void setLeft(BinaryNode left) {
		this.left = left;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public BinaryNode getRight() {
		return right;
	}

	public void setRight(BinaryNode right) {
		this.right = right;
	}
	
}
