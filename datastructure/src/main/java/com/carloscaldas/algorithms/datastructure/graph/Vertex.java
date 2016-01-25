package com.carloscaldas.algorithms.datastructure.graph;

public class Vertex {
	private final String id;

	public Vertex(String id) {
		this.id = id;
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

}
