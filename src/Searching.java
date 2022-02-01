import java.util.Optional;

public class Searching {
	
	public static void main(String[] args) {
		int[] a = { 1, 2, 3, 4, 5, 6, 7 };
		System.out.println(binarySearch(a, 8));
		System.out.println(linearSearch(a, 7));
		System.out.println(interpolationSearch(a, 1));
	}

	// Returns the index of value `x` in the sorted array `a` (if it exists).
	// This algorithm runs in O(log n).
	public static Optional<Integer> binarySearch(int[] a, int x) {
		int lower = 0;
		int upper = a.length - 1;
		
		while (lower <= upper) {
			int middle = (lower + upper) / 2;
			if (a[middle] == x) {
				return Optional.of(middle);
			} else if (x < a[middle]) {
				upper = middle - 1;
			} else {
				lower = middle + 1;
			}
		}
		
		return Optional.empty();
	}
	
	// Returns the index of value `x` in the sorted array `a` (if it exists).
	// This algorithm runs in O(log log n) if `a` is uniformly distributed; otherwise it runs in O(n).
	public static Optional<Integer> interpolationSearch(int[] a, int x) {
		int lower = 0;
		int upper = a.length - 1;
		
		while (lower <= upper) {
			int guess = lower + ((x - a[lower]) / (a[upper] - a[lower])) * (upper - lower);
			if (a[guess] == x) {
				return Optional.of(guess);
			} else if (x < a[guess]) {
				upper = guess - 1;
			} else {
				lower = guess + 1;
			}
		}
		
		return Optional.empty();
	}
	
	// Return the index of value `x` in the array `a` (if it exists).
	// This algorithm runs in O(n)
	public static Optional<Integer> linearSearch(int[] a, int x) {
		for (int i = 0; i < a.length; i++) {
			if (a[i] == x) {
				return Optional.of(i);
			}
		}
		return Optional.empty();
	}
	
}
