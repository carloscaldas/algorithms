package com.carloscaldas.algorithms.datastructure;

public class MergeSort2 {

	private int[] numbers;
	private int[] helper;

	private int number;
	
	private void merge(int low, int middle, int high) {
		for (int i = low; i <= high; i++) {
			helper[i] = numbers[i];
		}

		int i = low;
		int j = middle + 1;
		int k = low;
		// Copy the smallest values from either the left or the right side back
		// to the original array
		while (i <= middle && j <= high) {
			if (helper[i] <= helper[j]) {
				numbers[k] = helper[i];
				i++;
			} else {
				numbers[k] = helper[j];
				j++;
			}
			k++;
		}
		// Copy the rest of the left side of the array into the target array
		while (i <= middle) {
			numbers[k] = helper[i];
			k++;
			i++;
		}

	}

	  private void mergesort(int low, int high) {
		    // check if low is smaller then high, if not then the array is sorted
		    if (low < high) {
		      int middle = low + (high - low) / 2;
		      mergesort(low, middle);
		      mergesort(middle + 1, high);
		      merge(low, middle, high);
		    }
		  }
	  
	public void sort(int[] values) {
		this.numbers = values;
		number = values.length;
		this.helper = new int[number];
		mergesort(0, number - 1);
	}

	public static void main(String[] args) {
		MergeSort2 msort = new MergeSort2();
		int[] arr = new int[] { 16, 34, 55, 12, 36, 54 };
		msort.sort(arr);
		//msort.merge(0, 3, 5);
	}
}
