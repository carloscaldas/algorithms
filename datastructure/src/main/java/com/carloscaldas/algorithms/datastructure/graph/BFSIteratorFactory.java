package com.carloscaldas.algorithms.datastructure.graph;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class BFSIteratorFactory  {
	private Set<Node> visited = new HashSet<Node>();
	private List<Node> result = new LinkedList<Node>();
	
	public Iterator<Node> BFSIterator(Node root) {
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
		return result.iterator();
	}

	private void visit(Node node) {
		result.add(node);
		visited.add(node);
	}


}
