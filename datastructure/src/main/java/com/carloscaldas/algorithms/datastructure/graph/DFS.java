package com.carloscaldas.algorithms.datastructure.graph;

import java.util.HashSet;
import java.util.Set;


public class DFS {
	Set<Node> visited = new HashSet<Node>();

	public void traverse(Node root) {
		visit(root);

		for (Node n : root.getAdjacentNodes()) {
			if (visited.contains(n) == false) {
				traverse(n);
			}
		}
	}

	private void visit(Node node) {
		System.out.println("Visiting node:" + node.getId());
		visited.add(node);
	}
}
