package tests;

import java.util.Arrays;

public class MissingInteger {

	public static void main(String[] args) {
		int[] A = { 1, 3, 6, 4, 1, 2 };
		// int[] A = { 1, 2, 3 };

		System.out.println(solution(A));
	}

	public static int solution(int[] A) {
		int smallest = 1;

		Arrays.sort(A);
		for (int i = 0; i < A.length; i++) {
			if (Arrays.binarySearch(A, smallest) < 0) {
				break;
			}
			smallest++;
		}

		return smallest;
	}

}
