package com.carloscaldas.algorithms.datastructure.graph;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

import com.carloscaldas.algorithms.datastructure.graph.dijkstra.Vertex;

public class BFS {
	Set<Vertex> visited = new HashSet<Vertex>();
	
	public void traverse(Vertex root) {
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
	}

	private void visit(Vertex node) {
		System.out.println("Visiting node:"+node.getId());
		visited.add(node);
	}
}
