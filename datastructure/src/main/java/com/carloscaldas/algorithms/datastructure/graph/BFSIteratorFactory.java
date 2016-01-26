package com.carloscaldas.algorithms.datastructure.graph;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

import com.carloscaldas.algorithms.datastructure.graph.dijkstra.Vertex;

public class BFSIteratorFactory  {
	private Set<Vertex> visited = new HashSet<Vertex>();
	private List<Vertex> result = new LinkedList<Vertex>();
	
	public Iterator<Vertex> BFSIterator(Vertex root) {
		Queue<Vertex> queue = new LinkedList<Vertex>();
		visit(root);
		queue.add(root);
		
		while (queue.isEmpty()==false){
			Vertex node = queue.poll();
			for(Vertex n: node.getAdjacentNodes()) {
				if (visited.contains(n)==false) {
					visit(n);
					queue.add(n);
				}
			}
		}
		return result.iterator();
	}

	private void visit(Vertex node) {
		result.add(node);
		visited.add(node);
	}


}
