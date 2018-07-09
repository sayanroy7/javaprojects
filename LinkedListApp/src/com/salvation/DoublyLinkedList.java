package com.salvation;

public class DoublyLinkedList {
	
	private int length;
	
	DLLNode head, tail;

	public int getLength() {
		return length;
	}

	public DLLNode getHead() {
		return head;
	}
	
	public synchronized void insertAtBegining(DLLNode node) {
		if (head == null) {
			head = node;
			tail = head;
		}
		else {
			head.setPrev(node);
			node.setNext(head);
			head = node;			
		}		
		length++;
	}
	
	public synchronized void insertAtEnd(DLLNode node) {
		if (tail == null) {
			tail = node;
			head = tail;
		}
		else {
			node.setPrev(tail);
			tail.setNext(node);
			tail = node;
		}
		length++;
	}
	
	public synchronized void insert(int position, DLLNode node) {
		//correct the position
		if (position < 0) {
			position = 0;			
		}
		if (position > length){
			position = length;
		}
		if (head == null || position == 0) {
			insertAtBegining(node);
		}
		else if (position == length) {
			insertAtEnd(node);
		}
		else {
			DLLNode p = head;
			for (int i=1; i<position; i++) {
				p = p.getNext();
			}
			node.setNext(p.getNext());
			node.setPrev(p);
			p.getNext().setPrev(node);
			p.setNext(node);
			length++;
		}
	}
	
	public synchronized void deleteFromHead() {
		if (head != null) {
			if (length > 1) {
				DLLNode temp = head.getNext();
				temp.setPrev(null);
				head.setNext(null);
				head = temp;
				length--;
			}
			else {
				head = null;
				tail = head;
				length--;
			}
		}
	}
	
	public synchronized void deleteFromTail() {
		if (tail != null) {
			if (length > 1) {
				DLLNode temp = tail.getPrev();
				temp.setNext(null);
				tail.setPrev(null);
				tail = temp;
				length--;
			}
			else {
				tail = null;
				head = tail;
				length--;
			}
		}
	}
	
	public synchronized void delete(int position) {
		//correcting position
		if (position < 0) {
			position = 0;
		}
		if (position >= length) {
			position = length - 1;
		}
		if (position == 0) {
			deleteFromHead();
		}
		else if (position == (length -1)) {
			deleteFromTail();
		}
		else {
			DLLNode temp = head;
			for (int i=0; i<position; i++) {
				temp = temp.getNext();
			}			
			temp.getPrev().setNext(temp.getNext());
			temp.getNext().setPrev(temp.getPrev());
			temp.setNext(null);
			temp.setPrev(null);
			length--;
		}
	}
	
	@Override
	public String toString() {
		String result = "[";
		if (head == null) {
			return result + "]";
		}
		
		result += head.getData();
		DLLNode temp = head.getNext();		
		while (temp != null) {			
			result += " ," + temp.getData();
			temp = temp.getNext();
		}
		return result + "]";
	}
}
