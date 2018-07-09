package tests;

import java.util.HashMap;
import java.util.Map;

public class FrogRiverOne {

	public static void main(String[] args) {
		int X = 5;
		int[] A = { 1, 3, 1, 4, 2, 3, 5, 4 };

		System.out.println(solution(X, A));
	}

	public static int solution(int X, int[] A) {
		int earliest_time = -1;
		Map<Integer, Integer> map = new HashMap<>();

		for (int i = 0; i < A.length; i++) {
			if (A[i] <= X) {
				Integer stored = map.putIfAbsent(A[i], i);
				if (null == stored && i > earliest_time) {
					earliest_time = i;
				}
			}
			if (map.size() == X) {
				break;
			}
		}

		if (map.size() != X) {
			earliest_time = -1;
		}

		return earliest_time;
	}

}
