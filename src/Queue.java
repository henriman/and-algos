
public class Queue {
	
	private DoublyLinkedList queue = new DoublyLinkedList();
	
	// Add `x` to the beginning of the queue.
	public void enqueue(int x) {
		queue.addFirst(x);
	}
	
	// Remove and return the last element of the queue.
	public int dequeue() {
		return queue.removeLast();
	}
}
