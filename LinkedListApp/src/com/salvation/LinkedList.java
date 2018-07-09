/**
 * 
 */
package com.salvation;

/**
 * @author sayanroy
 *
 */
public class LinkedList {

	// length of the linked list
	private int length = 0;

	// head of the list.
	ListNode head;

	public synchronized int getLength() {
		return length;
	}

	public synchronized ListNode getHead() {
		return head;
	}

	// Insert at the beginning
	public synchronized void insertAtBegining(ListNode node) {
		node.setNext(head); // next of node is pointing, where the head is
							// pointing.
		head = node;
		length++;
	}

	public synchronized void insertAtEnd(ListNode node) {
		if (head == null) {
			node.setNext(null); // setting nodes next to point to NULL
			head = node;
		} else {
			ListNode p;
			p = head;
			while (p.getNext() != null) {
				p = p.getNext();
			}

			node.setNext(null); // pointing to null, as this will be the last
								// node.
			p.setNext(node); // add the node to the linked list.
		}

		length++;
	}

	public synchronized void insertInBetween(ListNode node, int position) {
		// position checks
		if (position < 0) {
			position = 0;
		}
		if (position > length) {
			position = length;
		}
		if (head == null) {
			node.setNext(null); // setting nodes next to point to NULL
			head = node;
		} else if (position == 0) {
			node.setNext(head);
			head = node;
		} else {
			ListNode p = head;
			for (int i = 1; i < position; i++) {
				p = p.getNext();
			}
			node.setNext(p.getNext());
			p.setNext(node);
		}
		length++;
	}

	public synchronized ListNode removeFromHead() {
		ListNode node = head;
		if (head != null) {
			head = node.getNext();
			node.setNext(null);

			length--;
		}
		return node;
	}

	public synchronized ListNode removeFromEnd() {
		if (head != null) {
			ListNode p = head, q = head;
			while (p.getNext() != null) {
				q = p;
				p = p.getNext();
			}
			q.setNext(p.getNext());
			length--;

			return p;
		}
		return null;
	}

	public synchronized void removeFromBetween(int position) {
		// correcting the position
		if (position < 0) {
			position = 0;
		}
		if (position > length) {
			position = length;
		}
		if (head != null) {
			if (position == 0) {
				removeFromHead();
			} else {
				ListNode p = head, q = null;
				for (int i = 0; i < position; i++) {
					q = p;
					p = p.getNext();
				}
				q.setNext(p.getNext());
				p.setNext(null);
			}
		}
		length--;
	}

	public synchronized void removeMatched(ListNode node) {
		if (node != null) {
			ListNode p = head, q = null;
			if (head.getData() == node.getData()) {
				head = p.getNext();
				p.setNext(null);
				length--;
				return;
			}
			while (p.getNext() != null) {
				q = p;
				p = p.getNext();
				if (p.getData() == node.getData()) {
					q.setNext(p.getNext());
					p.setNext(null);
					length--;
					break;
				}
			}
		}
	}

	@Override
	public String toString() {
		String result = "[";
		if (head == null) {
			return result + "]";
		}
		result = result + head.getData();
		ListNode temp = head.getNext();

		while (temp != null) {
			result = result + ", " + temp.getData();
			temp = temp.getNext();
		}
		return result + "]";
	}
}
