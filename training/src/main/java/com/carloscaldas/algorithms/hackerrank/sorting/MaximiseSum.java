package com.carloscaldas.algorithms.hackerrank.sorting;


import java.util.TreeSet;

public class MaximiseSum {

	private long M;
	private long[] arr;
	private long[] mod;
	private long max;

	public MaximiseSum(long[] arr, long M) {
		this.M = M;
		this.arr = arr;
		this.mod = new long[arr.length];
		this.mod[0] = arr[0] % M;
		max = 0;
		for (int i = 1; i < arr.length; i++) {
			mod[i] = (mod[i - 1] + arr[i]) % M;
			long temp = mod[i];
			for (int j = 0; j < i; j++) {
				temp = (temp - mod[j] + M) % M;
				if (temp > max) {
					max = temp;
				}
			}
		}
	}

	public long getValue() {
		return this.max;
	}

	public static long modulo(long[] v, long W) {
		long[] mod = new long[v.length];
		mod[0] = v[0] % W;
		for (int i = 1; i < v.length; i++) {
			mod[i] = (mod[i - 1] + v[i]) % W;
		}
		long max = 0;
		for (int i = 1; i <= v.length; i++) {
			for (int j = 0; j <= v.length - i; j++) {
				int p = j + i - 1;

				long temp;
				if (j - 1 >= 0) {
					temp = mod[p] - mod[j - 1];
				} else {
					temp = mod[p];
				}
				temp += W;
				temp = temp % W;

				if (temp > max) {
					max = temp;
				}
			}
		}
		return max;
	}

	public void updateTree(TreeSet<Long> values, int position) {
		System.out.println("Analisando posicao " + position);
		if (position == 0) {
			values.add(arr[position] % M);
		} else {
			long sum = mod[position];
			for (int i = 0; i < position; i++) {
				sum = (sum - mod[i] + M) % M;
				values.add(sum);
			}
			updateTree(values, position - 1);
		}
	}

	public static long modulo2(long[] A, long M) {
		long minValue = Long.MAX_VALUE;
		long[] sum = new long[A.length];
		sum[0] = A[0];
		for (int i = 1; i < A.length; i++) {
			sum[i] = (sum[i - 1] + A[i]);

			if (A[i] < minValue) {
				minValue = A[i];
			}
		}
		long max = 0;
		for (int span = 1; span <= A.length; span++) {
			for (int j = 0; j <= A.length - span; j++) {
				int indexJ = j - 1;
				int p = indexJ + span;

				long temp;
				if (indexJ > -1) {
					temp = sum[p] - sum[indexJ];
				} else {
					temp = sum[p];
				}

				temp = temp % M;

				if (temp > max) {
					max = temp;
				}
			}
		}
		return max;
	}
	
	static class Element implements Comparable<Element> {
		private Long value;
		private int position;
		
		public Long getValue() {
			return this.getValue();
		}
		
		@Override
		public int hashCode() {
			return this.value.hashCode();
		}
		
		@Override
		public boolean equals(Object o) {
			if (o == null)
				return false;

			if (o instanceof Element == false)
				return false;

			Element other = (Element) o;
			return other.getValue().equals(this.getValue());
		}
		
		public Element(Long value, int position) {
			this.value = value;
			this.position = position;
		}

		public int compareTo(Element arg0) {
			return this.getValue().compareTo(arg0.getValue());
		}
	}

	public static long modulo3(long[] A, long M) {
		long max = 0;
		TreeSet<Element> tree = new TreeSet<Element>();
		long[] sum = new long[A.length];
		sum[0] = A[0] % M;
		tree.add(new Element(sum[0], 0));
		for (int i = 1; i < A.length; i++) {
			sum[i] = A[i] + sum[i - 1];
			sum[i] = sum[i] % M;
		}
/*
		for (int i = A.length - 1; i >= 0; i--) {
			tree.add(new Element(sum[i], i));
			Long a = (A[i] - sum[i] + M) % M;
			Element it = tree.lower(new Element(a, -1));
			if (it != null && it!=tree.first()) {
				Long tmp = sum[it.position-1];
				if (x != null) {
					max = Math.max(tree.higher(it) % M, max);
				}
			}
			max = Math.max(tree.higher(tree.last()) % M, max);
			*/
		return 0;
		

		/*
		 * 
		 * for (int span = 1; span <= A.length; span++) { for (int j = 0; j <=
		 * A.length - span; j++) { int indexJ = j-1; int p = indexJ + span;
		 * 
		 * long temp; if (indexJ > -1) { temp = sum[p] - sum[indexJ]; } else {
		 * temp = sum[p]; }
		 * 
		 * temp = temp % M;
		 * 
		 * if (temp > max) { max = temp; } } }
		 */
	}

	// OK
	public static long bruteForce(long[] A, long M) {
		int N = A.length;

		long maxSoma = A[0];
		long maxModule = 0;
		for (int span = 1; span < M && span <= A.length; span++) {
			int begin = 0;
			int end = begin + span - 1;

			while (end < N) {
				long sum = 0;
				for (int i = begin; i <= end; i++) {
					sum += A[i];
				}
				long module = sum % M;

				if (module > maxModule) {
					maxSoma = sum;
					maxModule = module;
					// System.out.printf("Soma:[%d]\tModulo:[%d]%n", maxSoma,
					// maxModule);
				}
				begin++;
				end++;
			}

		}
		return maxModule;
	}

	public static long calculatesBestContiguousSum(long[] arr, long M, TreeSet<Long> tree) {
		long maxSum = -Integer.MIN_VALUE;
		int maxLeft = 0;
		int maxRight = 0;
		long currentMax = 0;
		int left = 0;
		int right = 0;
		for (int i = 0; i < arr.length; i++) {
			currentMax += arr[i];
			if (currentMax > maxSum && maxSum < M) {
				maxSum = currentMax;
				right = i;
				maxLeft = left;
				maxRight = right;
			}
			if (currentMax > M) {
				currentMax = 0;
				left = i + 1;
				right = i + 1;
			}
		}

		/*
		 * int result = 0; for (int i=maxLeft;i<=maxRight;i++) { result +=
		 * arr[i]; }
		 */
		return maxSum;
	}

	public static long sum_mod(long[] A, long M) {
		long[] sum1 = new long[A.length];
		long[] sum2 = new long[A.length];

		TreeSet<Long> tree = new TreeSet<Long>();

		for (int index1 = 0; index1 < A.length; ++index1) {
			int index2 = A.length - index1 - 1;
			long a = (A[index1] + (index1 > 0 ? sum1[index1 - 1] : 0)) % M;
			long b = (A[index2] + (index2 < A.length - 1 ? sum2[index2 + 1] : 0)) % M;
			sum1[index1] = a;
			sum2[index2] = b;

			Long tmpA1 = tree.higher(sum1[index1]);
			if (tmpA1 != null) {
				tree.add(tmpA1);
				Long tmpA2 = (sum1[index1] - tmpA1 + M) % M;
				tree.add(tmpA2);
			}

			Long tmpB1 = tree.higher(sum2[index2]);
			if (tmpB1 != null) {
				tree.add(tmpB1);
				long tmpB2 = (sum2[index2] - tmpB1 + M) % M;
				tree.add(tmpB2);
			}

			tree.add(sum1[index1]);
			tree.add(sum2[index2]);
			tree.add(A[index1] % M);
		}
		long r1 = tree.lower(M);
		long r2 = calculatesBestContiguousSum(sum1, M, tree);
		long r3 = calculatesBestContiguousSum(sum2, M, tree);
		return Math.max(Math.max(r1, r2), r3);
	}

	public static long max_mod_sum(long[] A, int M) {
		long[] P = new long[A.length];

		for (int i = 0; i < A.length; ++i) {
			P[i] = (A[i] + (i > 0 ? P[i - 1] : 0)) % M;
		}

		TreeSet<Long> S = new TreeSet<Long>();
		long res = 0;
		for (int i = A.length - 1; i >= 0; --i) {
			S.add(P[i]);
			long a = (A[i] - P[i] + M) % M;
			Long it = S.lower(M - a);

			if (it != S.first()) {
				res = Math.max(res, S.lower(it) + a);
			}
			res = Math.max(res, S.lower(S.last()) + a) % M;
		}
		return res;
	}

	public static void main(String[] args) {
		TreeSet<Long> S = new TreeSet<Long>();
		S.add(5L);
		S.add(2L);
		S.add(1L);
		S.add(3L);

		System.out.println(S.first());

	}

}
