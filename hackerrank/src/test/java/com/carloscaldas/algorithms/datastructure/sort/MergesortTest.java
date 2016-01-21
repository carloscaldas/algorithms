package com.carloscaldas.algorithms.datastructure.sort;

import com.carloscaldas.algorithms.datastructure.sort.MergeSort;

public class MergesortTest {

	public static void main(String[] args) {
		String[] arr = new String[] {"bola","casa", "arroz"};
		MergeSort<String> ms = new MergeSort<String>(arr);
		ms.print();
		ms.sort();
		ms.print();
	}
}
