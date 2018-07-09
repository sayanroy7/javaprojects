/**
 * 
 */
package com.salvation.linkedlist.probs;

import com.salvation.LinkedList;
import com.salvation.ListNode;
import com.salvation.Printer;

/**
 * @author sayanroy
 *
 */
public class LinkedListProbs2 {
	
	public static void findMiddle(ListNode head) {
		ListNode fast = head, slow = head;
		while (fast != null && fast.getNext() != null) {
			fast = fast.getNext().getNext();
			slow = slow.getNext();
		}
		
		if (slow != null) {
			System.out.println("Middle node is: "+ slow.getData());
		}
	}
	
	public static ListNode findFromLast(ListNode head, int n) {
		ListNode main = head, ref = head;
		for (int i = 0; i <= n; i++) {
			ref = ref.getNext();
		}
		if (ref == null) {
			return null;
		}
		while (ref != null) {
			main = main.getNext();
			ref = ref.getNext();
		}
		return main;
	}
	
	/**
	 * This method removes duplicates for the linked list.
	 * The passed list must be in sorted order. 
	 * 
	 * EX - If a list is passed as {11,11,23,35,35,54}. Calling
	 * this method would make the list as - {11,23,35,54}
	 * 
	 * @param head
	 */
	public static void removeDuplicates(ListNode head) {
		ListNode ref = head;
		if (ref == null) {
			return;
		}
		while (ref != null && ref.getNext() != null) {
			if (ref.getData() == ref.getNext().getData()) {
				//storing the next pointer
				ListNode nextNext = ref.getNext().getNext();
				ref.getNext().setNext(null); //setting next->next as null
				ref.setNext(nextNext);//setting nextNext as current->next
			} else
			ref = ref.getNext(); //proceed as usual.
		}
	}
	
	/**
	 * <p>This method removes duplicates from the unsorted linked list. 
	 * 
	 * EX - If a list is passed as {12,11,11,10,35,35,23,54}. Calling
	 * this method would make the list as - {12,11,10,35,23,54}</p>
	 * 
	 * <br><strong>LOGIC</strong>: Using two loops to check for each item in outer loop while
	 * consecutively checking for the remaining items in the inner loop.
	 * 
	 * <br><br><strong>TIME COMPLEXITY - O(n^2)</strong>
	 * 
	 * @param head
	 */
	public static void removeDuplicatesUnsorted(ListNode head) {
		ListNode outer, inner, dup = null;
		outer = head;
		while (outer != null && outer.getNext() != null) {
			ListNode prev = outer;
			inner = outer.getNext();
			while (inner != null) {				
				if (outer.getData() == inner.getData()) {
					dup = inner;
					inner = inner.getNext();
					prev.setNext(inner);
					dup.setNext(null);
					dup = null;
				} else {
					prev = inner;
					inner = inner.getNext();
				}
			}
			outer = outer.getNext();
		}
	}
	
	/**
	 * This method merges to sorted linked list into one list
	 * in a spliced manner. i.e. - if the two linked list to be merged are
	 * {2,6,9} and {3,8,12} respectively, then the new merged list 
	 * would be {2,3,6,8,9,12} 
	 * 
	 * @param a - a sorted linked list to be merged with b
	 * @param b - a sorted linked list to be merged with a
	 * @return the head pointer of merged list
	 */
	public static ListNode mergeRecursive(ListNode a, ListNode b) {
		if (a == null) {
			return b;
		} else if (b == null) {
			return a;
		} else {
			ListNode result = null;
			if (a.getData() < b.getData()) {
				result = a;
				result.setNext(mergeRecursive(a.getNext(), b));
			} else {
				result = b;
				result.setNext(mergeRecursive(a, b.getNext()));
			}
			return result;
		}
	}
	
	public static ListNode mergeIterative(ListNode a, ListNode b) {
		ListNode head = null;
		if (a.getData() < b.getData()) {
			head = a;
			a = a.getNext();
		} else {
			head = b;
			b = b.getNext();
		}
		head.setNext(null);
		ListNode tail = head;
		head.setNext(null);
		while (true) {
			if (a == null) {
				tail.setNext(b);
				break;
			} else if (b == null) {
				tail.setNext(a);
				break;
			} else {
				if (a.getData() < b.getData()) {
					ListNode temp = a;
					a = a.getNext();
					
					temp.setNext(tail.getNext());
					tail.setNext(temp);
					
				} else {
					ListNode temp = b;
					b = b.getNext();
					
					temp.setNext(tail.getNext());
					tail.setNext(temp);
					
				}
			}
			tail = tail.getNext();
		}
		return head;
	}
	
	public static void main(String[] args) {
		LinkedList list = new LinkedList();
		list.insertAtBegining(new ListNode(37));
		list.insertAtBegining(new ListNode(23));
		list.insertAtEnd(new ListNode(66));
		list.insertAtEnd(new ListNode(71));
		list.insertAtEnd(new ListNode(99));
		list.insertAtEnd(new ListNode(117));		
		ListNode head = list.getHead();
		
		LinkedList list1 = new LinkedList();
		list1.insertAtBegining(new ListNode(45));
		list1.insertAtBegining(new ListNode(3));
		list1.insertAtEnd(new ListNode(321));
		
		Printer.print(head);
		findMiddle(head);
		System.out.println("2nd from last: "+ findFromLast(head, 2).getData());
		
		System.out.println("merging\n");
		Printer.print(head);
		Printer.print(list1.getHead());
		System.out.println("After merging\n");
		Printer.print(mergeIterative(head, list1.getHead()));
		
		LinkedList list2 = new LinkedList();
		list2.insertAtEnd(new ListNode(12));
		list2.insertAtEnd(new ListNode(16));
		list2.insertAtEnd(new ListNode(16));
		list2.insertAtEnd(new ListNode(16));
		list2.insertAtEnd(new ListNode(45));
		list2.insertAtEnd(new ListNode(56));
		list2.insertAtEnd(new ListNode(56));
		
		ListNode list2Head = list2.getHead();
		Printer.print(list2Head);
		System.out.println("After removing duplicates - ");
		removeDuplicates(list2Head);
		Printer.print(list2Head);
		
		LinkedList list3 = new LinkedList();
		list3.insertAtEnd(new ListNode(12));
		list3.insertAtEnd(new ListNode(12));
		list3.insertAtEnd(new ListNode(11));
		list3.insertAtEnd(new ListNode(12));
		list3.insertAtEnd(new ListNode(12));
		list3.insertAtEnd(new ListNode(10));
		list3.insertAtEnd(new ListNode(12));
		list3.insertAtEnd(new ListNode(32));
		list3.insertAtEnd(new ListNode(11));
		
		ListNode list3Head = list3.getHead();
		Printer.print(list3Head);
		System.out.println("After removing duplicates unsorted - ");
		removeDuplicatesUnsorted(list3Head);
		Printer.print(list3Head);
	}

}
