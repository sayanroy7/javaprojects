package com.sr.problems;

public class Executor {

	public static void main(String[] args) {
		//kStackInOneArray();
		
		Histogram h = new Histogram(new int[]{2,3,4,4,1,2});
		System.out.println("The maxArea is: "+ h.getMaxRectangleArea());
		
		PQstack();
		System.out.println(1%2);
	}
	
	static void PQstack() {
		PriorityQueueStack<Integer> pstack = new PriorityQueueStack<Integer>();
		pstack.push(1264);
		pstack.push(123);
		pstack.push(53);
		pstack.push(68);
		pstack.push(19);
		
		System.out.println("POP: "+ pstack.pop());
	}
	
	static void kStackInOneArray() {
		KStackArray stack = new KStackArray(7, 7);
		stack.push(0, 14);
		stack.push(0, 9);
		stack.push(1, 7);
		stack.push(0, 29);		
		stack.push(1, 49);
		stack.push(2, 77);
		System.out.println("Stack pop: "+ stack.pop(0));
		stack.push(2, 54);
		
		System.out.println("The stack is : "+ stack);
		
		System.out.println("Stack pop: "+ stack.pop(1));
		
		System.out.println("The stack is : "+ stack);
		
		System.out.println("Stack 1 peek: "+ stack.peek(0));
		System.out.println("Stack 2 peek: "+ stack.peek(1));
		System.out.println("Stack 3 peek: "+ stack.peek(2));
		
		System.out.println("The stack is : "+ stack);
	}
	
	static void twoArr() {
		TwoStackArray ts = new TwoStackArray(5);
		System.out.println(ts);
		
		ts.push(1, 29);
		ts.push(2, 17);
		ts.push(2, 84);
		ts.push(2, 12);
		
		System.out.println(ts);
		System.out.println("peeking stack 1 => "+ ts.peek(1));
		System.out.println("peeking stack 2 => "+ ts.peek(2));
		
		System.out.println("Pop from stack 2 => "+ ts.pop(2));
		System.out.println("Pop from stack 1 => "+ ts.pop(1));
		//System.out.println("Pop from stack 1 => "+ ts.pop(1));
		
		//ts.push(2, 33);
		//ts.push(2, 44);
		//ts.push(2, 59);
		//ts.push(2, 26);
		//ts.push(2, 5);
		
		System.out.println(ts);
		System.out.println("peeking stack 2 => "+ ts.peek(2));
		
		System.out.println("Stack 1 length: "+ ts.getLength1());
		System.out.println("Stack 2 length: "+ ts.getLength2());
		
		System.out.println("peeking stack 2 => "+ ts.peek(2));	
	}

}
