/**
 * 
 */
package com.salvation.linkedlist.probs;

import java.util.HashSet;
import java.util.Set;

import com.salvation.CharListNode;
import com.salvation.LinkedList;
import com.salvation.ListNode;
import com.salvation.Printer;

/**
 * @author sayanroy
 *
 */
public class LinkedListProbs3 {
	
	private static Set<Character> vowels;
	
	static {
		vowels = new HashSet<>();
		vowels.add('A');
		vowels.add('E');
		vowels.add('I');
		vowels.add('O');
		vowels.add('U');
	}
	
	/**
	 * This method checks if 2 lists are identical. If list a and b
	 * both has same no. of elements with same data and order, only
	 * then they're identical.
	 * <br>EX - a = 1->2->3 and b = 1->2->3
	 * 
	 * <br><br> This is iterative version. 
	 * 
	 * <br><strong>TIME COMPLEXITY: O(n)</strong>
	 * 
	 * @param a
	 * @param b
	 * @return
	 */
	public static boolean identical(ListNode a, ListNode b) {
		ListNode left = a, right = b;
		while (left != null && right != null) {
			if (left.getData() != right.getData()) {
				return false;
			}
			left = left.getNext();
			right = right.getNext();
		}
		return left == null && right == null;
	}
	
	public static boolean identicalRecursive(ListNode a, ListNode b) {
		if (a == null && b == null) {
			return true;
		}
		
		if (a.getData() == b.getData()) {
			return identicalRecursive(a.getNext(), b.getNext());
		}
		return false;
	}
	
	/*public static CharListNode reArrangeVowels(CharListNode head) {
		CharListNode temp = head, prev = null, v = null;
		while (temp != null) {
			if (vowels.contains(temp.getData())) {
				if (v == null && prev == null) {
					v = head;
				} else 
			}
			temp = temp.getNext();
		}
		return head;
		
	}*/
	
	public static void main(String[] args) {
		LinkedList list = new LinkedList();
		list.insertAtBegining(new ListNode(45));
		list.insertAtBegining(new ListNode(3));
		list.insertAtEnd(new ListNode(321));
		ListNode head = list.getHead();
		
		Printer.print(head);
	
		
		LinkedList list1 = new LinkedList();
		list1.insertAtBegining(new ListNode(45));
		list1.insertAtBegining(new ListNode(3));
		list1.insertAtEnd(new ListNode(324));
		ListNode head1 = list1.getHead();
		
		Printer.print(head1);
		
		System.out.println("Is identical? "+ identical(list.getHead(), list1.getHead()));
		
		System.out.println("Is identical? "+ identicalRecursive(list.getHead(), list1.getHead()));
	}

}
