package com.carloscaldas.algorithms.datastructure.sort;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class QuickSortTest {

	private static File inputFile() throws URISyntaxException {
		return new File(QuickSort.class.getResource("/Quicksort.txt").toURI());
	}

	private static void fill(File file, List<Integer> v, int max)
			throws FileNotFoundException {
		int count = 0;
		Scanner sc = new Scanner(file);
		while (sc.hasNextInt() && (count < max)) {
			int x = Integer.parseInt(sc.nextLine());
			v.add(x);
			count++;
		}
		sc.reset();
		sc.close();
	}

	
	private static void executeOnLeft() throws URISyntaxException, FileNotFoundException {
		File file = inputFile();
		List<Integer> lista = new ArrayList<Integer>();
		fill(file, lista, 10000);
		
		Integer[] vet = lista.toArray(new Integer[lista.size()]);
		QuickSort qs = new QuickSort(vet, QuickSortPartitionLogic.PIVOT_ON_LEFT);
		qs.sort();
		System.out.printf("Numero de comparacoes ONLEFT:[%d]\n", qs.getComparisons());
		//qs.printArray();
	}

	private static void executeOnRight() throws URISyntaxException, FileNotFoundException {
		File file = inputFile();
		List<Integer> lista = new ArrayList<Integer>();
		fill(file, lista, 10000);
		
		Integer[] vet = lista.toArray(new Integer[lista.size()]);
		QuickSort qs = new QuickSort(vet, QuickSortPartitionLogic.PIVOT_ON_RIGHT);
		qs.sort();
		System.out.printf("Numero de comparacoes ONRIGHT:[%d]\n", qs.getComparisons());
		//qs.printArray();
	}
	
	private static void executeOnMedian() throws URISyntaxException, FileNotFoundException {
		File file = inputFile();
		List<Integer> lista = new ArrayList<Integer>();
		fill(file, lista, 10000);
		
		Integer[] vet = lista.toArray(new Integer[lista.size()]);
		QuickSort qs = new QuickSort(vet, QuickSortPartitionLogic.PIVOT_ON_MEDIAN);
		qs.sort();
		System.out.printf("Numero de comparacoes ONMEDIAN:[%d]\n", qs.getComparisons());
		//qs.printArray();
	}

	public static void main(String[] args) throws FileNotFoundException, URISyntaxException {
		executeOnLeft();
		executeOnRight();
		executeOnMedian();
	}


}
