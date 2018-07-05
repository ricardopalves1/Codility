package tests;

import java.util.Arrays;

public class TapeEquilibrium {

	public static void main(String[] args) {
		int[] A = { 3, 1, 2, 4, 3 };
		// int[] A = { -1000, 1000 };
		System.out.println(solution(A));
	}

	public static int solution(int[] A) {
		int min = 0;

		int tot_left = 0;
		int tot_right = Arrays.stream(A).sum();
		int diff = 0;

		for (int k = 0; k < A.length - 1; k++) {
			tot_left += A[k];
			tot_right -= A[k];

			diff = Math.abs(tot_left - tot_right);
			if (k == 0) {
				min = diff;

			} else if (diff < min) {
				min = diff;
			}
		}

		return min;
	}
}
