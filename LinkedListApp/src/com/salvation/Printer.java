/**
 * 
 */
package com.salvation;

/**
 * @author sayanroy
 *
 */
public class Printer {
	
	public static void print(ListNode head) {
		ListNode temp = head;
		while (temp != null) {
			System.out.print(temp.getData() + " ");
			temp = temp.getNext();
		}
		System.out.println("");
	}

}
