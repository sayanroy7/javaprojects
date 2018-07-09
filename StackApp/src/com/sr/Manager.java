package com.sr;

public class Manager {

	public static void main(String[] args) {
		// System.out.println(1<<15);

		dynaArrayStack();
		//linkedListStack();
	}
	
	static void linkedListStack() {
		LinkedListStack stack = new LinkedListStack();
		
		System.out.println("Stack is : "+ stack);
		//System.out.println("Pop: "+ stack.pop());
		stack.push(33);
		System.out.println("Stack is : "+ stack);
		stack.push(21);
		stack.push(17);
		System.out.println("Stack is : "+ stack);
		System.out.println("peek: "+ stack.peek());
		System.out.println("Pop: "+ stack.pop());
		System.out.println("Stack is : "+ stack);
		System.out.println("peek: "+ stack.peek());
		stack.push(97);
		System.out.println("Stack is : "+ stack);
		System.out.println("Length is: "+ stack.getLength());
	}

	static void dynaArrayStack() {
		DynamicArrayStack stack = new DynamicArrayStack(3);

		stack.push(13);
		stack.push(29);

		stack.push(88);
		stack.push(18);
		stack.push(48);

		System.out.println("stack is: " + stack);

		System.out.println("stack size: " + stack.getSize());
		System.out.println("empty stack? " + stack.isEmpty());

		System.out.println("peek: " + stack.peek());
		System.out.println("pop 1: " + stack.pop());
		System.out.println("stack is: " + stack);
		System.out.println("pop 2: " + stack.pop());
		System.out.println("stack is: " + stack);
		// System.out.println("pop 3:"+ stack.pop());

		System.out.println("stack is: " + stack);

		System.out.println("stack size: " + stack.getSize());
		System.out.println("empty stack? " + stack.isEmpty());

		stack.push(88);
		stack.push(18);
		stack.push(48);
		System.out.println("stack is: " + stack);

		System.out.println("stack size: " + stack.getSize());
		stack.push(8);

		System.out.println("stack is: " + stack);

		System.out.println("stack size: " + stack.getSize());
	}

	static void fixedArrayStack() {
		FixedArrayStack stack = new FixedArrayStack(3);

		stack.push(13);
		stack.push(29);

		System.out.println("stack is: " + stack);

		System.out.println("stack size: " + stack.getSize());
		System.out.println("empty stack? " + stack.isEmpty());

		System.out.println("peek: " + stack.peek());
		System.out.println("pop 1: " + stack.pop());
		System.out.println("stack is: " + stack);
		System.out.println("pop 2: " + stack.pop());
		System.out.println("stack is: " + stack);
		// System.out.println("pop 3:"+ stack.pop());

		System.out.println("stack is: " + stack);

		System.out.println("stack size: " + stack.getSize());
		System.out.println("empty stack? " + stack.isEmpty());

		stack.push(88);
		stack.push(18);
		stack.push(48);
		stack.push(8);
	}

}
