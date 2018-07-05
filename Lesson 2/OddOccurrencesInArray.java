package tests;

import java.util.HashSet;
import java.util.Set;

public class OddOccurrencesInArray {

	public static void main(String[] args) {
		int[] A = { 9, 3, 9, 3, 9, 7, 9 };

		System.out.println(solution(A));
	}

	public static int solution(int[] A) {
		Set<Integer> keys = new HashSet<>();

		for (int i = 0; i < A.length; i++) {
			if (keys.contains(A[i])) {
				keys.remove(A[i]);

			} else {
				keys.add(A[i]);
			}
		}

		return keys.stream().findFirst().get();
	}

}
