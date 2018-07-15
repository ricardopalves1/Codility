package tests;

import java.util.Arrays;

public class MaxProductOfThree {

	public static void main(String[] args) {
		// int[] A = { -3, 1, 2, -2, 5, 6 };
		// int[] A = { -10, -2, -4 }; // expected -80
		// int[] A = { -5, -6, -4, -7, -10 }; // expected -120
		int[] A = { -5, 5, -5, 4 }; // expected 125

		System.out.println(solution(A));
	}

	public static int solution(int[] A) {
		Arrays.sort(A);
		int maximum = 0;

		int P = A[A.length - 3];
		int Q = A[A.length - 2];
		int R = A[A.length - 1];
		int maximumRight = P * Q * R;

		P = A[0];
		Q = A[1];
		R = A[A.length - 1];
		int maximumLeft = P * Q * R;

		if (maximumRight > maximumLeft) {
			maximum = maximumRight;
		} else {
			maximum = maximumLeft;
		}

		return maximum;
	}
}
