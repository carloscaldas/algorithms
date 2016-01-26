package com.carloscaldas.algorithms.datastructure.graph.dijkstra;

import java.util.Comparator;

//TODO: this is a draft. Must be refactored
public class VertexInfoDistanceComparator implements Comparator<VertexInfo> {
	public int compare(VertexInfo o1, VertexInfo o2) {
		if ((o1.getDistance() == null) && (o2.getDistance() == null))
			return 0;
		if (o2.getDistance() == null)
			return -1;
		if (o1.getDistance() == null)
			return 1;
		return o1.getDistance().compareTo(o2.getDistance());
	}
}
