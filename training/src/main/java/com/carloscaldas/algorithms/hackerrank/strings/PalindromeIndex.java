package com.carloscaldas.algorithms.hackerrank.strings;

//Perfect
//https://www.hackerrank.com/challenges/palindrome-index
public class PalindromeIndex {

	// it must have a valid input (with possible solution)
	public static int getMismatchIndex(String str) {
		int result = -1;

		int left = 0;
		int right = str.length() - 1;
		boolean mismatchFound = false;
		boolean problemLeft = false;
		boolean problemRight = false;

		while (left <= right) {
			if (mismatchFound) {
				// current on left equals previous right. Problem is on previous
				// left
				if (str.charAt(left) == str.charAt(right + 1)) {
					problemLeft = true;
					result = left - 1;
				}
				// current on right equals previous on left. Problem is on
				// previous right
				if (str.charAt(right) == str.charAt(left - 1)) {
					problemRight = true;
					result = right + 1;
				}

				// look ahead
				if (problemLeft && problemRight) {
					if (str.charAt(left) == str.charAt(right - 1)) {
						result = right + 1;
					} else {
						result = left - 1;
					}
				}
				break;
			}
			if (str.charAt(left) != str.charAt(right)) {
				mismatchFound = true;
				
				if(left+1 == right) {
					result = left;
				}
			}

			left++; right--;
		}


		return result;
	}

	public static void main(String[] args) {
		

	}

}
