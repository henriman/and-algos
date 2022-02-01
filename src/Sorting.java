import java.util.Arrays;

public class Sorting {
	
	public static void main(String[] args) {
		int[] a = { 5, 6, 2, 3, 1, 0, 4 };
		quickSort(a);
		System.out.println(Arrays.toString(a));
	}
	
	// Swap the values at index `i` and `j` in `a`.
	private static void swap(int[] a, int i, int j) {
		int tmp = a[i];
		a[i] = a[j];
		a[j] = tmp;
	}
	
	// Sort `a` in O(n^2).
	public static void bubbleSort(int[] a) {
		for (int r = 0; r < a.length - 1; r++) {
			for (int i = 0; i < a.length - 1; i++) {
				if (a[i] > a[i + 1]) {
					swap(a, i, i + 1);
				}
			}
		}
	}
	
	// Sort `a` in O(n^2).
	public static void selectionSort(int[] a) {
		for (int i = 0; i < a.length - 1; i++) {
			// Get minimum.
			int minIndex = i;
			for (int j = i + 1; j < a.length; j++) {
				if (a[j] < a[minIndex]) {
					minIndex = j;
				}
			}
			swap(a, minIndex, i);
		}
	}
	
	// Sort `a` in O(n^2).
	public static void insertionSort(int[] a) {
		for (int k = 1; k < a.length; k++) {
			int b = a[k];
			int j;
			for (j = k - 1; j >= 0 && a[j] > b; j--) {
				a[j + 1] = a[j];
			}
			a[j + 1] = b;
		}
	}
	
	// Sort `a` in O(n log n).
	// This implementation requires O(n) additional space, however.
	public static void heapSort(int[] a) {
		MaxHeap maxHeap = new MaxHeap(a);
		for (int i = a.length - 1; i >= 0; i--) {
			a[i] = maxHeap.extractMax();
		}
	}
	
	// Sort `a` in O(n log n), requiring O(n) additional space.
	public static void mergeSort(int[] a) {
		mergeSortHelper(a, 0, a.length - 1);
	}
	
	// Sort `a[left..right]`.
	private static void mergeSortHelper(int[] a, int left, int right) {
		if (left < right) {
			int middle = (left + right) / 2;
			mergeSortHelper(a, left, middle);
			mergeSortHelper(a, middle + 1, right);
			merge(a, left, middle, right);
		}
	}
	
	// Merge the two sub-arrays `a[left..middle]` and `a[middle+1..right]` in sorted order.
	private static void merge(int[] a, int left, int middle, int right) {
		int i = left;
		int j = middle + 1;
		int k = 0;
		int[] b = new int[right - left + 1];
		// Merge in sorted order.
		while (i <= middle && j <= right) {
			if (a[i] < a[j]) {
				b[k++] = a[i++];
			} else {
				b[k++] = a[j++];
			}
		}
		// Add remaining values to `b`.
		while (i <= middle) {
			b[k++] = a[i++];
		}
		while (j <= right) {
			b[k++] = a[j++];
		}
		// Copy `b` to `a`.
		for (int l = left; l <= right; l++) {
			a[l] = b[l - left];
		}
	}
	
	// Sort `a` in O(n^2). On average this should be O(n log n), however.
	public static void quickSort(int[] a) {
		quickSortHelper(a, 0, a.length - 1);
	}
	
	// Sort `a[left..right]`.
	private static void quickSortHelper(int[] a, int left, int right) {
		if (left < right) {
			int k = partition(a, left, right);
			quickSortHelper(a, left, k - 1);
			quickSortHelper(a, k + 1, right);
		}
	}
	
	private static int partition(int[] a, int left, int right) {
		int i = left;
		int j = right - 1;
		int p = a[right];
		System.out.println(p);
		do {
			while (i < right && a[i] < p) {
				i++;
			}
			while (j > left && a[j] > p) {
				j--;
			}
			if (i < j) {
				swap(a, i, j);
			}
		} while (i < j);
		swap(a, i, right);
		return i;
	}

}
