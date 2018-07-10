package tests;

public class PassingCars {

	public static void main(String[] args) {
		// int[] A = { 0, 1, 0, 1, 1 }; // 5
		int[] A = { 0, 0, 1, 0, 1, 0, 1, 1 }; // 13
		System.out.println(solution(A));
	}

	public static int solution(int[] A) {
		int total = 0;
		int count_ones = 0;
		int previous = 0;

		// [0, 1, 0, 1, 1]
		// (0)*(01{1,}){1}
		// String value = Arrays.toString(A).replaceAll("\\[|\\]|,|\\s", "");

		for (int i = (A.length - 1); i >= 0; i--) {
			if (A[i] == 1) {
				count_ones++;

			} else {
				count_ones = previous + count_ones;
				total += count_ones;
				previous = count_ones;
				count_ones = 0;
			}

			if (total > 1000000000) {
				total = -1;
				break;
			}
		}

		return total;
	}

}
