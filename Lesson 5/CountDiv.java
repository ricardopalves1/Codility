package tests;

public class CountDiv {

	public static void main(String[] args) {
		// int A = 6;
		// int B = 6;
		// int K = 2;

		int A = 1;
		int B = 1;
		int K = 11;

		System.out.println(solution(A, B, K));
	}

	public static int solution(int A, int B, int K) {
		int countA = 0;
		if (A > 1) {
			// 2 slices to worry about.
			countA = (A - 1) / K;
		} else {
			countA = (A) / K;
		}

		int countB = (B) / K;
		int counter = countB - countA + ((A == 0) ? 1 : 0);

		if ((A == B) && (B == 0)) {
			// zero element counts.
			counter = 1;
		}

		if (K == 1) {
			// mod value does NOT count at all.
			counter = B - A + 1;
		}
		return counter;
	}

}
