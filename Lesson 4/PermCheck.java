package tests;

import java.util.Arrays;

public class PermCheck {

	public static void main(String[] args) {
		int[] A = { 4, 1, 3, 2 };
		System.out.println(solution(A));
	}

	public static int solution(int[] A) {
		int permutation = 1;

		Arrays.sort(A);
		int item = 1;
		for (int i = 0; i < A.length; i++) {
			int key = Arrays.binarySearch(A, item);

			if (key < 0) {
				// not found!
				permutation = 0;
			}

			item++;
		}

		return permutation;
	}

}
