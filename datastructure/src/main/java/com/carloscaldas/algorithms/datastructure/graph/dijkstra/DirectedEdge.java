package com.carloscaldas.algorithms.datastructure.graph.dijkstra;

//TODO: this is a draft. Must be refactored
public class DirectedEdge  {
	private Vertex vertex1;
	private Vertex vertex2;
	private Integer weight;
	
	public DirectedEdge(Vertex vertex1, Vertex vertex2, Integer weight){
		this.setEndpoint1(vertex1);
		this.setEndpoint2(vertex2);
		this.weight = weight;
	}

	public Vertex getEndpoint1() {
		return vertex1;
	}

	public void setEndpoint1(Vertex vertex1) {
		this.vertex1 = vertex1;
	}

	public Vertex getEndpoint2() {
		return vertex2;
	}

	public void setEndpoint2(Vertex vertex2) {
		this.vertex2 = vertex2;
	}

	public Integer getWeight() {
		return weight;
	}

	public void setWeight(Integer weight) {
		this.weight = weight;
	}

//	@Override
//	public int compareTo(DirectedEdge other) {
//		
//		return 0;
//	}
}
