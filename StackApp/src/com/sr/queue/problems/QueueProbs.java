/**
 * 
 */
package com.sr.queue.problems;

import com.sr.FixedArrayStack;
import com.sr.LinkedListStack;
import com.sr.Stack;
import com.sr.queue.LinkedListQueue;
import com.sr.queue.Queue;

/**
 * @author sayanroy
 *
 */
public class QueueProbs {

	/**
	 * This method re-arranges the queue elements by interleaving the 1st half
	 * of the queue with the 2nd half of the queue.
	 * 
	 * For example - If Q = [12,13,14,15,16,17] are the elements of the queue.
	 * Then calling this method would arrange the queue as - Q =
	 * [12,15,13,16,14,17].
	 * 
	 * @param q
	 * @throws IllegalArgumentException
	 *             if the no. of elements in the queue is not even.
	 */
	public static void reArrange(Queue q) {
		int size = q.getSize();
		if ((size % 2) != 0) {
			throw new IllegalArgumentException(
					"No of Queue elements are not even!");
		}
		Stack stack = new LinkedListStack();
		int halfSize = size / 2;
		for (int i = 0; i < halfSize; i++) {
			stack.push(q.deQueue());
		}
		while (!stack.isEmpty()) {
			q.enQueue(stack.pop());
		}
		for (int i = 0; i < halfSize; i++) {
			q.enQueue(q.deQueue());
		}//after the above loop q is - [14, 13, 12, 15, 16, 17]
		for (int i = 0; i < halfSize; i++) {
			stack.push(q.deQueue());
		}//after the above loop q is - [15, 16, 17] and stack is - TOS -> [12, 13, 14]

		while (!stack.isEmpty()) {
			q.enQueue(stack.pop());
			q.enQueue(q.deQueue());
		}//after this loop q is - [12, 15, 13, 16, 14, 17]
	}

	/**
	 * This method revere the first 'k' elements
	 * while preserving the order of the remaining
	 * elements.
	 * 
	 * Time complexity - O(n)
	 * Space complexity - O(n)
	 * 
	 * @param q
	 * @param k
	 */
	public static void kElementReverse(Queue q, int k) {
		if (q == null || k > q.getSize()) {
			throw new IllegalArgumentException(
					" Either queue is null or it's size is less than offset");
		}
		Stack stack = new FixedArrayStack(k);
		for (int i = 0; i < k; i++) {
			stack.push(q.deQueue());
		}
		while (!stack.isEmpty()) {
			q.enQueue(stack.pop());
		}
		int size = q.getSize();
		for (int i = 0; i < size - k; i++) {
			q.enQueue(q.deQueue());
		}
	}

	public static void main(String[] args) {
		Queue q = new LinkedListQueue();
		q.enQueue(13);
		q.enQueue(16);
		q.enQueue(19);
		q.enQueue(15);
		q.enQueue(18);
		q.enQueue(21);

		System.out.println(q);
		reArrange(q);
		System.out.println(q);
		
		kElementReverse(q, 3);
		System.out.println(q);
	}

}
