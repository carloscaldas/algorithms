import java.util.*;

public class Solution {

	private int[] A;
	private int[] B;
	private int[] C;
	private int AH;
	private int BH;
	private int CH;

	public Solution(int[] A, int AH, int B[], int BH, int[] C, int CH) {
		this.A = A;
		this.AH = AH;
		this.B = B;
		this.BH = BH;
		this.C = C;
		this.CH = CH;
	}
	
	public int findMaximumHeight() {
		int a = 0, b = 0, c = 0;
		while ((AH != BH) || (AH != CH) || (BH != CH)) {
			if (AH > BH)
				AH -= A[a++];
			if (AH > CH)
				AH -= A[a++];
			if (BH > AH)
				BH -= B[b++];
			if (BH > CH)
				BH -= B[b++];
			if (CH > AH)
				CH -= C[c++];
			if (CH > BH)
				CH -= C[c++];
		}
		return AH;
	}
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int[] A = new int[in.nextInt()];
		int[] B = new int[in.nextInt()];
		int[] C = new int[in.nextInt()];
		
		int AH = fillStackAndReturnHeight(in, A);
		int BH = fillStackAndReturnHeight(in, B);
		int CH = fillStackAndReturnHeight(in, C);

		Solution S = new Solution(A, AH, B, BH, C, CH);
		int result = S.findMaximumHeight();

		System.out.println(result);
		
		in.close();
	}

	private static int fillStackAndReturnHeight(Scanner in, int[] stack) {
		int height = 0;
		for (int i = 0; i < stack.length; i++) {
			int value = in.nextInt();
			stack[i] = value;
			height += value;
		}
		return height;
	}
}
