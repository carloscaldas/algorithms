package com.carloscaldas.algorithms.datastructure.graph;

public class Edge {
	private Node vertex1;
	private Node vertex2;
	private Integer weight;
	
	public Edge(Node vertex1, Node vertex2){
		this.setVertex1(vertex1);
		this.setVertex2(vertex2);
	}

	public Node getVertex1() {
		return vertex1;
	}

	public void setVertex1(Node vertex1) {
		this.vertex1 = vertex1;
	}

	public Node getVertex2() {
		return vertex2;
	}

	public void setVertex2(Node vertex2) {
		this.vertex2 = vertex2;
	}

	public Integer getWeight() {
		return weight;
	}

	public void setWeight(Integer weight) {
		this.weight = weight;
	}
}
