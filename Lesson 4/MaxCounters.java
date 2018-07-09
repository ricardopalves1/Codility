package tests;

import java.util.Arrays;

public class MaxCounters {

	public static void main(String[] args) {
		int N = 5;
		int[] A = { 3, 4, 4, 6, 1, 4, 4 };
		// int[] A = { 6, 6, 6, 6, 6, 6 };

		int[] results = solution(N, A);
		System.out.println(Arrays.toString(results));
	}

	public static int[] solution(int N, int[] A) {
		int[] counters = new int[N];

		int counter = 0;
		int index = 0;
		int x = 0;
		int max_counter = 0;
		int maximum = 0;

		for (int k = 0; k < A.length; k++) {
			x = A[k];
			if (x <= N) {
				index = A[k] - 1;
				counter = counters[index];
				if (counter < max_counter) {
					counter = max_counter;
				}
				if (++counter > maximum) {
					maximum = counter;
				}
				counters[index] = counter;

			} else {
				// Arrays.fill(counters, maximum);
				// System.arraycopy(zeroedArray, 0, counters, 0, zeroedArray.length);
				// max_counter = Arrays.stream(counters).max().getAsInt();
				max_counter = maximum;
			}
		}

		for (int i = 0; i < counters.length; i++) {
			if (counters[i] < max_counter) {
				counters[i] = max_counter;
			}
		}

		return counters;
	}

}
