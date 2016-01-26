package com.carloscaldas.algorithms.datastructure.graph;

import java.util.HashSet;
import java.util.Set;

public class Node {
	private final String id;
	private final Set<Node> adjacentNodes;

	public Node(String id) {
		this.id = id;
		this.adjacentNodes = new HashSet<Node>(); 
	}

	public String getId() {
		return id;
	}

	@Override
	public int hashCode() {
		return id.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null)
			return false;

		if (this == obj)
			return true;
		
		if ((obj instanceof Node) == false)
			return false;
		
		Node other = (Node) obj;
		return getId().equals(other.getId());
	}

	@Override
	public String toString() {
		return id;
	}

	public Set<Node> getAdjacentNodes() {
		return adjacentNodes;
	}
}
