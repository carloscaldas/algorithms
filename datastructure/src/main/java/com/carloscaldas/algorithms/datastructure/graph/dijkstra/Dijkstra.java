package com.carloscaldas.algorithms.datastructure.graph.dijkstra;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

//TODO: this is a draft. Must be refactored
//M * log (n)
public class Dijkstra {
	private final Graph graph;
	
	//S
	Map<Vertex, VertexInfo> distancesfromSource = new HashMap<Vertex, VertexInfo>();
	//Q = not determined
	Queue<VertexInfo> queueDistance = new PriorityQueue<VertexInfo>(new VertexInfoDistanceComparator());

	public Dijkstra(Graph graph) {
		this.graph = graph;
	}
	
	private void initialize(Vertex startNode) {
		for(Vertex vertex : graph.vertices) {
			VertexInfo info = new VertexInfo(vertex, startNode.equals(vertex) ? 0 : Integer.MAX_VALUE, null);
			distancesfromSource.put(vertex, info);
			queueDistance.add(info);
		}
	}
	
	public void dijkstra(Vertex startNode) {
		initialize(startNode);

		while (queueDistance.isEmpty() == false){
			VertexInfo infoU = queueDistance.poll(); 
			Vertex u = infoU.getVertex();
			
			for(DirectedEdge edge: u.getEdges()) {
				Vertex v = edge.getEndpoint2();
				Integer alt = infoU.getDistance() + edge.getWeight();
				
				VertexInfo currentInfo = distancesfromSource.get(v);
				Integer currentDistance = currentInfo.getDistance();
				if (alt < currentDistance) {
					//Priority queue does not support update value. So that, we must remove [O(n)] and add [O(log n)]
					//TODO: implement a Fibonnaci Heap that supports update. remove [O(1)] and add [O(1)]
					queueDistance.remove(currentInfo);
					currentInfo.setPrecedence(u);
					currentInfo.setDistance(alt);
					queueDistance.add(currentInfo);
				}
			}
		}
	}

	
	public void printDistances() {
		for (Vertex vertex : distancesfromSource.keySet()) {
			VertexInfo info = distancesfromSource.get(vertex);
			System.out.printf("Vertex [%s] - Distance [%d]%n", vertex.getId(), info.getDistance());
		}
	}

	public static void main(String[] args) {
		Vertex v1 = new Vertex("1");
		Vertex v2 = new Vertex("2");
		Vertex v3 = new Vertex("3");
		Vertex v4 = new Vertex("4");
		
		Graph graph = new Graph();
		graph.vertices.add(v1);
		graph.vertices.add(v2);
		graph.vertices.add(v3);
		graph.vertices.add(v4);
		
		graph.addEdge(v1, v2, 24);
		graph.addEdge(v1, v4, 20);
		graph.addEdge(v3, v1, 3);
		graph.addEdge(v4, v3, 12);
		
		graph.print();
		
		Dijkstra dij = new Dijkstra(graph);
		dij.dijkstra(v1);
		dij.printDistances();
//		1 2 24
//		1 4 20
//		3 1 3
//		4 3 12
//		1		
	}
	
}
