package com.carloscaldas.algorithms.datastructure.graph.dijkstra;

//TODO: this is a draft. Must be refactored
//Natural order: Vertex
public class VertexInfo  implements Comparable<VertexInfo> {
	private Integer distance;
	private Vertex vertex;
	private Vertex precedence;

	public VertexInfo(Vertex id) {
		this.vertex = id;
	}

	public VertexInfo(Vertex id, Integer distance, Vertex precedence) {
		this.distance = distance;
		this.vertex = id;
		this.precedence = precedence;
	}

	public Integer getDistance() {
		return this.distance;
	}

	public void setDistance(Integer value) {
		this.distance = value;
	}

	public Vertex getVertex() {
		return vertex;
	}

	public Vertex getPrecedence() {
		return precedence;
	}

	public void setPrecedence(Vertex precedence) {
		this.precedence = precedence;
	}

	@Override
	public int hashCode() {
		return getVertex().getId().hashCode();
	}
	
	@Override
	public int compareTo(VertexInfo other) {
		return this.getVertex().compareTo(other.getVertex());
	}
}
