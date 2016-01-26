package com.carloscaldas.algorithms.datastructure.graph.dijkstra;

import java.util.HashSet;
import java.util.Set;

//TODO: this is a draft. Must be refactored
//Natural order: Id
public class Vertex implements Comparable<Vertex> {
	private final String id;
	private final Set<Vertex> adjacentNodes;
	private final Set<DirectedEdge> edges;

	public Vertex(String id) {
		this.id = id;
		this.adjacentNodes = new HashSet<Vertex>();
		this.edges = new HashSet<DirectedEdge>();
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
		
		if ((obj instanceof Vertex) == false)
			return false;
		
		Vertex other = (Vertex) obj;
		return getId().equals(other.getId());
	}

	@Override
	public String toString() {
		return id;
	}

	public Set<DirectedEdge> getEdges() {
		return edges;
	}

	@Override
	public int compareTo(Vertex other) {
		return this.getId().compareTo(other.getId());
	}

	public Set<Vertex> getAdjacentNodes() {
		return adjacentNodes;
	}

}
