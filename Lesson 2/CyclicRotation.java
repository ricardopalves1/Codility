package tests;

import java.util.Arrays;
import java.util.stream.IntStream;

public class CyclicRotation {

	public static void main(String[] args) {
		int[] A = { 3, 8, 9, 7, 6 };
		int K = 3;

		int[] result = solution(A, K);

		System.out.println(Arrays.toString(result));
	}

	public static int[] solution(int[] A, int K) {
		int[] numbers = A;

		int[] partA = null;
		int[] partB = null;

		if (A.length != K && A.length > 0) {
			// We need to employ right shifting!
			for (int i = 0; i < K; i++) {
				partA = Arrays.copyOf(numbers, numbers.length - 1);
				partB = Arrays.copyOfRange(numbers, numbers.length - 1, numbers.length);

				IntStream stream_concat = IntStream.concat(Arrays.stream(partB), Arrays.stream(partA));
				numbers = stream_concat.toArray();
			}
		}

		return numbers;
	}

}
