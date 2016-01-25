package com.carloscaldas.algorithms.datastructure.sort;

public class InsertionSortTest {
	public static void main(String[] args) {
		String[] arr = new String[] {"bola","casa", "arroz"};
		InsertionSort<String> ms = new InsertionSort<String>(arr);
		ms.print();
		ms.sort();
		ms.print();
	}
}
