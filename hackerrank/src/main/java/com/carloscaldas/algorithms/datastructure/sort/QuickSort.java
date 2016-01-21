package com.carloscaldas.algorithms.datastructure.sort;

public class QuickSort {
	private final Integer[] V;
	private final QuickSortPartitionLogic logic;
	private Integer comparisons;

	public QuickSort(Integer[] V, QuickSortPartitionLogic logic) {
		this.V = V;
		this.logic = logic;
		this.comparisons = 0;
	}

	public void sort() {
		comparisons = 0;
		sort(this.V, 0, this.V.length - 1);
	}

	private void sort(Integer[] V, Integer l, Integer r) {
		if (l < r) {
			comparisons += r-l;

			Integer partition = logic.partition(V, l, r);
			sort(V, l, partition - 1);
			sort(V, partition + 1, r);
		}
	}

	public Integer getComparisons() {
		return this.comparisons;
	}

	public void printArray() {
		for (int i = 0; i < V.length; i++) {
			System.out.print(V[i]);
			if (i < V.length) {
				System.out.print("\t");
			}
			if ((i + 1 >= 20) && ((i + 1) % 20 == 0)) {
				System.out.println();
			}
		}
		System.out.println();
	}
}
