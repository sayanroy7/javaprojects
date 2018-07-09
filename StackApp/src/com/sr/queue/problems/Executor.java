/**
 * 
 */
package com.sr.queue.problems;

import com.sr.DynamicArrayStack;
import com.sr.Stack;
import com.sr.queue.LinkedListQueue;
import com.sr.queue.Queue;

/**
 * @author sayanroy
 *
 */
public class Executor {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Stack stack = new DynamicArrayStack();
		stack.push(2);
		stack.push(3);
		stack.push(-9);
		stack.push(-8);
		stack.push(7);
		System.out.println("Stack is: "+ stack);
		
		System.out.println("Is pairWiseOrdered? "+ StackPairwiseOrder.isPairwiseOrdered(stack));
		System.out.println("Stack is: "+ stack);
	}
	
	static void q2Stack() {
		Queue q = new LinkedListQueue();
		q.enQueue(23);
		q.enQueue(12);
		q.enQueue(86);
		QueueToStack q2s = new QueueToStack();
		System.out.println("Q 2 stack: "+ q2s.transferToStack(q));
	}
	
	static void stackWithTwoQueue() {
		StackWithTwoQueue stack = new StackWithTwoQueue();
		stack.push(23);
		stack.push(17);
		stack.push(54);
		
		System.out.println("Peek: "+ stack.peek());
		System.out.println("Stack size: "+ stack.getSize());
		
		System.out.println("Pop 1: "+ stack.pop());
		System.out.println("Pop 2: "+ stack.pop());
		System.out.println("Stack size: "+ stack.getSize());
		System.out.println("Peek: "+ stack.peek());
		System.out.println("Pop 3: "+ stack.pop());
		System.out.println("Stack size: "+ stack.getSize());
		System.out.println("Stack isEmpty: "+ stack.isEmpty());
		//System.out.println("Pop 1: "+ stack.pop());
		//System.out.println("Peek: "+ stack.peek());

	}
	
	static void queueWithTwoStack() {
		QueueWithTwoStacks q = new QueueWithTwoStacks();
		//System.out.println("D Q: "+ q.deQueue());
		q.enQueue(13);
		q.enQueue(57);
		q.enQueue(74);
				
		System.out.println("The queue size is: "+ q.getSize());
		System.out.println(q);
		
		System.out.println("D Q: "+ q.deQueue());
		q.enQueue(9);
		System.out.println(q);
		System.out.println("The queue size is: "+ q.getSize());
	}

}
