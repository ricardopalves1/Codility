package tests;

import java.util.Arrays;

public class PermMissingElem {

	public static void main(String[] args) {
		// int[] A = { 2, 3, 1, 5 };
		int[] A = { 1 };
		System.out.println(solution(A));
	}

	public static int solution(int[] A) {
		Arrays.sort(A);

		int item = 1;
		if (Arrays.binarySearch(A, item) >= 0) {
			for (int i = 0; i < A.length; i++) {
				item = A[i];
				if (Arrays.binarySearch(A, ++item) < 0) {
					break;
				}
			}
		}

		return item;
	}
}
