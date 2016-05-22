package io.attil;
import java.util.Stack;

public class HanoiTower {
	private Stack<Integer> stack = new Stack<>();
	
	public void push(int element) {
		if (!stack.empty()) {
			int below = stack.peek();
			if (below <= element) {
				throw new IllegalArgumentException("cannot push over smaller element");
			}
		}
		stack.push(element);
	}

	public int pop() {
		return stack.pop();
	}
	
	public int peek() {
		return stack.peek();
	}
	
	public boolean empty() {
		return stack.empty();
	}
	
}
