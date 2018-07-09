/**
 * 
 */
package com.sr.queue.problems;

import com.sr.LinkedListStack;
import com.sr.Stack;
import com.sr.queue.Queue;

/**
 * Transfer the element of a queue into a stack
 * where the first element (front) of the queue would be
 * at top of the stack (TOS). While the remaining elements
 * of the queue would preserve it's order in the stack.
 * 
 * @author sayanroy
 */
public class QueueToStack {
	
	public Stack transferToStack(Queue q) {
		Stack stack = new LinkedListStack();
		while (!q.isEmpty()) {
			stack.push(q.deQueue());
		}
		
		while (!stack.isEmpty()) {			
			int item = stack.pop();
			q.enQueue(item);
		}
		
		while (!q.isEmpty()) {
			stack.push(q.deQueue());
		}
		return stack;
	}

}
