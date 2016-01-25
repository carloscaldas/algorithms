package com.carloscaldas.algorithms.datastructure.sort;

import java.util.Arrays;

public enum QuickSortPartitionLogic {
	//, PIVOT_RANDOM(5)
	PIVOT_ON_LEFT(1), PIVOT_ON_RIGHT(2), PIVOT_ON_MIDDLE(3), PIVOT_ON_MEDIAN(4);

	private Integer type;

	QuickSortPartitionLogic(Integer type) {
		this.type = type;
	}

	private static void swap(Integer[] A, Integer x, Integer y) {
		Integer aux = A[x];
		A[x] = A[y];
		A[y] = aux;
	}

	public Integer partition(Integer[] A, Integer l, Integer r) {
		switch (type) {
		case 1:
			return partLeft(A, l, r);
		case 2:
			return partRight(A, l, r);
		case 3:
			return partHalf(A, l, r);
		case 4:
			return partMedian(A, l, r);
		}
		return r;
	}

	private static Integer partLeft(Integer[] A, Integer l, Integer r) {
		Integer p = A[l];
		Integer i = l + 1;
		for (int j = l + 1; j <= r; j++) {
			if (A[j] < p) {
				swap(A, i, j);
				i++;
			}
		}
		swap(A, l, i - 1);
		return i - 1;
	}

	/*
	private static Integer partRight(Integer[] A, Integer l, Integer r) {
		Integer x = A[r];
		Integer i = l;
		for (Integer j = l; j <= r - 1; j++) {
			if (A[j] <= x) {
				swap(A, i, j);
				i++;
			}
		}
		swap(A, i + 1, r);
		return i + 1;
	}
	*/
	private static Integer partRight(Integer[] A, Integer l, Integer r) {
		swap(A, l, r);
		return partLeft(A, l, r);
		//return null;
	}
	
	public static int median(Integer[] A, Integer l, Integer r) {
		if (A.length <= 1) {
			return l;
		}
		else if (A.length == 2) {
			return A[l] <= A[r] ? l : r;
		}
		else {
			Integer[] all = new Integer[3];
			
			int half = (l+r)/2;
			all = new Integer[]{A[l], A[half], A[r]};
			Arrays.sort(all);
			
			if (all[1] == A[r]) {
				return r;
			}
			else if (all[1] == A[l]) {
				return l;
			}
			else {
				return half;
			}
		}
	}
	
	private static Integer partMedian(Integer[] A, Integer l, Integer r) {
		Integer m = median(A, l, r);
		swap(A, l, m);
		return partLeft(A, l, r);
	}
	
	
	private static Integer partHalf(Integer[] A, Integer l, Integer r) {
		Integer value = A[(r-l+1)/2]; 
		int i = l, j = r;
		
		while (i<j) {
			if (A[i]<value){
				i++;
			}
			else if (A[j] > value) {
				j--;
			}
			else {
				swap(A, i, j);
				i++;
				j--;
			}
		}
		return j;
	}

	
}
