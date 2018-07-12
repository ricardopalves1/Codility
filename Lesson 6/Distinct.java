package tests;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class Distinct {

	public static void main(String[] args) {
		int[] A = { 2, 1, 1, 2, 3, 1 };
		System.out.println(solution(A));
	}

	public static int solution(int[] A) {
		Arrays.sort(A);
		Set<Integer> hashSet = Arrays.stream(A).boxed().collect(Collectors.toSet());

		return hashSet.size();
	}
}
