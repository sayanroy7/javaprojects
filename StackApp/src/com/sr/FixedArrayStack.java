package com.sr;

import java.util.Arrays;

public class FixedArrayStack implements Stack {
	
	public static final int CAPACITY = 10;
	
	private int capacity;
	
	private int[] stack;
	
	private int top = -1;
	
	public FixedArrayStack() {
		this(CAPACITY);
	}

	public FixedArrayStack(int capacity) {
		super();
		this.capacity = capacity;
		stack = new int[capacity];
	}
	
	@Override
	public int getSize() {
		return top+1;
	}
	
	@Override
	public boolean isEmpty() {
		return top < 0;
	}
	
	@Override
	public void push(int data) throws RuntimeException {
		if (getSize() == capacity) {
			throw new RuntimeException("Stack is full");			
		}
		else {
			stack[++top] = data;
		}
	}
	
	@Override
	public int pop() throws RuntimeException {
		if (isEmpty()) {
			throw new RuntimeException("Stack is Empty");
		}
		int data = stack[top];
		stack[top--] = Integer.MIN_VALUE;
		return data;
	}
	
	@Override
	public int peek() throws RuntimeException {
		if (isEmpty()) {
			throw new RuntimeException("Stack is Empty");
		}
		return stack[top];
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("FixedArrayStack [stack=");
		builder.append(Arrays.toString(stack));
		builder.append("]");
		return builder.toString();
	}

}
