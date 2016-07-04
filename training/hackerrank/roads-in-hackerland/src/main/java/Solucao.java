import java.io.Serializable;
import java.util.AbstractQueue;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.ConcurrentModificationException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Scanner;


public class Solucao {

	static class Graph {
		private int numberOfVertex;
		private Map<Integer, List<Edge>> edges = new HashMap<Integer, List<Edge>>();

		public Graph(int numberOfVertex) {
			this.numberOfVertex = numberOfVertex;
		}

		public void addEdge(Integer src, Integer dest, Integer length) {
			List<Edge> neighbors = this.edges.get(src);
			if (neighbors == null) {
				neighbors = new LinkedList<Edge>();
				this.edges.put(src, neighbors);
			}
			Edge e = new Edge(src, dest, length);
			neighbors.add(e);
		}

		public List<Edge> getNeighbors(Integer vertex) {
			List<Edge> neighbors = this.edges.get(vertex);
			if (neighbors == null) {
				return Collections.emptyList();
			} else {
				return Collections.unmodifiableList(neighbors);
			}
		}

		public int getNumberOfVertices() {
			return numberOfVertex;
		}
	}

	static class Edge {
		private Integer source;
		private Integer dest;
		private Integer length;

		public Edge(Integer source, Integer target, Integer length) {
			this.source = source;
			this.dest = target;
			this.setLength(length);
		}

		public Integer getNode1() {
			return source;
		}

		public Integer getNode2() {
			return dest;
		}

		public Integer getLength() {
			return length;
		}

		public void setLength(Integer length) {
			this.length = length;
		}
	}

	static class Dijkstra {
		static int INFINITY = 2500;

		private final Graph graph;
		private final UpdatableHeap<VertexInfo> queueDistance;
		private final VertexInfo[] vertexInfo;
		private final Integer source;

		public VertexInfo getVertexInfo(Integer node) {
			return vertexInfo[node - 1];
		}

		private void setVertexInfo(Integer node, VertexInfo vi) {
			vertexInfo[node - 1] = vi;
		}

		public Dijkstra(Graph g, Integer source) {
			this.graph = g;
			this.queueDistance = new UpdatableHeap<VertexInfo>(
					new VertexInfoDistanceComparator());
			this.vertexInfo = new VertexInfo[graph.getNumberOfVertices()];
			this.source = source;
			initialize();
		}

		public void initialize() {
			for (Integer i = 1; i <= graph.getNumberOfVertices(); i++) {
				VertexInfo p = new VertexInfo(i, source.equals(i) ? 0
						: INFINITY, null);
				queueDistance.add(p);
				setVertexInfo(i, p);
			}
		}

		public void calculate() {
			while (queueDistance.size() > 0) {
				VertexInfo uInfo = queueDistance.remove();
				Integer u = uInfo.getNodeId();
				List<Edge> neighbors = graph.getNeighbors(u);
				for (Edge edge : neighbors) {
					int alt = uInfo.getDistance() + edge.getLength();

					Integer v = edge.getNode2();
					VertexInfo vInfo = getVertexInfo(v);

					if (alt < vInfo.getDistance()) {
						vInfo.setDistance(alt);
						queueDistance.remove(vInfo);
						queueDistance.add(vInfo);
						vInfo.setPrecedence(u);
					}
				}
			}
		}

		public long printAll() {
			long result = 0;
			for (int i = source + 1; i <= graph.getNumberOfVertices(); i++) {
				long distance = getVertexInfo(i).getDistance();
				result += distance;
			}
			return result;
		}
	}

	static class VertexInfo {
		private Integer distance;
		private Integer nodeId;
		private Integer precedence;

		public VertexInfo(Integer id) {
			this.nodeId = id;
		}

		public VertexInfo(Integer id, Integer distance, Integer precedence) {
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
	}

	static class VertexInfoDistanceComparator implements Comparator<VertexInfo> {
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

	static class UpdatableHeap<O> extends Heap<O> {
		/**
		 * Serial version
		 */
		private static final long serialVersionUID = 1L;

		/**
		 * Holds the indices in the heap of each element.
		 */
		private HashMap<O, Integer> index = new HashMap<O, Integer>();

		/**
		 * Simple constructor with default size.
		 */
		public UpdatableHeap() {
			super();
		}

		/**
		 * Constructor with predefined size.
		 * 
		 * @param size
		 *            Size
		 */
		public UpdatableHeap(int size) {
			super(size);
		}

		/**
		 * Constructor with comparator
		 * 
		 * @param comparator
		 *            Comparator
		 */
		public UpdatableHeap(Comparator<? super O> comparator) {
			super(comparator);
		}

		/**
		 * Constructor with predefined size and comparator
		 * 
		 * @param size
		 *            Size
		 * @param comparator
		 *            Comparator
		 */
		public UpdatableHeap(int size, Comparator<? super O> comparator) {
			super(size, comparator);
		}

		@Override
		public void clear() {
			super.clear();
			index.clear();
		}

		@Override
		public synchronized boolean offer(O e) {
			Integer pos = index.get(e);
			if (pos == null) {
				// LoggingUtil.logExpensive(Level.INFO, "Inserting: "+e);
				// insert
				return super.offer(e);
			} else {
				// update
				if (compareExternal(e, pos) < 0) {
					// LoggingUtil.logExpensive(Level.INFO,
					// "Updating value: "+e+" vs. "+castQueueElement(pos));
					modCount++;
					putInQueue(pos, e);
					heapifyUpParent(pos);
					// We have changed - return true according to {@link
					// Collection#put}
					return true;
				} else {
					// LoggingUtil.logExpensive(Level.INFO,
					// "Keeping value: "+e+" vs. "+castQueueElement(pos));
					// Ignore, no improvement. Return success anyway.
					return true;
				}
			}
		}

		@Override
		protected void putInQueue(int pos, Object e) {
			super.putInQueue(pos, e);
			// Keep index up to date
			if (e != null) {
				O n = castQueueElement(pos);
				index.put(n, pos);
			}
		}

		@Override
		protected synchronized O removeAt(int pos) {
			O node = super.removeAt(pos);
			// Keep index up to date
			index.remove(node);
			return node;
		}

		/**
		 * Remove the given object from the queue.
		 * 
		 * @param e
		 *            Obejct to remove
		 * @return Existing entry
		 */
		public O removeObject(O e) {
			Integer pos = index.get(e);
			if (pos != null) {
				return removeAt(pos);
			} else {
				return null;
			}
		}

		@Override
		public O poll() {
			O node = super.poll();
			index.remove(node);
			return node;
		}
	}

	static class Heap<E> extends AbstractQueue<E> implements Serializable {

		private static final long serialVersionUID = 1L;
		private Object[] queue;
		protected int size = 0;

		/**
		 * The comparator or {@code null}
		 */
		private final Comparator<? super E> comparator;

		/**
		 * (Structural) modification counter. Used to invalidate iterators.
		 */
		public transient int modCount = 0;

		/**
		 * Default initial capacity
		 */
		private static final int DEFAULT_INITIAL_CAPACITY = 11;

		/**
		 * Default constructor: default capacity, natural ordering.
		 */
		public Heap() {
			this(DEFAULT_INITIAL_CAPACITY, null);
		}

		/**
		 * Constructor with initial capacity, natural ordering.
		 * 
		 * @param size
		 *            initial size
		 */
		public Heap(int size) {
			this(size, null);
		}

		/**
		 * Constructor with {@link Comparator}.
		 * 
		 * @param comparator
		 *            Comparator
		 */
		public Heap(Comparator<? super E> comparator) {
			this(DEFAULT_INITIAL_CAPACITY, comparator);
		}

		/**
		 * Constructor with initial capacity and {@link Comparator}.
		 * 
		 * @param size
		 *            initial capacity
		 * @param comparator
		 *            Comparator
		 */
		public Heap(int size, Comparator<? super E> comparator) {
			super();
			this.size = 0;
			this.queue = new Object[size];
			this.comparator = comparator;
		}

		@Override
		public synchronized boolean offer(E e) {
			// resize when needed
			considerResize(size + 1);
			final int parent = parent(size);
			// append element
			modCount++;
			putInQueue(size, e);
			this.size = size + 1;
			heapifyUp(parent);
			// We have changed - return true according to {@link Collection#put}
			return true;
		}

		@Override
		public synchronized E peek() {
			if (size == 0) {
				return null;
			}
			return castQueueElement(0);
		}

		@Override
		public E poll() {
			return removeAt(0);
		}

		/**
		 * Remove the element at the given position.
		 * 
		 * @param pos
		 *            Element position.
		 */
		protected synchronized E removeAt(int pos) {
			if (pos < 0 || pos >= size) {
				return null;
			}
			modCount++;
			E ret = castQueueElement(0);
			// remove!
			putInQueue(pos, queue[size - 1]);
			size = size - 1;
			// avoid dangling references!
			putInQueue(size, null);
			heapifyDown(pos);
			return ret;
		}

		/**
		 * Compute parent index in heap array.
		 * 
		 * @param pos
		 *            Element index
		 * @return Parent index
		 */
		private int parent(int pos) {
			return (pos - 1) / 2;
		}

		/**
		 * Compute left child index in heap array.
		 * 
		 * @param pos
		 *            Element index
		 * @return left child index
		 */
		private int leftChild(int pos) {
			return 2 * pos + 1;
		}

		/**
		 * Compute right child index in heap array.
		 * 
		 * @param pos
		 *            Element index
		 * @return right child index
		 */
		private int rightChild(int pos) {
			return 2 * pos + 2;
		}

		/**
		 * Execute a "Heapify Upwards" aka "SiftUp". Used in insertions.
		 * 
		 * @param pos
		 *            insertion position
		 */
		protected void heapifyUp(int pos) {
			if (pos < 0 || pos >= size) {
				return;
			}
			// precondition: both child trees are already sorted.
			final int parent = parent(pos);
			final int lchild = leftChild(pos);
			final int rchild = rightChild(pos);

			int min = pos;
			if (lchild < size) {
				if (compare(min, lchild) > 0) {
					min = lchild;
				}
			}
			if (rchild < size) {
				if (compare(min, rchild) > 0) {
					min = rchild;
				}
			}
			if (min != pos) {
				swap(pos, min);
				heapifyUp(parent);
			}
		}

		/**
		 * Start a heapify up at the parent of this node, since we've changed a
		 * child
		 * 
		 * @param pos
		 *            Position to start the modification.
		 */
		protected void heapifyUpParent(int pos) {
			heapifyUp(parent(pos));
		}

		/**
		 * Execute a "Heapify Downwards" aka "SiftDown". Used in deletions.
		 * 
		 * @param pos
		 *            re-insertion position
		 */
		protected void heapifyDown(int pos) {
			if (pos < 0 || pos >= size) {
				return;
			}
			final int lchild = leftChild(pos);
			final int rchild = rightChild(pos);

			int min = pos;
			if (lchild < size) {
				if (compare(min, lchild) > 0) {
					min = lchild;
				}
			}
			if (rchild < size) {
				if (compare(min, rchild) > 0) {
					min = rchild;
				}
			}
			if (min != pos) {
				// swap with minimal element
				swap(pos, min);
				// recurse down
				heapifyDown(min);
			}
		}

		/**
		 * Put an element into the queue at a given position. This allows
		 * subclasses to index the queue.
		 * 
		 * @param index
		 *            Index
		 * @param e
		 *            Element
		 */
		protected void putInQueue(int index, Object e) {
			queue[index] = e;
		}

		/**
		 * Swap two elements in the heap.
		 * 
		 * @param a
		 *            Element
		 * @param b
		 *            Element
		 */
		protected void swap(int a, int b) {
			Object oa = queue[a];
			Object ob = queue[b];
			putInQueue(a, ob);
			putInQueue(b, oa);
			modCount++;
		}

		@SuppressWarnings("unchecked")
		protected int compare(int pos1, int pos2) {
			if (comparator != null) {
				return comparator.compare(castQueueElement(pos1),
						castQueueElement(pos2));
			}
			try {
				Comparable<E> c = (Comparable<E>) castQueueElement(pos1);
				return c.compareTo(castQueueElement(pos2));
			} catch (ClassCastException e) {
				throw e;
			}
		}

		@SuppressWarnings("unchecked")
		protected int compareExternal(E o1, int pos2) {
			if (comparator != null) {
				return comparator.compare(o1, castQueueElement(pos2));
			}
			try {
				Comparable<E> c = (Comparable<E>) o1;
				return c.compareTo(castQueueElement(pos2));
			} catch (ClassCastException e) {
				throw e;
			}
		}

		@SuppressWarnings("unchecked")
		protected int compareExternalExternal(E o1, E o2) {
			if (comparator != null) {
				return comparator.compare(o1, o2);
			}
			try {
				Comparable<E> c = (Comparable<E>) o1;
				return c.compareTo(o2);
			} catch (ClassCastException e) {
				throw e;
			}
		}

		@SuppressWarnings("unchecked")
		protected E castQueueElement(int n) {
			return (E) queue[n];
		}

		@Override
		public int size() {
			return this.size;
		}

		/**
		 * Test whether we need to resize to have the requested capacity.
		 * 
		 * @param requiredSize
		 *            required capacity
		 */
		private void considerResize(int requiredSize) {
			if (requiredSize > queue.length) {
				// Double until 64, then increase by 50% each time.
				int newCapacity = ((queue.length < 64) ? ((queue.length + 1) * 2)
						: ((queue.length / 2) * 3));
				// overflow?
				if (newCapacity < 0) {
					newCapacity = Integer.MAX_VALUE;
				}
				if (requiredSize > newCapacity) {
					newCapacity = requiredSize;
				}
				grow(newCapacity);
			}
		}

		/**
		 * Execute the actual resize operation.
		 * 
		 * @param newsize
		 *            New size
		 */
		private void grow(int newsize) {
			// check for overflows
			if (newsize < 0) {
				throw new OutOfMemoryError();
			}
			if (newsize == queue.length) {
				return;
			}
			modCount++;
			queue = Arrays.copyOf(queue, newsize);
		}

		@Override
		public void clear() {
			modCount++;
			// clean up references in the array for memory management
			for (int i = 0; i < size; i++) {
				queue[i] = null;
			}
			this.size = 0;
		}

		@Override
		public boolean contains(Object o) {
			if (o != null) {
				// TODO: use order to reduce search space?
				for (int i = 0; i < size; i++) {
					if (o.equals(queue[i])) {
						return true;
					}
				}
			}
			return false;
		}

		// TODO: bulk add implementation of addAll?

		@Override
		public Iterator<E> iterator() {
			return new Itr();
		}

		/**
		 * Iterator over queue elements. No particular order (i.e. heap order!)
		 * 
		 * @author Erich Schubert
		 * 
		 * @apiviz.exclude
		 */
		protected final class Itr implements Iterator<E> {
			/**
			 * Cursor position
			 */
			private int cursor = 0;

			/**
			 * Modification counter this iterator is valid for.
			 */
			private int expectedModCount = modCount;

			@Override
			public boolean hasNext() {
				return cursor < size;
			}

			@Override
			public E next() {
				if (expectedModCount != modCount) {
					throw new ConcurrentModificationException();
				}
				if (cursor < size) {
					return castQueueElement(cursor++);
				}
				throw new NoSuchElementException();
			}

			@Override
			public void remove() {
				if (expectedModCount != modCount) {
					throw new ConcurrentModificationException();
				}
				if (cursor > 0) {
					cursor--;
				} else {
					throw new IllegalStateException();
				}
				expectedModCount = modCount;
			}
		}

		/**
		 * Return the heap as a sorted array list, by repeated polling. This
		 * will empty the heap!
		 * 
		 * @return new array list
		 */
		public ArrayList<E> toSortedArrayList() {
			ArrayList<E> ret = new ArrayList<E>(size());
			while (!isEmpty()) {
				ret.add(poll());
			}
			return ret;
		}
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		int N = in.nextInt();
		int M = in.nextInt();

		Graph g = new Graph(N);

		for (int i = 0; i < M; i++) {
			Integer A = in.nextInt();
			Integer B = in.nextInt();
			Integer weight = 2;
			int C = in.nextInt();
			if (C == 0) {
				weight = 1;
			} else {
				weight = 2 << C - 1;
			}
			g.addEdge(A, B, weight);
			g.addEdge(B, A, weight);
		}
		in.close();

		long sum = 0;
//		Integer[] allVertices = g.allVertices();
		for(int v=1;v<=g.getNumberOfVertices();v++) {
			Dijkstra dij = new Dijkstra(g, v);
			dij.calculate();
			sum += dij.printAll();
		}
//		for (Integer v : allVertices) {
//			Dijkstra dij = new Dijkstra(g, v);
//			dij.calculate();
//			sum += dij.printAll();
//		}
		System.out.println(Long.toBinaryString(sum));
		
		in.close();
	}

}
