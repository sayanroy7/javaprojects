/**
 * 
 */
package com.salvation;

/**
 * @author sayanroy
 *
 */
public class CharListNode {
	
	private char data;
	
	private CharListNode next;
	
	public CharListNode(char data) {
		this.data = data;
	}

	public char getData() {
		return data;
	}

	public void setData(char data) {
		this.data = data;
	}

	public CharListNode getNext() {
		return next;
	}

	public void setNext(CharListNode next) {
		this.next = next;
	}
}
