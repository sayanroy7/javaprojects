/**
 * 
 */
package com.sr.tree.binary;

import com.salvation.DLLNode;
import com.salvation.DoublyLinkedList;
import com.salvation.LinkedList;
import com.salvation.ListNode;

/**
 * @author sayanroy
 *
 */
public class BSTToDLL {

	public static BinarySearchTreeNode sortedDllToBst(DLLNode head) {
		if (head == null) {
			return null;
		}
		int length = 0;
		DLLNode current = head;
		while (current != null) {
			length++;
			current = current.getNext();
		}
		return construct(head, 0, length - 1);
	}

	/**
	 * This is top down approach
	 * 
	 * @param head
	 * @param start
	 * @param end
	 * @return
	 */
	private static BinarySearchTreeNode construct(DLLNode head, int start,
			int end) {
		if (start > end) {
			return null;
		}
		BinarySearchTreeNode left = construct(head, start, start
				+ (end - start) / 2 - 1);
		BinarySearchTreeNode root = new BinarySearchTreeNode(head.getData());
		root.setLeft(left);
		if (head.getNext() != null) {
			head.setData(head.getNext().getData());
			head.setNext(head.getNext().getNext());
		}
		//System.out.println("DLL after head -> data: "+ head.getData());
		root.setRight(construct(head, start + (end - start) / 2 + 1, end));
		return root;
	}
	
	public static BinarySearchTreeNode sortedSLLToBst(ListNode head) {
		if (head == null) {
			return null;
		}
		int length = 0;
		ListNode current = head;
		while (current != null) {
			length++;
			current = current.getNext();
		}
		return constructBottomUp(head, 0, length - 1);
	}
	
	/**
	 * This is top down approach
	 * 
	 * @param head
	 * @param start
	 * @param end
	 * @return
	 */
	private static BinarySearchTreeNode constructBottomUp(ListNode head, int start,
			int end) {
		if (start > end) {
			return null;
		}
		BinarySearchTreeNode left = constructBottomUp(head, start, start
				+ (end - start) / 2 - 1);
		BinarySearchTreeNode root = new BinarySearchTreeNode(head.getData());
		root.setLeft(left);
		head = head.getNext();
		System.out.println("SLL after head -> data: "+ head.getData());
		root.setRight(constructBottomUp(head, start + (end - start) / 2 + 1, end));
		return root;
	}
	
	public static void main(String[] args) {
		DoublyLinkedList dll = new DoublyLinkedList();
		dll.insertAtEnd(new DLLNode(1));
		dll.insertAtEnd(new DLLNode(2));
		dll.insertAtEnd(new DLLNode(3));
		dll.insertAtEnd(new DLLNode(4));
		dll.insertAtEnd(new DLLNode(5));
		dll.insertAtEnd(new DLLNode(6));
		/*dll.insertAtEnd(new DLLNode(7));*/
		
		LinkedList list = new LinkedList();
		list.insertAtEnd(new ListNode(1));
		list.insertAtEnd(new ListNode(2));
		list.insertAtEnd(new ListNode(3));
		list.insertAtEnd(new ListNode(4));
		list.insertAtEnd(new ListNode(5));
		list.insertAtEnd(new ListNode(6));
		
		DLLNode head = dll.getHead();
		System.out.println("Dll is: "+ dll);
		
		System.out.println("SLL is: "+ list);
		
		//System.out.println("Dll head: "+ head.getNext().getData());
		BinarySearchTreeNode root = sortedDllToBst(head);
		BinarySearchTreeNode root1 = sortedSLLToBst(list.getHead());
		System.out.println("BST DLL: "+ root);
		System.out.println("BST SLL: "+ root1);
		BinarySearchTreeTraversal.levelOrderTraversalIterative(root);
		System.out.println("\nBST SLL: "+ root1);
		BinarySearchTreeTraversal.levelOrderTraversalIterative(root1);
	}

}
