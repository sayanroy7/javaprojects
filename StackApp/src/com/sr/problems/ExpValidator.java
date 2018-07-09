/**
 * 
 */
package com.sr.problems;

import com.sr.CharArrayStack;
import com.sr.LinkedListStack;

/**
 * @author sayanroy
 *
 */
public class ExpValidator {

	public boolean validateParentheses(String input) {
		boolean result = true;
		int length = input.length();
		CharArrayStack stack = new CharArrayStack(length);
		for (int i = 0; i < length; i++) {
			char c = input.charAt(i);
			if (c == '(' || c == '{' || c == '[') {
				stack.push(c);
			} else if (c == ')' || c == '}' || c == ']') {
				char x = stack.pop();
				if (!isMatchingPair(x, c)) {
					return false;
				}
			}
		}

		if (stack.size() > 0) {
			result = false;
		}
		return result;
	}

	private boolean isMatchingPair(char x, char y) {
		boolean match = false;
		if (x == '(' && y == ')') {
			match = true;
		} else if (x == '{' && y == '}') {
			match = true;
		} else if (x == '[' && y == ']') {
			match = true;
		}
		return match;
	}

	public String infixToPostfix(String exp) {
		StringBuilder postfix = new StringBuilder();
		int length = exp.length();
		CharArrayStack stack = new CharArrayStack(length);
		for (int i = 0; i < length; i++) {
			char x = exp.charAt(i);
			if (Character.isLetterOrDigit(x)) {
				//this is operand
				postfix.append(x);
			} else if (x == ')') {
				while (!stack.isEmpty() && stack.peek() != '(') {
					char y = stack.pop();
					postfix.append(y);
				}
				char z = stack.pop();// popping the left parenthesis.
				if (!isMatchingPair(z, x)) {
					throw new RuntimeException("Invalid input exp.");
				}
			} else if (x == '(') {
				stack.push(x);
			} else {
				if (stack.isEmpty()) {
					stack.push(x);
				} else {
					while (!stack.isEmpty()
							&& (precedence(stack.peek()) >= precedence(x))
							&& stack.peek() != '(') {
						char z = stack.pop();
						postfix.append(z);
					}
					stack.push(x);
				}
			}
		}

		while (!stack.isEmpty()) {
			char z = stack.pop();
			postfix.append(z);
		}
		return postfix.toString();
	}

	private int precedence(char op) {
		switch (op) {
		case '-':
			return 1;
		case '+':
			return 1;
		case '%':
			return 2;
		case '/':
			return 2;
		case '*':
			return 2;
		default:
			return 0;
		}
	}
	
	public int evaluatePostfix(String postfix) {
		int length = postfix.length();
		LinkedListStack stack = new LinkedListStack();
		for (int i=0; i<length; i++) {
			char x = postfix.charAt(i);
			if (Character.isDigit(x)) {
				stack.push(Integer.parseInt(Character.toString(x)));
			} else if (x == '*') {
				int op1 = stack.pop();
				int op2 = stack.pop();				
				int res = op1 * op2;
				
				stack.push(res);
			} else if (x == '/') {
				int op1 = stack.pop();
				int op2 = stack.pop();				
				int res = op2 / op1;
				
				stack.push(res);
			} else if (x == '+') {
				int op1 = stack.pop();
				int op2 = stack.pop();				
				int res = op1 + op2;
				
				stack.push(res);
			} else if (x == '-') {
				int op1 = stack.pop();
				int op2 = stack.pop();				
				int res = op2 - op1;
				
				stack.push(res);
			}
		}
		return stack.pop();
	}
	
	public boolean isPalindrom(String string) {
		int length = string.length();
		int index = 0;
		boolean result = true;
		CharArrayStack stack = new CharArrayStack(length);
		for (int i=0; i<length; i++) {
			char x = string.charAt(i);
			stack.push(x);
		}
		
		while (!stack.isEmpty()) {
			char y = stack.pop();
			char x = string.charAt(index++);
			if (y != x) {
				result = false;
				break;
			}
		}
		
		if (index != length) {
			result = false;
		}
		return result;
	}
	
	//reverse the stack using recursion****
	public void reverse(CharArrayStack stack) {
		if (!stack.isEmpty()) {
			char temp = stack.pop();
			//creating recursive function call stack to hold all the popped elements
			reverse(stack);
			insertAtBottom(stack, temp);
		}
	}
	
	public void insertAtBottom(CharArrayStack stack, char c) {
		if (stack.isEmpty()) {
			stack.push(c);
		} else {
			char temp = stack.pop();
			insertAtBottom(stack, c);
			stack.push(temp);
		}
	}

	public static void main(String[] args) {
		ExpValidator validator = new ExpValidator();
		/*
		 * System.out.println(validator
		 * .validateParentheses("[a*b{(9+0)/(2b+3a)}]"));
		 * 
		 * CharArrayStack stack = new CharArrayStack(); stack.push('h');
		 * stack.push('e'); stack.push('l'); stack.push('l'); stack.push('o');
		 * 
		 * System.out.println("The stack is: " + stack);
		 */
		String infix = "1+2*3-5";//"a+b*c+d";
		String postfix = validator.infixToPostfix(infix);
		String palindrom = "tabbcbbatp";
		
		System.out.println("Postfix for " + infix + " string is: " + postfix);
		
		System.out.println("Evaluated postfix is: "+ validator.evaluatePostfix(postfix));
		
		System.out.println("Is the String : "+ palindrom + " palindrom? => "+ validator.isPalindrom(palindrom));
		
		CharArrayStack stack = new CharArrayStack("RENDER");
		System.out.println("The stack is : "+ stack);
		validator.reverse(stack);
		System.out.println("The reversed stack is: "+ stack);

	}

}
