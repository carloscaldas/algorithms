import java.util.*;

public class Solution {

	private static class ValueInfo {
		private int minPosition;
		private int maxPosition;

		public ValueInfo(int position) {
			this.minPosition = position;
			setMaxPosition(position);
		}

		public void setMaxPosition(int maxPosition) {
			this.maxPosition = maxPosition;
		}

		public int getDistance() {
			return maxPosition - minPosition;
		}
	}

	private static int findMinimumDistance(int[] A) {
		int result = -1;
		int minimumDistance = A.length + 1;
		Map<Integer, ValueInfo> map = new HashMap<Integer, ValueInfo>(A.length);
		for (int i = 0; i < A.length; i++) {
			ValueInfo tmp = map.get(A[i]);
			if (tmp == null) {
				tmp = new ValueInfo(i);
				map.put(A[i], tmp);
			} else {
				tmp.setMaxPosition(i);
				if (tmp.getDistance() < minimumDistance) {
					minimumDistance = tmp.getDistance();
					result = minimumDistance;
				}
			}
		}
		return result;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int A[] = new int[n];
		for (int A_i = 0; A_i < n; A_i++) {
			A[A_i] = in.nextInt();
		}
		int result = findMinimumDistance(A);
		System.out.println(result);
	}
}