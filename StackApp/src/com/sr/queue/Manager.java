/**
 * 
 */
package com.sr.queue;

/**
 * @author sayanroy
 *
 */
public class Manager {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		LinkedListQueue q = new LinkedListQueue();
		q.enQueue(17);
		q.enQueue(13);
		q.enQueue(59);
		
		System.out.println(q);
		System.out.println("The queue size is: "+ q.getSize());
		
		q.enQueue(63);
		
		System.out.println(q);
		System.out.println("The queue size is: "+ q.getSize());
		
		q.enQueue(11);
		
		System.out.println(q);
		System.out.println("The queue size is: "+ q.getSize());
		
		System.out.println("Dq1 => "+ q.deQueue());
		System.out.println("Dq2 => "+ q.deQueue());
		System.out.println("Dq3 => "+ q.deQueue());
		System.out.println("Dq4 => "+ q.deQueue());
		System.out.println("Dq5 => "+ q.deQueue());
		System.out.println(q);
		System.out.println("The queue size is: "+ q.getSize());
		
		q.enQueue(28);
		q.enQueue(21);
		//System.out.println("Dq5 => "+ q.deQueue());
		//System.out.println("Dq6 => "+ q.deQueue());
		
		System.out.println(q);
		System.out.println("The queue size is: "+ q.getSize());

	}

}
