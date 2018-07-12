package tests;

public class MinAvgTwoSlice {

	public static void main(String[] args) {
		// int[] A = { 4, 2, 2, 5, 1, 5, 8 }; // expected 1
		// int[] A = { 5, 6, 3, 4, 9 }; // expected 2
		// int[] A = { -3, -5, -8, -4, -10 }; // expected 2
		int[] A = { 10, 10, -1, 2, 4, -1, 2, -1 }; // expected 5

		System.out.println(solution(A));
	}

	/**
	 * This is a mathematical problem... and to solve it you have to understand the
	 * relationship that exists between the averages of the slices. We know from the
	 * problem description that the slices are a minimum length of 2. The trick to
	 * this problem is that the min average slice also cannot be longer than 3. So
	 * we only have to calculate the avg of the slices of length 2 and 3.
	 * 
	 * @param A
	 * @return
	 */
	public static int solution(int[] A) {
		int index = 0;
		float minimal_avg = 0;
		float avg = 0;

		for (int i = 0; i < (A.length - 1); i++) {
			if (i == 0) {
				minimal_avg = (float) (A[index + 1] + A[index]) / 2;
			}

			int temp = 0;
			int count = 0;

			for (int j = i + 1; j < A.length; j++) {
				if (count > 1) {
					break;
				}
				avg = (float) (A[j] + temp + A[i]) / (2 + count);
				if (avg < minimal_avg) {
					minimal_avg = avg;
					index = i;
				}
				temp += A[j];
				count++;
			}
		}

		return index;
	}

}