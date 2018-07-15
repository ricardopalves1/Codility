package tests;

import java.util.Arrays;

public class Triangle {

	public static void main(String[] args) {
		// int[] A = { 10, 2, 5, 1, 8, 20 }; // expected 1
		// int[] A = { 10, 50, 5, 1 }; // expected 0
		// int[] A = { 5, 3, 3 }; // expected 1

		int[] A = { 2147483647, 2147483647, 2147483647 }; // expected 1
		System.out.println(solution(A));
	}

	public static int solution(int[] A) {
		int found = 0;
		if (A.length < 3 || A.length > 100000) {
			// none available possibilities.
			return found;
		}

		Arrays.sort(A);
		int P = 0;
		int Q = 0;
		int R = 0;
		long sum1 = 0;
		long sum2 = 0;
		long sum3 = 0;

		for (int i = 0; i < (A.length - 2); i++) {
			P = A[i];
			Q = A[i + 1];
			R = A[i + 2];
			sum1 = (long) P + (long) Q;
			sum2 = (long) Q + (long) R;
			sum3 = (long) R + (long) P;

			if ((sum1 > R) && (sum2 > P) && (sum3 > Q)) {
				found = 1;
				break;
			}
		}

		return found;
	}

}
