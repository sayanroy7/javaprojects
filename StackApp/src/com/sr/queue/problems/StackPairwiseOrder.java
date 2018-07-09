/**
 * 
 */
package com.sr.queue.problems;

import com.sr.Stack;
import com.sr.queue.LinkedListQueue;
import com.sr.queue.Queue;

/**
 * @author sayanroy
 *
 */
public class StackPairwiseOrder {
	
	public static boolean isPairwiseOrdered(Stack stack) {
		boolean isOrdered = true;
		Queue q = new LinkedListQueue();
		reverse(stack);
		while (!stack.isEmpty()) {
			int itemL = stack.pop();
			q.enQueue(itemL);
			if (!stack.isEmpty() && isOrdered) {
				int itemR = stack.pop();
				q.enQueue(itemR);
				if (Math.abs(itemL - itemR) != 1) {
					isOrdered = false;
				}
			}
		}
		while (!q.isEmpty()) {
			stack.push(q.deQueue());
		}
		return isOrdered;
	}
	
	public static void reverse(Stack stack) {
		Queue q = new LinkedListQueue();
		while (!stack.isEmpty()) {
			q.enQueue(stack.pop());
		} 
		while (!q.isEmpty()) {
			stack.push(q.deQueue());
		}
	}

}
