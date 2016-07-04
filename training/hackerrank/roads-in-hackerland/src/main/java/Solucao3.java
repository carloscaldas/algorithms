import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

final class Vertex implements Comparable<Vertex> {
	private Integer distance;
	private Integer nodeId;
	private Integer precedence;

	public Vertex(Integer id) {
		this.nodeId = id;
	}

	public Vertex(Integer id, Integer distance, Integer precedence) {
		this.distance = distance;
		this.nodeId = id;
		this.precedence = precedence;
	}

	public Integer getDistance() {
		return this.distance;
	}

	public void setDistance(Integer value) {
		this.distance = value;
	}

	public Integer getNodeId() {
		return nodeId;
	}

	public Integer getPrecedence() {
		return precedence;
	}

	public void setPrecedence(Integer precedence) {
		this.precedence = precedence;
	}

	public int compareTo(Vertex o) {
		return getNodeId().compareTo(o.getNodeId());
	}

	@Override
	public boolean equals(Object other) {
		if (this == other)
			return true;
		if (other == null || (this.getClass() != other.getClass())) {
			return false;
		}
		return this.getNodeId().equals(((Vertex) other).getNodeId());
	}

	@Override
	public int hashCode() {
		return getNodeId();
	}

}

class Edge {
	private Vertex from;
	private Vertex to;
	private Integer weight;

	public Edge(Vertex from, Vertex to, Integer weight) {
		this.setFrom(from);
		this.setTo(to);
		this.setWeight(weight);
	}

	public Vertex getFrom() {
		return from;
	}

	public void setFrom(Vertex from) {
		this.from = from;
	}

	public Vertex getTo() {
		return to;
	}

	public void setTo(Vertex to) {
		this.to = to;
	}

	public Integer getWeight() {
		return weight;
	}

	public void setWeight(Integer weight) {
		this.weight = weight;
	}
}

final class Graph {
	private Map<Vertex, List<Edge>> adj;

	public Graph(int N) {
		adj = new HashMap<Vertex, List<Edge>>(N);
	}
	public void addEdge(Vertex from, Vertex to, Integer weight) {
		List<Edge> neighbors = adj.get(from);
		if (neighbors == null) {
			neighbors = new LinkedList<Edge>();
			adj.put(from, neighbors);
		}
		neighbors.add(new Edge(from, to, weight));
	}

	public List<Edge> adjacency(Vertex v) {
		return adj.get(v);
	}

	public Set<Vertex> getAllVertices() {
		TreeSet<Vertex> tree = new TreeSet<Vertex>();
		for (Vertex v : adj.keySet()) {
			tree.add(v);
		}
		return tree;
	}
}

public class Solucao3 {

	public static void printAll(Graph g, Vertex source) {
		long result = 0;
		for (Vertex v : g.getAllVertices()) {
			if (v.getNodeId() > source.getNodeId()) {
				long distance = v.getDistance();
				result += distance;
				System.out.printf("(%d,%d)=%d\n", source, v.getNodeId(), distance);
			}
		}
	}

	public static void dijkstra(Graph g, Vertex source) {
		source.setDistance(0);
		FibonacciHeap myHeap = new FibonacciHeap();
		myHeap.insert(source, source.getDistance());

		while (!myHeap.isEmpty()) {
			FibonacciHeap.Node node = myHeap.min();
			Vertex u = (Vertex) node.getData();

			for (Edge e : g.adjacency(u)) {
				Vertex v = e.getTo();
				Integer weight = e.getWeight();
				Integer distanceThroughU = u.getDistance() + weight;
				if (distanceThroughU < v.getDistance()) {
					v.setDistance(distanceThroughU);
					myHeap.decreaseKey(node, (double) v.getDistance());
					v.setPrecedence(u.getNodeId());
				}
			}
		}
	}

	public static void calculate() {
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		int N = in.nextInt();
		int M = in.nextInt();

		Graph g = new Graph(N);

		for (int i = 0; i < M; i++) {
			Integer A = in.nextInt();
			Vertex vA = new Vertex(A);
			Integer B = in.nextInt();
			Vertex vB = new Vertex(B);
			Integer weight = 2;
			int C = in.nextInt();
			if (C == 0) {
				weight = 1;
			} else {
				weight = 2 << (C - 1);
			}
			g.addEdge(vA, vB, weight);
			g.addEdge(vB, vA, weight);
		}
		in.close();

		long sum = 0;

		for (Vertex v : g.getAllVertices()) {
			dijkstra(g, v);
			printAll(g, v);
			// dij.calculate();
			// sum += dij.printAll();
		}
		System.out.println(Long.toBinaryString(sum));
	}
}
