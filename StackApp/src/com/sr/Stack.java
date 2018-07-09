/**
 * 
 */
package com.sr;

/**
 * @author sayanroy
 *
 */
public interface Stack {
	
	void push(int data);
	
	int pop();
	
	int peek();
	
	int getSize();
	
	boolean isEmpty();
}
