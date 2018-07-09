package com.sr.problems;

public class TwoStackArray {
	
	private int [] stack;
	
	private int top1;
	
	private int length1;
	
	private int top2;
	
	private int length2;
	
	public TwoStackArray(int length) {
		this.top1 = -1;
		this.top2 = length;
		this.stack = new int[length];
	}
	
	public int getLength1() {
		return length1;
	}

	public int getLength2() {
		return length2;
	}

	public void push(int stackId, int data) {
		if (stackId == 1) {
			if (isFull()) {
				throw new RuntimeException("Array is full");
			}
			if (top1 < top2 - 1) {
				stack[++top1] = data;
				length1++;
			}
		}
		else if (stackId == 2) {
			if (isFull()) {
				throw new RuntimeException("Array is full");
			}
			if (top2 > top1 + 1) {
				stack[--top2] = data;
				length2++;
			}
		}
	}
	
	public int peek(int stackId) {
		if (stackId == 1) {
			if (top1 > -1)
				return stack[top1];
			else
				throw new RuntimeException("Empty stack - "+ stackId);
		}		
		else if (stackId == 2) {
			if (top2 < stack.length) {
				return stack[top2];
			}
			else {
				throw new RuntimeException("Empty stack - "+ stackId);
			}
		}		
		else {
			throw new IllegalArgumentException("Incorrect stack id");
		}
	}
	
	public int pop(int stackId) {

		if (stackId == 1) {
			if (top1 > -1) {
				int elem = stack[top1];
				stack[top1--] = Integer.MIN_VALUE;
				length1--;
				return elem;
			}				
			else
				throw new RuntimeException("Empty stack - "+ stackId);
		}		
		else if (stackId == 2) {
			if (top2 < stack.length) {
				int elem = stack[top2];
				stack[top2++] = Integer.MIN_VALUE;
				length2--;
				return elem;				
			}
			else {
				throw new RuntimeException("Empty stack - "+ stackId);
			}
		}		
		else {
			throw new IllegalArgumentException("Incorrect stack id");
		}	
	}
	
	private boolean isFull() {
		int nextTop1 = top1 + 1;
		return nextTop1 == top2;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("[Stack 1 = [");
		if (top1 > -1) {
			for (int i=0; i<=top1; i++) {
				sb.append(stack[i]);
				if (i < top1) {
					sb.append(", ");
				}
			}
		}
		sb.append("] || Stack 2 = [");
		if (top2 < stack.length) {
			for (int j=stack.length-1; j>=top2; j--) {
				sb.append(stack[j]);
				if (j > top2) {
					sb.append(", ");
				}
			}
		}
		sb.append("]]");
		return sb.toString();
	}

}
