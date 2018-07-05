package tests;

public class FrogJmp {

	public static void main(String[] args) {
		int X = 10;
		int Y = 90;
		int D = 30;

		System.out.println(solution(X, Y, D));
	}

	public static int solution(int X, int Y, int D) {
		int counter = 0;

		// Y - X is actually the distance we need to jump!
		int remainder = (Y - X) % D;
		if (remainder == 0) {
			counter = (Y - X) / D;
		} else {
			counter = (Y - X) / D + 1;
		}
		return counter;
	}
}
