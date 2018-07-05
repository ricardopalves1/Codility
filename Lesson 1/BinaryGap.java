package tests;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BinaryGap {

	public static void main(String[] args) {
		int n = 15;
		System.out.println(BinaryGap.solution(n));
	}

	public static int solution(int N) {
		int result = 0;
		String bin_value = Integer.toBinaryString(N);

		int threshold = bin_value.length() - 2;
		String regex = "10{1,}1";
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(bin_value);

		if (m.find()) {
			// It has at least 1 gap!

			for (int i = threshold; i > 0; i--) {
				// 10{n}1
				regex = "10{" + i + "}1";
				p = Pattern.compile(regex);
				m = p.matcher(bin_value);

				if (m.find()) {
					// We found the biggest gap!
					result = i;
					break;
				}
			}
		}

		return result;
	}

}
