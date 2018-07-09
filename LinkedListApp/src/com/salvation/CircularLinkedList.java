package com.salvation;

public class CircularLinkedList {

	private int length;

	CLLNode head, tail;

	public int getLength() {
		return length;
	}

	public void insertAtBegining(int n) {
		CLLNode node = new CLLNode(n);
		node.setLink(head);

		if (head == null) {
			head = node;
			node.setLink(head);
			tail = head;
		} else {
			head = node;
			tail.setLink(head);
		}

		length++;
	}

	public void insertAtEnd(int n) {
		CLLNode node = new CLLNode(n);
		if (tail == null) {
			tail = node;
			head = tail;
			node.setLink(head);
		} else {
			node.setLink(head);
			tail.setLink(node);
			tail = node;
		}
		length++;
	}

	public void insertAtPos(int n, int pos) {
		if (pos < 0) {
			pos = 0;
		} else if (pos > length) {
			pos = length;
		}

		if (pos == 0) {
			insertAtBegining(n);
		} else if (pos == length) {
			insertAtEnd(n);
		} else {
			CLLNode temp = head;
			for (int i = 1; i < pos; i++) {
				temp = temp.getLink();
			}
			CLLNode node = new CLLNode(n);
			node.setLink(temp.getLink());
			temp.setLink(node);

			length++;
		}
	}

	public CLLNode deletefromHead() {
		if (head == null) {
			return null;
		}

		CLLNode node = head;
		if (length == 1) {
			node.setLink(null);
			head = null;
			tail = null;
		} else {
			head = node.getLink();
			tail.setLink(head);
			node.setLink(null);
		}

		length--;
		return node;
	}

	public CLLNode deletefromTail() {
		if (tail != null) {
			CLLNode temp = head;
			CLLNode node = tail;
			if (length > 1) {
				while (temp.getLink() != tail) {
					temp = temp.getLink();
				}
				temp.setLink(node.getLink());
				node.setLink(null);
				tail = temp;
			} else {
				node.setLink(null);
				head = null;
				tail = head;
			}
			length--;
			return node;
		}
		return null;
	}

	public CLLNode deletefromPos(int pos) {
		if (pos < 0) {
			pos = 0;
		} else if (pos >= length) {
			pos = length - 1;
		}

		if (head == null) {
			return null;
		} else {
			CLLNode node = head, temp = null;
			if (pos == 0) {
				temp = deletefromHead();
			} else if (pos == (length - 1)) {
				temp = deletefromTail();
			} else {
				for (int i = 1; i < pos; i++) {
					node = node.getLink();
				}
				temp = node.getLink();
				node.setLink(temp.getLink());
				temp.setLink(null);

				length--;
			}
			return temp;
		}
	}

	@Override
	public String toString() {
		String result = "[";
		if (head == null) {
			return result + "]";
		}

		result += head.getData();
		CLLNode temp = head.getLink();
		while (temp != head) {
			result += " ," + temp.getData();
			temp = temp.getLink();
		}
		return result + "]";
	}

}
