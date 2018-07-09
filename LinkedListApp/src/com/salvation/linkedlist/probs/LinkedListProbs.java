/**
 * 
 */
package com.salvation.linkedlist.probs;

import java.util.Stack;

import com.salvation.LinkedList;
import com.salvation.ListNode;

/**
 * @author sayanroy
 *
 */
public class LinkedListProbs {
	
	public static ListNode pairWiseSwap(ListNode head) {
		ListNode p = head;
		ListNode newHead = p.getNext();//pointing head to 2nd node of original list
		while (true) {
			//p is pointing to 1st node of current pair.
			ListNode q = p.getNext();//point to 2nd node of current pair
			ListNode temp = q.getNext(); //point to 1st node of next pair
			
			q.setNext(p);//actually swapping the link here, breaking q previous link to point to p
			
			if (temp == null || temp.getNext() == null) {
				//breaking condition. So, the last node would point to NULL
				//in case of 'even' length list. However, p would point to the 
				//last node of original list in case of 'odd' length list
				p.setNext(temp);
				break;
			}
			//the 1st node's link of current pair points to 2nd node of next pair
			p.setNext(temp.getNext()); 
			p = temp; //now 'p' points to 1st node of next pair. This will ensure the next iteration.
		}
		return newHead;
	}
	
	public static ListNode kNodeSwap(ListNode head, int k) {
		ListNode p = head, q = null, temp = null, newHead = null;
		int count = 1;
		while (count != k) {
			if (p.getNext() == null) {
				return head;
			}
			p = p.getNext();
			count++;
		}
		newHead = p;
		q = newHead;
		while (true) {
			p = head;
			temp = q.getNext();			
			if (temp == null) {
				reverseIterative(p);
				return newHead;
			}
			q.setNext(null);
			q = temp;
			head = q;
			count = 1;
			while (count != k) {
				if (temp.getNext() == null) {
					reverseIterative(p);
					p.setNext(q);
					return newHead;
				}
				temp = temp.getNext();
				count++;
			}
			reverseIterative(p);
			p.setNext(temp);
			q = temp;
		}
		//return newHead;
	}
	
	public static ListNode reverseRecursive(ListNode head) {
		ListNode newHead = null;
		if (head.getNext() == null) {
			//breaking condition
			newHead = head;
			return newHead;
		}
		newHead = reverseRecursive(head.getNext());
		//head is the current node ** the last but one node
		ListNode next = head.getNext();//next is the next node of current, i.e  the last node 
		next.setNext(head);
		head.setNext(null);
		return newHead;
	}
	
	public static ListNode reverseIterativeStack(ListNode head) {
		Stack<ListNode> stack = new Stack<ListNode>();
		ListNode newHead = null;
		while (head.getNext() != null) {
			stack.push(head);
			head = head.getNext();
		}		
		newHead = head; //assign the new head
		while (!stack.isEmpty()) {
			ListNode node = stack.pop();
			node.setNext(null);
			head.setNext(node);
			head = head.getNext();
		}
		return newHead;
	}
	
	public static ListNode reverseIterative(ListNode head) {
		ListNode prev = null, current = head, next = null;
		while (current != null) {
			next = current.getNext();
			current.setNext(prev);
			
			prev = current;
			current = next;
		}
		return prev;
	}
	
	public static void main(String[] args) {
		LinkedList list = new LinkedList();
		list.insertAtBegining(new ListNode(23));
		list.insertAtBegining(new ListNode(37));
		list.insertAtEnd(new ListNode(99));
		list.insertAtEnd(new ListNode(117));
		list.insertAtEnd(new ListNode(71));
		list.insertAtEnd(new ListNode(66));
		ListNode head = list.getHead();
		ListNode temp = head;
		/*while (head != null) {
			System.out.print(head.getData() + " ");
			head = head.getNext();
		}*/
		System.out.println("head before swap: "+ head.getData());
		
		while (temp != null) {
			System.out.print(temp.getData() + " ");
			temp = temp.getNext();
		}
		System.out.println();
		head = kNodeSwap(head, 4);
		temp = head;
		while (temp != null) {
			System.out.print(temp.getData() + " ");
			temp = temp.getNext();
		}
		System.out.println("\nhead after swap: "+ head.getData());
		
		ListNode newHead = reverseRecursive(head);
		print(newHead);
		
		print(reverseIterativeStack(newHead));
		
		print(reverseIterative(newHead));
	}
	
	private static void print(ListNode head) {
		ListNode temp = head;
		System.out.println("\nhead after swap: "+ head.getData());
		while (temp != null) {
			System.out.print(temp.getData() + " ");
			temp = temp.getNext();
		}
	}

}
