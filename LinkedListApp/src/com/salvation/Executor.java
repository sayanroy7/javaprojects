package com.salvation;

public class Executor {

	public static void main(String[] args) {
		//circularLL();
		doubleLL();
		//singleLL();
	}
	
	private static void circularLL() {
		CircularLinkedList cll = new CircularLinkedList();
		cll.insertAtBegining(28);
		System.out.println("The CLL length is: "+ cll.getLength());
		System.out.println("The CLL is: "+ cll.toString());
		cll.insertAtBegining(13);  	
		cll.insertAtBegining(49);
		
		System.out.println("The CLL length is: "+ cll.getLength());
		System.out.println("The CLL is: "+ cll.toString());
		
		cll.insertAtEnd(17);
		cll.insertAtEnd(41);
		
		System.out.println("The CLL length is: "+ cll.getLength());
		System.out.println("The CLL is: "+ cll.toString());
		
		cll.insertAtPos(33, 179);
		cll.insertAtPos(112, 0);
		
		System.out.println("The CLL length is: "+ cll.getLength());
		System.out.println("The CLL is: "+ cll.toString());
		
		cll.deletefromHead();
		cll.deletefromHead();
		
		System.out.println("The CLL length is: "+ cll.getLength());
		System.out.println("The CLL is: "+ cll.toString());
		
		cll.deletefromTail();		
		
		System.out.println("The CLL length is: "+ cll.getLength());
		System.out.println("The CLL is: "+ cll.toString());
		
		cll.deletefromPos(88);
		System.out.println("The CLL length is: "+ cll.getLength());
		System.out.println("The CLL is: "+ cll.toString());
		
		System.out.println("The head and it's data is: "+ cll.head + " || data: "+ cll.head.getData());
		System.out.println("The tail and it's data is: "+ cll.tail + " || data: "+ cll.tail.getData());
		System.out.println("The tail link and it's data is: "+ cll.tail.getLink() + " || data: "+ cll.tail.getLink().getData());
	}
	
	private static void doubleLL() {
		DLLNode dllNode = new DLLNode(27);
		
		DoublyLinkedList dll = new DoublyLinkedList();		
		dll.insertAtEnd(new DLLNode(17));
		dll.insertAtEnd(new DLLNode(23));
		dll.insertAtEnd(new DLLNode(23));
		dll.insertAtEnd(new DLLNode(95));
		
		dll.insertAtBegining(dllNode);
		dll.insertAtBegining(new DLLNode(117));
		dll.insertAtBegining(new DLLNode(67));
		dll.insertAtBegining(new DLLNode(96));
		dll.insertAtBegining(new DLLNode(227));
		
		dll.insert(3, new DLLNode(33));
		dll.insert(0, new DLLNode(665));
		dll.insert(4, new DLLNode(1));
		dll.insert(dll.getLength(), new DLLNode(371));
		dll.insert(dll.getLength() - 1, new DLLNode(82));
		
		dll.deleteFromHead();
		dll.deleteFromHead();
		dll.deleteFromTail();
		dll.deleteFromTail();
		dll.insertAtBegining(new DLLNode(87));
		dll.deleteFromHead();
		dll.deleteFromHead();
		dll.delete(3);
		dll.delete(1);
		
		System.out.println("The DLL length is: "+ dll.getLength());
		System.out.println("The DLL is: " + dll.toString());
	}
	
	private static void singleLL() {

		LinkedList list = new LinkedList();
		list.insertAtBegining(new ListNode(23));
		list.insertAtBegining(new ListNode(37));
		list.insertAtEnd(new ListNode(99));
		list.insertAtEnd(new ListNode(117));
		System.out.println("List length: "+ list.getLength());
		System.out.println("head data: "+ list.getHead().getData());
		System.out.println("The list is: "+ list.toString());
		
		list.insertInBetween(new ListNode(67), 2);
		list.insertInBetween(new ListNode(44), 3);
		
		System.out.println("The list after adding is: "+ list.toString());
		System.out.println("List lengthafter adding : "+ list.getLength());
		
		list.removeFromHead();
		System.out.println("\n The list is: "+ list.toString());
		System.out.println("List lengthafter removing : "+ list.getLength());
		
		list.removeFromEnd();		
		System.out.println("\n The list is after removing: "+ list.toString());
		System.out.println("List length after removing : "+ list.getLength());
		
		list.removeFromBetween(2);
		System.out.println("\n The list is after removing pos: "+ list.toString());
		System.out.println("List length after removing pos: "+ list.getLength());
		
		list.removeMatched(new ListNode(999));
		System.out.println("\n The list is after removing matched: "+ list.toString());
		System.out.println("List length after removing matched: "+ list.getLength());

	
	}

}
