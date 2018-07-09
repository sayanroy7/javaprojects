/**
 * 
 */
package com.sr.queue.problems;

import com.sr.LinkedListStack;
import com.sr.queue.LinkedListQueue;
import com.sr.queue.Queue;

/**
 * @author sayanroy
 *
 */
public class QueueReversal {
	
	/**
	 * We are going to use a stack to reverse
	 * the queue. The principle is to deQueue each element and
	 * push them on to the stack. 
	 * 
	 * This way the rear most element of the queue will be on to of stack.
	 * Then we'll pop all the elements of the stack and perform enQueue for
	 * each element. This will arrange all the element of the queue in revere order.
	 */
	
	public static void reverse(Queue q) {
		if (!q.isEmpty()) {
			LinkedListStack stack = new LinkedListStack();
			while (!q.isEmpty()) {
				int item = q.deQueue();
				stack.push(item);
			}
			while (!stack.isEmpty()) {
				int item = stack.pop();
				q.enQueue(item);
			}
		}
	}
	
	public static void main(String[] args) {
		Queue q = new LinkedListQueue();
		q.enQueue(12);
		q.enQueue(27);
		q.enQueue(38);
		q.enQueue(3);
		
		System.out.println(q);
		reverse(q);
		System.out.println("After reversal: "+ q);
	}

}
