/**
 * 
 */
package com.sr;

/**
 * @author sayanroy
 *
 */
public class CharArrayStack {

	private static final int CAPACITY = 10;

	private int capacity;

	private char[] stack;

	private int top = -1;

	public CharArrayStack() {
		this(CAPACITY);
	}

	public CharArrayStack(int capacity) {
		this.capacity = capacity;
		stack = new char[capacity];
	}
	
	public CharArrayStack(String string) {
		this(string.length());
		int length = string.length();
		for (int i=0; i<length; i++) {
			this.push(string.charAt(i));
		}
	}

	public int size() {
		return top + 1;
	}
	
	public boolean isEmpty() {
		return size() == 0;
	}

	public void push(char c) {
		if (top >= capacity) {
			throw new RuntimeException("Stack overflow");
		}
		stack[++top] = c;
	}

	public char pop() {
		if (top < 0) {
			throw new RuntimeException("Empty stack");
		}
		char temp = stack[top];
		stack[top--] = Character.MIN_VALUE;
		return temp;
	}

	public char peek() {
		if (top < 0) {
			throw new RuntimeException("Empty stack");
		}
		return stack[top];
	}

	@Override
	public String toString() {
		int size = size();
		StringBuilder sb = new StringBuilder();
		sb.append("[");
		if (size > 0) {
			for (int i = 0; i < size; i++) {
				sb.append(stack[i]);
				if (i < top) {
					sb.append(", ");
				}
			}
		}
		sb.append("]");
		return sb.toString();
	}

}
