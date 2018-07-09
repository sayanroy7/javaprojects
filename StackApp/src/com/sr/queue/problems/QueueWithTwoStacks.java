/**
 * 
 */
package com.sr.queue.problems;

import com.sr.LinkedListStack;

/**
 * @author sayanroy
 *
 */
public class QueueWithTwoStacks {

	private LinkedListStack stack1;

	private LinkedListStack stack2;

	private int size;

	public QueueWithTwoStacks() {
		this.stack1 = new LinkedListStack();
		this.stack2 = new LinkedListStack();
	}

	public int getSize() {
		return size;
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public void enQueue(int data) {
		stack1.push(data);
		size++;
	}

	public int deQueue() {
		if (isEmpty()) {
			throw new RuntimeException("Queue is empty, underflow!");
		} else if (!stack2.isEmpty()) {
			int item = stack2.pop();
			size--;
			return item;
		} else if (stack2.isEmpty() && !stack1.isEmpty()) {
			while (!stack1.isEmpty()) {
				stack2.push(stack1.pop());
			}
			int item = stack2.pop();
			size--;
			return item;
		} else {
			throw new RuntimeException("Unknown error!");
		}
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		String elem2 = "";
		sb.append("Queue is: [");
		String stack2Str = stack2.toString();
		String stack1Str = stack1.toString();
		if (!stack2Str.isEmpty()) {
			 elem2 = stack2Str.substring(stack2Str.indexOf("[") + 1,
					stack2Str.indexOf("]"));
			if (!elem2.isEmpty()) {
				sb.append(elem2);
			}
		}
		if (!stack1Str.isEmpty()) {
			String elem = stack1Str.substring(stack1Str.indexOf("[") + 1,
					stack1Str.indexOf("]"));
			if (!elem2.isEmpty() && !elem.isEmpty()) {
				sb.append(", ");
			}			
			if (!elem.isEmpty()) {			
				String [] elems = elem.split(", ");
				for (int i = elems.length - 1; i >= 0; i--) {
					sb.append(elems[i]);
					if (i > 0) {
						sb.append(", ");
					}
				}
			}
		}

		sb.append("]");
		return sb.toString();
	}
}
