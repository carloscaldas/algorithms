package com.carloscaldas.algorithms.datastructure.sort;

public final class InsertionSort<T extends Comparable<T>> {
	
	private final T[] result;
	
	public InsertionSort(T[] arr) {
		this.result = arr;
	}
	
	public void sort() {
		if (result.length>1) {
			for (int i=1;i<result.length;i++) {
				int j = i;
				while (j > 0 && (result[j].compareTo(result[j-1])<0)) {
					swap(j, j-1);
					j--;
				}
			}
		}
	}
	
	private void swap(int i, int j) {
		T tmp = result[i];
		result[i] = result[j];
		result[j] = tmp;
	}
	
	public void print() {
		for (T e : result) {
			System.out.print(e + " ");
		}
		System.out.println();
	}
}
