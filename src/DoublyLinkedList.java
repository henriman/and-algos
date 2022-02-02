
public class DoublyLinkedList {
	
	private int size = 0;
	private Node first = null;
	private Node last = null;
	
	// Add `x` to the beginning of the list.
	public void addFirst(int x) {
		Node node = new Node(x);
		
		if (isEmpty()) {
			first = last = node;
		} else {
			first.prev = node;
			node.next = first;
			first = node;
		}
		
		size++;
	}
	
	// Add `x` to the end of the list.
	public void addLast(int x) {
		Node node = new Node(x);
		
		if (isEmpty()) {
			last = first = node;
		} else {
			last.next = node;
			node.prev = last;
			last = node;
		}
		
		size++;
	}
	
	// Return the first element in the list.
	public int getFirst() {
		return first.value;
	}
	
	// Return the last element in the list.
	public int getLast() {
		return last.value;
	}
	
	// Remove and return the first element in the list.
	public int removeFirst() {
		int value = first.value;
		
		size--;
		
		if (isEmpty()) {
			first = last = null;
		} else {
			first = first.next;
			first.prev = null;
		}
		
		return value;
	}
	
	// Remove and return the first element in the list.
	public int removeLast() {
		int value = last.value;
		
		size--;
		
		if (isEmpty()) {
			first = last = null;
		} else {
			last = last.prev;
			last.next = null;
		}
		
		return value;
	}
	
	// Return the size of the list.
	public int getSize() {
		return size;
	}
	
	// Return whether the list is empty.
	public boolean isEmpty() {
		return size == 0;
	}
	
	// Return the string representation of this list.
	@Override
	public String toString() {
		StringBuilder s = new StringBuilder();
		s.append('(');
		
		Node node = first;
		while (node != null) {
			s.append(String.format("%d -> ", node.value));
			node = node.next;
		}
		
		if (!isEmpty()) {
			s.delete(s.length() - 4, s.length());
		}
		
		s.append(')');
		
		return s.toString();
	}
	
	// A node in the linked list.
	class Node {
		private int value;
		private Node next;
		private Node prev;
		
		public Node(int value) {
			this.value = value;
		}
	}
	
}
