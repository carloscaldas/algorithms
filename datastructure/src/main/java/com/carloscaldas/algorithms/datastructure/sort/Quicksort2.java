package com.carloscaldas.algorithms.datastructure.sort;

import org.junit.Test;

public class Quicksort2<T extends Comparable<T>> {
	boolean pivotOnLeft = true;

	public void sort(T[] A, int left, int right) {
		if (right - left > 0) {
			int p = partition(A, left, right);
			sort(A, left, p - 1);
			sort(A, p + 1, right);
		}
	}

	public int partition(T[] A, int left, int right) {
		int pivotPosition = choosePivot(left, right);
		T pivotValue = A[pivotPosition];
		int i = left; // all left values are smaller than the PivotValue
		for (int j = left+1; j <= right; j++) {
			if (j != pivotPosition) {
				if (A[j].compareTo(pivotValue) < 0) {
					i++;
					swap(A, i, j);
				}
			}
		}
		swap(A, pivotPosition, i);
		return i;
	}

	private void swap(T[] A, int p1, int p2) {
		if (p1 != p2) {
			T tmp = A[p1];
			A[p1] = A[p2];
			A[p2] = tmp;
			print(A);
		}
	}

	private int choosePivot(int left, int right) {
		int result = pivotOnLeft ? left : right;
		//result = (right + left)/2;
		//result = right;
//		pivotOnLeft = !pivotOnLeft;
		return result;
	}

	public static void main(String[] args) {
		// qsort.partition(A, 0, A.length - 1);
	}

	public static <T> void print(T[] A) {
		for (T t : A) {
			System.out.print(t + " ");
		}
		System.out.println();
	}

	@Test
	public void test01() {
		Integer[] A = new Integer[] { 3, 2, 8, 5, 1, 4, 7, 6 };
		Quicksort2<Integer> qsort = new Quicksort2<Integer>();
		qsort.sort(A, 0, A.length - 1);
	}
	
	@Test
	public void test02() {
		Integer[] A = new Integer[] { 3 };
		Quicksort2<Integer> qsort = new Quicksort2<Integer>();
		qsort.sort(A, 0, A.length - 1);
	}

	@Test
	public void test03() {
		Integer[] A = new Integer[] { 6, 3 };
		Quicksort2<Integer> qsort = new Quicksort2<Integer>();
		qsort.sort(A, 0, A.length - 1);
	}

	@Test
	public void test04() {
		Integer[] A = new Integer[] { 1, 3 };
		Quicksort2<Integer> qsort = new Quicksort2<Integer>();
		qsort.sort(A, 0, A.length - 1);
	}

	@Test
	public void test05() {
		Integer[] A = new Integer[] { 1, 0, 3 };
		Quicksort2<Integer> qsort = new Quicksort2<Integer>();
		qsort.sort(A, 0, A.length - 1);
	}

	@Test
	public void test06() {
		Integer[] A = new Integer[] { 5, 1, 0, 3 };
		Quicksort2<Integer> qsort = new Quicksort2<Integer>();
		qsort.sort(A, 0, A.length - 1);
	}

}
