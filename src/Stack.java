
public class Stack {
	
	private DoublyLinkedList stack = new DoublyLinkedList();
	
	// Push `x` onto the stack.
	public void push(int x) {
		stack.addFirst(x);
	}
	
	// Pop the top-most element from the stack.
	public int pop() {
		return stack.removeFirst();
	}
	
	// Return the top-most element.
	public int top() {
		return stack.getFirst();
	}
}
