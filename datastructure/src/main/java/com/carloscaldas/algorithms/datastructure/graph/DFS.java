package com.carloscaldas.algorithms.datastructure.graph;

import java.util.HashSet;
import java.util.Set;

import com.carloscaldas.algorithms.datastructure.graph.dijkstra.Vertex;


public class DFS {
	Set<Vertex> visited = new HashSet<Vertex>();

	public void traverse(Vertex root) {
		visit(root);

		for (Vertex n : root.getAdjacentNodes()) {
			if (visited.contains(n) == false) {
				traverse(n);
			}
		}
	}

	private void visit(Vertex node) {
		System.out.println("Visiting node:" + node.getId());
		visited.add(node);
	}
}
