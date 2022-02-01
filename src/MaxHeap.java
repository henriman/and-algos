import java.util.ArrayList;

public class MaxHeap {
	
	public static void main(String[] args) {
		MaxHeap maxHeap = new MaxHeap(new int[] { 1, 2, 3, 4, 5} );
		System.out.println(maxHeap.values);
		maxHeap.insert(6);
		System.out.println(maxHeap.values);
		System.out.println(maxHeap.extractMax());
		System.out.println(maxHeap.values);
		System.out.println(maxHeap.extractMax());
		System.out.println(maxHeap.values);
		System.out.println(maxHeap.extractMax());
		System.out.println(maxHeap.values);
	}
	
	private ArrayList<Integer> values = new ArrayList<>();	
	
	public MaxHeap() {
		this(new int[0]);
	}

	// Construct a heap using the values in `values`.
	public MaxHeap(int[] values) {
		// Construct the heap.
		for (int x : values) {
			this.values.add(x);
		}
		for (int i = this.values.size() / 2 - 1; i >= 0; i--) {
			siftDown(i);  // Using siftDown, this takes O(n).
		}
	}
	
	// Insert `x` into the heap, maintaining the heap condition.
	public void insert(int x) {
		values.add(x);
		siftUp(values.size() - 1);
	}
	
	// Remove and return the maximum element in the heap, and restore the heap condition after.
	public int extractMax() {
		swap(0, values.size() - 1);

		int max = values.remove(values.size() - 1);
		siftDown(0);
		
		return max;
	}
	
	// Return the size of the heap (i. e. the number of elements in the heap).
	public int getSize() {
		return values.size();
	}
	
	// Return whether the heap is empty.
	public boolean isEmpty() {
		return getSize() == 0;
	}
	
	// Swap the values at positions `i` and `j`.
	private void swap(int i, int j) {
		int temp = values.get(i);
		values.set(i, values.get(j));
		values.set(j, temp);
	}
	
	// Return the index of the left child of `i`.
	private int cli(int i) {
		return 2 * i + 1;
	}
	
	// Return the index of the right child of `i`.
	private int cri(int i) {
		return 2 * i + 2;
	}
	
	// Return the index of the parent of `i`.
	private int pi(int i) {
		return (i % 2 == 1) ? (i - 1) / 2 : (i - 2) / 2;
	}
	
	// Sift the value at position `i` down until the heap condition is fulfilled again.
	private void siftDown(int i) {
		while (cli(i) < values.size() && values.get(i) < values.get(cli(i)) 
				|| cri(i) < values.size() && values.get(i) < values.get(cri(i))) {
			
			int childIndex = (cri(i) >= values.size() || values.get(cli(i)) > values.get(cri(i))) ? cli(i) : cri(i);

			swap(i, childIndex);
			i = childIndex;
		}
	}
	
	// Sift the value at position `i` up until the heap condition is fulfilled again.
	private void siftUp(int i) {
		while (i - (1 + (i + 1) % 2) >= 0 && values.get(pi(i)) < values.get(i)) {
			swap(pi(i), i);
			i = pi(i);
		}
	}
	
}
