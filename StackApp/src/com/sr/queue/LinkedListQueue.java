/**
 * 
 */
package com.sr.queue;

import com.salvation.ListNode;

/**
 * @author sayanroy
 *
 */
public class LinkedListQueue implements Queue {

	private ListNode front, rear;

	private int size;

	@Override
	public void enQueue(int data) {
		ListNode node = new ListNode(data);
		if (isEmpty()) {
			node.setNext(null);
			front = node;
			rear = front;
		} else {
			node.setNext(rear.getNext());
			rear.setNext(node);
			rear = node;
		}
		size++;
	}

	@Override
	public int deQueue() {
		if (isEmpty()) {
			throw new RuntimeException("Empty queue, underflow!");
		} else {
			ListNode itemNode = front;
			front = front.getNext();
			itemNode.setNext(null);
			size--;
			if (isEmpty()) {
				rear = null;
			}
			return itemNode.getData();
		}
	}

	@Override
	public boolean isEmpty() {
		return size == 0;
	}

	@Override
	public int getSize() {
		return size;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Queue is: [");
		ListNode node = front;
		int counter = 1;
		while (node != null) {
			sb.append(node.getData());
			if (counter < size) {
				sb.append(", ");
			}
			node = node.getNext();
			counter++;
		}
		sb.append("]");
		return sb.toString();
	}
}
