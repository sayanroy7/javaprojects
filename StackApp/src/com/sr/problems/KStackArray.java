/**
 * 
 */
package com.sr.problems;

/**
 * @author sayanroy
 *
 */
public class KStackArray {
	
	private int[] arr;
	
	private int[] top;
	
	private int[] next;
	
	private int free;
	
	public KStackArray(int k, int size) {
		if (k > size) {
			throw new RuntimeException("Invalid specification! Size of array should be equal or greater than no. of stacks");
		}
		arr = new int[size];
		top = new int[k];
		next = new int[size];
		
		//Initialize all stack as empty. So, the top pointer of all stacks are initialized with -1
		for (int i=0; i<top.length; i++) {
			top[i] = -1;
		}
		
		free = 0;
		for (int j=0; j<next.length-1; j++) {
			next[j] = j+1;
		}
		next[size - 1] = -1; //This indicates the end of array.
	}
	
	public void push(int stackId, int data) {
		if (free == -1) {
			throw new RuntimeException("Stack is full!");
		} else {
			int i = free;
			free = next[i]; //Assigning the next index to free
			next[i] = top[stackId]; //Assigning the current top before insertion to next array. 
			//This will track the previous element of the array(the previous top of stack) for index 'i'
			top[stackId] = i; //Assigning the new inserted index as top of stack.
			
			//inserting the element in array
			arr[i] = data;
		}
	}
	
	public int pop(int stackId) {
		int topIndex = top[stackId];
		if (free == 0 || topIndex == -1) {
			throw new RuntimeException("Stack underflow");
		} else {
			int item = arr[topIndex]; //collecting the top element.
			arr[topIndex] = Integer.MIN_VALUE; //removing the element from stack.
			top[stackId] = next[topIndex]; //Assigning the index of previous element as top of stack. 
			//As next[] array stores the index of previous element of current TOS during PUSH operation.
			next[topIndex] = free; //Assigning the free item index as the next index of current TOS before popping. 
			//After popping this will act as next index and current TOS will point to the previous element
			free = topIndex; //setting free index as the index of topIndex as it is popped.
			
			return item;
		}
	}
	
	public int peek(int stackId) {
		int topIndex = top[stackId];
		if (free == 0 || topIndex == -1) {
			throw new RuntimeException("Stack underflow");
		} else {
			return arr[topIndex]; //returning the top element.
		}
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		int stacks = top.length;
		sb.append("[");
		for (int i=0; i<stacks; i++) {
			sb.append("Stack "+ i);
			sb.append(" = [");
			int topIndex = top[i];
			if (topIndex != -1) {
				while (topIndex != -1) {				
					sb.append(arr[topIndex]);
					topIndex = next[topIndex];//Assigning the previous element index
					if (topIndex != -1) {
						sb.append(", ");
					}
				}
			}			
			sb.append("]");
			if (i < stacks - 1) {
				sb.append(", ");
			}
		}
		sb.append("]");
		return sb.toString();
	}

}
