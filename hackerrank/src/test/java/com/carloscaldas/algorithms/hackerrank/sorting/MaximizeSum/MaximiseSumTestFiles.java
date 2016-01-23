package com.carloscaldas.algorithms.hackerrank.sorting.MaximizeSum;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.file.Files;
import java.util.Scanner;
import org.junit.Before;
import org.junit.Test;

import com.carloscaldas.algorithms.hackerrank.sorting.MaximiseSum;

import org.junit.Assert;

public class MaximiseSumTestFiles {

	PrintStream oldOutput;
	ByteArrayOutputStream currentBAOS;
	PrintStream currentPS;
	
	@Before
	public void setUp() throws Exception {
		this.oldOutput = System.out;
	    this.currentBAOS = new ByteArrayOutputStream();
	    this.currentPS = new PrintStream(this.currentBAOS, true, "UTF-8");
	    System.setOut(this.currentPS);
	}
	
	//@After
	public void tearDown() throws Exception {
	    System.setOut(oldOutput);
	}

	private File getResourceFile(String name) {
		String path = MaximiseSum.class.getPackage().getName().replace(".", "/") +"/" + name;
		ClassLoader classLoader = MaximiseSum.class.getClassLoader();
		return new File(classLoader.getResource(path).getFile()); 
	}

	private void processFile(String fileName) throws FileNotFoundException {
		File file = getResourceFile(fileName);
		Scanner in = new Scanner(file);
		int testCases = in.nextInt();

		for (int testCase = 0; testCase < testCases; testCase++) {
			int N = in.nextInt();
			long M = in.nextLong();

			long[] arr = new long[N];
			for (int i = 0; i < N; i++) {
				arr[i] = in.nextLong();
			}
			System.out.println(MaximiseSum.modulo3(arr, M));
		}
		in.close();
		System.out.flush();
		System.setOut(oldOutput);
	}
	
	
	private String readFile(File f) {
        //File f = new File(filename);
        try {
            byte[] bytes = Files.readAllBytes(f.toPath());
            return new String(bytes, "UTF-8");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
	}
	
	private String readCorrectOutput(String fileName) {
		return readFile(getResourceFile(fileName));
	}

	private Boolean compare(String s1, String s2) {
		long linha = 1;
		Scanner sc1 = new Scanner(s1);
		Scanner sc2 = new Scanner(s2);
		while (sc1.hasNextLine()) {
			if (sc2.hasNextLine() == false) {
				return false;
			}
			else {
				String line1 = sc1.nextLine();
				String line2 = sc2.nextLine();
				if (line1.equals(line2) == false) {
					System.out.printf("Linha %d diferente:%s\t%s%n", linha, line1, line2);
					return false;
				}
				else {
					System.out.printf("Linhas iguais:%s\t%s%n", line1, line2);
				}
				linha++;
			}
		}
		if (sc2.hasNextLine()) {
			return false;
		}
			
		sc1.close();
		sc2.close();
		
		return true;
	}
	
	//todo: remover o trim. tem que ser identico
	private void testFile(String testSuffix) throws FileNotFoundException {
		String inputFile = "input" + testSuffix + ".txt";
		String outputFile = "output"+ testSuffix + ".txt";
		processFile(inputFile);
		String resultProcessing = currentBAOS.toString().trim(); 
		String expected = readCorrectOutput(outputFile).trim();
		Boolean ok = compare(resultProcessing, expected);
		Assert.assertTrue(ok);
		//Assert.assertEquals(expected, resultProcessing);
	}
	
	@Test
	public void test() throws IOException {
		testFile("00");
	}

}
