package com.carloscaldas.algorithms.datastructure.sort;

public class MergeSort<T extends Comparable<T>> {
	private final T[] result;
	private final T[] tmp;

	@SuppressWarnings("unchecked")
	public MergeSort(T[] arr) {
		this.result = arr;
		this.tmp = (T[])new Comparable[arr.length];
	}

	public void sort() {
		sort(0, result.length - 1);
	}

	private void sort(int left, int right) {
		if (left < right) {
			int middle = (right + left) / 2;
			sort(left, middle); // middle is all inclusive to the left side
			sort(middle + 1, right);
			merge(left, middle, right);
		}
	}

	private void merge(int leftStart, int leftEnd, int rightEnd) {
		int leftIndex = leftStart;
		int rightIndex = leftEnd+1;
		int indexMerge = leftStart;
		while (leftIndex<=leftEnd && rightIndex <= rightEnd) {
			if (result[leftIndex].compareTo(result[rightIndex]) <= 0) {
				tmp[indexMerge] = result[leftIndex];
				leftIndex++;
			}
			else {
				tmp[indexMerge] = result[rightIndex];
				rightIndex++;
			}
			indexMerge++;
		}

		//copy the remaining values from both halves
		System.arraycopy(result, rightIndex, tmp, indexMerge, rightEnd - rightIndex + 1);
		System.arraycopy(result, leftIndex, tmp, indexMerge, leftEnd - leftIndex + 1);

		System.arraycopy(tmp, leftStart, result, leftStart, rightEnd-leftStart+1);
	}

	public void print() {
		for (T e : result) {
			System.out.print(e + " ");
		}
		System.out.println();
	}

}
