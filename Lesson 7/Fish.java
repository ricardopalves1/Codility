package tests;

import java.util.ArrayDeque;
import java.util.Deque;

public class Fish {

	Deque<VoraciousFish> fishes = new ArrayDeque<>(); // Time complexity: O(N)
	// List<VoraciousFish> fishes = new LinkedList<>(); Time complexity: O(N ** 2)
	// List<VoraciousFish> fishes = new ArrayList<>(); Time complexity: O(N ** 2)
	// Set<VoraciousFish> fishes = new TreeSet<>(); Demands a Comparable...

	public static void main(String[] args) {
		int[] A = { 4, 3, 2, 1, 5 }; // sizes of the fish.
		int[] B = { 0, 1, 0, 0, 0 }; // contains the directions of the fish. 0_downstream / 1_upstream

		System.out.println("=" + new Fish().solution(A, B));
	}

	public int solution(int[] A, int[] B) {
		boolean clashed = false;
		for (int i = 0; i < B.length; i++) {
			fishes.add(new VoraciousFish(A[i], B[i])); // adds an element to the tail.

			clashed = haveClashed();
			while (clashed) {
				clashed = haveClashed();
			}
		}

		return fishes.size();
	}

	private boolean haveClashed() {
		boolean clashed = false;
		VoraciousFish P = null;
		VoraciousFish Q = null;
		if (fishes.size() >= 2) {
			// we gotta have at least 2 fishes to compare.
			Q = fishes.pollLast();
			P = fishes.getLast();

			if (P.getDirection() == 1 && Q.getDirection() == 0) {
				if (P.getSize() < Q.getSize()) {
					fishes.pollLast();
					// remove P first!
					fishes.add(Q);
				}
				clashed = true;

			} else {
				// put it back then!
				fishes.add(Q);
			}
		}

		return clashed;
	}

	class VoraciousFish {
		private int size;
		private int direction;

		VoraciousFish(int size, int direction) {
			this.size = size;
			this.direction = direction;
		}

		public int getSize() {
			return size;
		}

		public void setSize(int size) {
			this.size = size;
		}

		public int getDirection() {
			return direction;
		}

		public void setDirection(int direction) {
			this.direction = direction;
		}
	}

}
