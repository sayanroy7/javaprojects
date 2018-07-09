/**
 * 
 */
package com.sr.problems;

import com.sr.LinkedListStack;

/**
 * @author sayanroy
 *
 */
public class Histogram {

	private int[] heights;
	
	public Histogram(int [] arr) {
		this.heights = arr;
	}

	public int getMaxRectangleArea() {
		LinkedListStack stack = new LinkedListStack();
		int index = 0, maxArea = 0;
		int length = heights.length;

		while (index < length) {
			if (stack.isEmpty() || heights[index] >= heights[stack.peek()]) {
				stack.push(index++);
			} else {
				int area = 0;
				int top = stack.pop();
				if (stack.isEmpty()) {
					area = heights[top] * index;
				} else {
					area = heights[top] * (index - stack.peek() - 1);
				}
				
				if (area > maxArea) {
					maxArea = area;
				}
			}
		}
		
		while (!stack.isEmpty())
	    {
	        int top = stack.pop();
	        int area_with_top = heights[top] * (stack.isEmpty() ? index: index - stack.peek() - 1);
	 
	        if (maxArea < area_with_top)
	        	maxArea = area_with_top;
	    }
		return maxArea;
	}
	
	public static void main(String[] args) {
		int [] arr = {2,3,1,2,1};
		Histogram h = new Histogram(arr);
		System.out.println("Max rectangle area: "+ h.getMaxRectangleArea());
	}

}
