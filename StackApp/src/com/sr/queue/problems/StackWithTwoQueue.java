/**
 * 
 */
package com.sr.queue.problems;

import com.sr.queue.LinkedListQueue;

/**
 * @author sayanroy
 *
 */
public class StackWithTwoQueue {
	
	private LinkedListQueue q1;
	
	private LinkedListQueue q2;
	
	private int size;
	
	public StackWithTwoQueue() {
		this.q1 = new LinkedListQueue();
		this.q2 = new LinkedListQueue();
	}
	
	public int getSize() {
		return size;
	}
	
	public boolean isEmpty() {
		return size == 0;
	}
	
	public void push(int data) {
		if (q1.isEmpty()) {
			q2.enQueue(data);
		} else if (q2.isEmpty()) {
			q1.enQueue(data);
		}
		size++;
	}
	
	/**
	 * Time complexity - O(n)
	 * Space complexity - O(n)
	 * @return
	 */
	public int pop() {
		int item = -1;
		if (q1.isEmpty() && !q2.isEmpty()) {
			while (!q2.isEmpty()) {
				item = q2.deQueue();
				if (q2.isEmpty()) {
					break;
				}
				q1.enQueue(item);
			}
			size--;
		} else if (q2.isEmpty() && !q1.isEmpty()) {
			while (!q1.isEmpty()) {
				item = q1.deQueue();
				if (q1.isEmpty()) {
					break;
				}
				q2.enQueue(item);
			}
			size--;
		} else if (q2.isEmpty() && q1.isEmpty()){
			throw new RuntimeException("Empty stack, underflow!");
		}
		return item;
	}
	
	public int peek() {
		int item = -1;
		if (q1.isEmpty() && !q2.isEmpty()) {
			while (!q2.isEmpty()) {
				item = q2.deQueue();
				q1.enQueue(item);
			}
		} else if (q2.isEmpty() && !q1.isEmpty()) {
			while (!q1.isEmpty()) {
				item = q1.deQueue();
				q2.enQueue(item);
			}
		} else if (q2.isEmpty() && q1.isEmpty()){
			throw new RuntimeException("Empty stack, underflow!");
		}
		return item;
	}
}
