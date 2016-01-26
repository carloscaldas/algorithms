package com.carloscaldas.algorithms.datastructure.graph.dijkstra;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

//TODO: this is a draft. Must be refactored
public class Graph {
	Set<Vertex> vertices;
	List<DirectedEdge> edges;

	public Graph() {
		this.vertices = new HashSet<Vertex>();
		this.edges = new LinkedList<DirectedEdge>();
	}
	
	public void addVertex(Vertex v) {
		this.vertices.add(v);
	}

	public void addEdge(Vertex v1, Vertex v2, Integer weight) {
		DirectedEdge e = new DirectedEdge(v1, v2, weight);
		v1.getEdges().add(e);
		this.edges.add(e);
		
//		if undirected graph add the following lines
//		DirectedEdge e1 = new DirectedEdge(v2, v1, weight);
//		v2.getEdges().add(e1);
//		this.edges.add(e1);

	}

	public Graph(Set<Vertex> vertices, List<DirectedEdge> edges) {
		this.vertices = vertices;
		this.edges = edges;
	}

	private List<DirectedEdge> getEdges(Vertex v) {
		List<DirectedEdge> result = new LinkedList<DirectedEdge>();

		for (DirectedEdge e : edges) {
			if (e.getEndpoint1().equals(v) || e.getEndpoint2().equals(v)) {
				result.add(e);
			}
		}
		return result;
	}

	public void print() {
		for (Vertex v : vertices) {
			System.out.printf("[%s]:", v.getId());
			List<DirectedEdge> relation = getEdges(v);
			for (DirectedEdge e : relation) {
				System.out.printf("\t(%s,%s)", e.getEndpoint1().getId(), e
						.getEndpoint2().getId());
			}
			System.out.println();
		}
	}
}
