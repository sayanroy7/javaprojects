/**
 * 
 */
package com.salvation.heap;

import java.util.Arrays;

/**
 * @author sayanroy
 *
 */
public class Heap {
	
	private int [] arr;
	
	private int count;
	
	private int capacity;

	public Heap(int capacity) {
		this.capacity = capacity;
		this.arr = new int [capacity];
	}
	
	public int getSize() {
		return count;
	}
	
	/**
	 * @param i - This is the element's position in array arr, 
	 * so i is basically the index of arr. 
	 * @return
	 */
	public int getParentIndex(int i) {
		if (i <= 0 || i >= count) {
			return Integer.MIN_VALUE;
		}
		return (i - 1) / 2;
	}
	
	/**
	 * @param i - This is the element's position in array arr, 
	 * so i is basically the index of arr.
	 * @return
	 */
	public int getLeftChildIndex(int i) {
		int leftChildIndex = 2 * i + 1;
		if (leftChildIndex >= count) {
			return Integer.MIN_VALUE;
		}
		return leftChildIndex;
	}
	
	public int getRightChildIndex(int i) {
		int rightChildIndex = 2 * i + 2;
		if (rightChildIndex >= count) {
			return Integer.MIN_VALUE;
		}
		return rightChildIndex;
	}
	
	public int getMaximum() {
		if (count == 0) {
			return Integer.MIN_VALUE;
		}
		return arr[0];
	}
	
	/**
	 * This is a heapifying algorithm. This starts from the top(problematic node) node
	 * and percolate down to the leaf until the heap property is restored.
	 * 
	 * LOGIC: check the left and right child of the current node. If either of them has
	 * greater key, then swap the key with current node. Continue this process until heap
	 * property is restored.
	 * 
	 * @param i - This is the element's position in array arr, 
	 * so i is basically the index of arr.
	 */
	public void percolateDown(int i) {
		if (i < 0 || i >= count) {
			return;
		}
		int left, right, max = i, temp;
		left = getLeftChildIndex(i);
		right = getRightChildIndex(i);
		if (left > 0 && arr[left] > arr[i]) {
			max = left;
		} else if (right > 0 && arr[right] > arr[max]) {
			max = right;
		}
		if (max != i) {
			temp = arr[max];
			arr[max] = arr[i];
			arr[i] = temp;
			percolateDown(max);
		}
	}
	
	/**
	 * Returns the index of the arr where the new item is inserted.
	 * 
	 * @param data
	 * @return
	 */
	public int insert(int data) {
		if (count == capacity) {
			throw new RuntimeException("Heap is full!");
		}
		int i = count++;
		while (i > 0 && data > arr[getParentIndex(i)]) {
			int pIndex = getParentIndex(i);
			arr[i] = arr[pIndex];
			i = pIndex;
		}
		arr[i] = data;
		return i;
	}
	
	/**
	 * Returns the max data after removing it from heap.
	 * 
	 * 
	 * @return
	 */
	public int deleteMax() {
		if (count == 0) {
			return Integer.MIN_VALUE;
		}
		int maxData = arr[0];
		arr[0] = arr[count - 1];
		arr[count - 1] = Integer.MIN_VALUE;
		count--;
		percolateDown(0);
		return maxData;
	}
	
	@Override
	public String toString() {
		return Arrays.toString(arr);
	}

}
