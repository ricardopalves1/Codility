package tests;

import java.util.ArrayDeque;
import java.util.Deque;

public class Nesting {

	public static void main(String[] args) {
		String S = "(()(())())";
		// String S = "())";
		System.out.println(solution(S));
	}

	public static int solution(String S) {
		int nested = 1;

		if (S.isEmpty()) {
			return nested;
		}

		if (!S.contains("(") && !S.contains(")")) {
			return nested;
		}

		Deque<String> stack = new ArrayDeque<>();
		char[] chars = S.toCharArray();
		String head = "";
		for (char ch : chars) {
			if (!Character.isLetterOrDigit(ch)) {
				String ch_string = String.valueOf(ch);
				if (ch_string.equals("(")) {
					stack.push(ch_string);

				} else if (ch_string.equals(")")) {
					head = stack.peek();
					if (head != null && head.equals("(")) {
						stack.pop();
					} else {
						stack.push(ch_string);
					}
				}
			}
		}

		if (!stack.isEmpty()) {
			nested = 0;
		}

		return nested;
	}
}
