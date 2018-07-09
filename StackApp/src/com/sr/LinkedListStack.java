package com.sr;

import com.salvation.ListNode;

public class LinkedListStack implements Stack {
	
	private int length;
	
	public int getLength() {
		return length;
	}

	private ListNode top;
	
	public LinkedListStack() {
		length = 0;
		top = null;
	}
	
	@Override
	public int getSize() {
		return length;
	}
	
	public boolean isEmpty() {
		return top == null;
	}
	
	public void push(int data) {
		ListNode node = new ListNode(data);
		node.setNext(top);
		top = node;
		length++;
	}
	
	public int pop() {
		if (top == null) {
			throw new RuntimeException("Stack is empty");
		}
		
		ListNode temp = top;
		int data = temp.getData();
		top = temp.getNext();
		length--;		
		temp = null;
		
		return data;
	}
	
	public int peek() {
		if (top == null) {
			throw new RuntimeException("Stack is empty");
		}
		return top.getData();
	}
	
	@Override
	public String toString() {
		String s = "[";
		if (length > 0) {
			int index = 0;
			ListNode temp = top;
			s += temp.getData();
			while (temp.getNext() != null) {
				temp = temp.getNext();
				index++;				
				if (index != length) {
					s += ", ";
				}
				s += temp.getData();
			}
		}
		
		s += "]";
		return s;
	}
}
