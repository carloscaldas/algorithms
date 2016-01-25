package com.carloscaldas.algorithms.datastructure.tree;

public interface Tree<T> {
	
	
	// O (log n)
	public T search(T value);

	// O (log n)
	//Select the Nth smallest position
	public T select(long rankPosition);
	
	// O (log n)
	public T min();
	
	// O (log n)
	public T max();
	
	// O (log n)
	//# of keys less than or equal to a given value
	public long calculateRank(T value);
	
	//O (n)
	public void traverseSorted();//
	
	public void insert();
	public void delete();
}
