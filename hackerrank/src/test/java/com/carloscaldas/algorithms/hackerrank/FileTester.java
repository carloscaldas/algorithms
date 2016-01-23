package com.carloscaldas.algorithms.hackerrank;

import java.io.File;

public class FileTester {
	protected static File getResourceFile(Class<?> C, String name) {
		ClassLoader classLoader = C.getClassLoader();
		return new File(classLoader.getResource(name).getFile());
	}



}
