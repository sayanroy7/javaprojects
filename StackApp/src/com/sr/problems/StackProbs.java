/**
 * 
 */
package com.sr.problems;

import java.util.Arrays;

import com.sr.LinkedListStack;
import com.sr.Stack;

/**
 * @author sayanroy
 *
 */
public class StackProbs {

	public static int[] calculateSpan(int[] price) {
		Stack stack = new LinkedListStack();
		// span array
		int length = price.length;
		int[] span = new int[length];
		stack.push(0);

		// setting stock span for the first (left most) which would be always 1
		span[0] = 1;

		// setting span for the rest of the stock prices
		for (int i = 1; i < length; i++) {
			while (!stack.isEmpty() && price[stack.peek()] <= price[i]) {
				stack.pop();
			}
			// assigning the span of i.
			span[i] = stack.isEmpty() ? i + 1 : i - stack.peek();
			// pushing index of current price to stack.
			stack.push(i);
		}
		return span;
	}

	/**
	 * Given a string consisting of opening and closing parenthesis, find length
	 * of the longest valid parenthesis substring. Examples:
	 * 
	 * Input : ((() Output : 2 Explanation : ()
	 * 
	 * Input: )()()) Output : 4 Explanation: ()()
	 * 
	 * Input: ()(())))) Output: 6 Explanation: ()(())
	 * 
	 * LOGIC: declare a stack and use it to store the index of starting/opening
	 * bracket. Start with -1 as a base for storing valid index value.
	 * 
	 * Keep scanning the 'str' -> if the char is '(' then push it to stack. else
	 * - pop from stack. If the stack is not empty, then find length of current
	 * valid substring {by subtracting => i - stack.peek()}.
	 * 
	 * if it is greater than current max, then update max. If stack is empty,
	 * push current index as base for next valid substring.
	 * 
	 * TIME COMPLEXITY : O(n)
	 * 
	 * @param str
	 * @return
	 */
	public static int findLengthOfLongestValidSubstring(String str) {
		int result = 0;
		Stack stack = new LinkedListStack();
		stack.push(-1); // this will act as a base for next valid substring.

		// traverse the given string for each character in it
		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			if (c == '(') {
				stack.push(i);
			} else {
				// pop previous '(' index
				stack.pop();

				// if stack is not empty find the length of current valid
				// substring
				if (!stack.isEmpty()) {
					int currentValidSubstringLength = i - stack.peek();
					// comparing it with existing 'result' and assigning the max
					// value.
					result = Math.max(currentValidSubstringLength, result);
				} else {
					// else pushing the index as base for next valid substring.
					stack.push(i);
				}
			}
		}
		return result;
	}

	public static void main(String[] args) {
		int[] prices = { 100, 80, 60, 70, 60, 75, 85 };
		System.out.println("span for these stocks - "
				+ Arrays.toString(calculateSpan(prices)));
		System.out.println("find max length: "+ findLengthOfLongestValidSubstring("()(())))))))((()"));
	}
}
