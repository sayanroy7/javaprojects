/**
 * 
 */
package com.sr.queue;

/**
 * @author sayanroy
 *
 */
public interface Queue {
	
	void enQueue(int data);
	
	int deQueue();
	
	int getSize();
	
	boolean isEmpty();

}
