package com.sr;

public class DynamicArrayStack implements Stack {
	
	private int capacity;
	
	public static final int CAPACITY = 16;
	
	private int top = -1;
	
	private int[] stack;
	
	public DynamicArrayStack() {
		this(CAPACITY);
	}

	public DynamicArrayStack(int capacity) {
		super();
		this.capacity = capacity;
		stack = new int[this.capacity];
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
	public void push(int data) {
		if (getSize() == capacity) {
			expand();			
		}
		stack[++top] = data;
	}
	
	private void expand() {
		int length = getSize();
		int newCapacity = length << 1;
		int [] toArr = new int[newCapacity];
		this.capacity = newCapacity;
		System.out.println("toArr size: "+ toArr.length);
		System.arraycopy(stack, 0, toArr, 0, length);		
		stack = toArr;
	}
	
	@Override
	public int pop() {
		if (isEmpty()) {
			throw new RuntimeException("Stack is empty");
		}
		int data = stack[top];
		stack[top--] = Integer.MIN_VALUE;
		return data;
	}
	
	@Override
	public int peek() {
		if (isEmpty()) {
			throw new RuntimeException("Stack is Empty");
		}
		return stack[top];
	}
	
	@Override
	public String toString() {
		String s = "[";
		if (getSize() > 0) {
			for (int i=0; i<getSize(); i++) {
				s += stack[i];
				if (top != i) {
					s += ", ";
				}
			}
		}
		
		s += "]";
		return s;
	}

}
