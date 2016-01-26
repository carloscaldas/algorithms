package com.carloscaldas.algorithms.datastructure.graph;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class BFS {
	Set<Node> visited = new HashSet<Node>();
	
	public void traverse(Node root) {
		Queue<Node> queue = new LinkedList<Node>();
		visit(root);
		queue.add(root);
		
		while (queue.isEmpty()==false){
			Node node = queue.poll();
			for(Node n: node.getAdjacentNodes()) {
				if (visited.contains(n)==false) {
					visit(n);
					queue.add(n);
				}
			}
		}
	}

	private void visit(Node node) {
		System.out.println("Visiting node:"+node.getId());
		visited.add(node);
	}
}
