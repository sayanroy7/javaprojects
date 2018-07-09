/**
 * 
 */
package com.learning;

/**
 * @author sayanroy
 *
 */
public class OrderedArray {

	private int[] arr;

	private int nElems;

	public OrderedArray(int max) {
		super();
		arr = new int[max];
	}

	public int find(int searchKey) {
		int lowerBound = 0, upperBound = nElems - 1;
		while (true) {
			int currIn = (lowerBound + upperBound) / 2;
			if (arr[currIn] == searchKey) {
				return currIn; // Found
			} else if (lowerBound > upperBound) {
				return nElems; // Not found
			} else {
				if (arr[currIn] > searchKey) {
					upperBound = currIn - 1; // element is in the lower half.
				} else {
					lowerBound = currIn + 1; // element is in the upper half.
				}
			}
		}
	}

	public void insert(int val) {
		int i;
		for (i = 0; i < nElems; i++) {
			if (arr[i] > val) {
				break;
			}
		}
		for (int j = nElems; j > i; j--) { 
			// shifting higher elements to the right side.
			arr[j] = arr[j - 1];
		}
		arr[i] = val;
		nElems++;
	}
	
	public boolean delete(int key) {
		int keyIndex = find(key);
		if (keyIndex == nElems) {
			return false;
		}
		else {
			for (int i = keyIndex; i<nElems; i++) {
				arr[i] = arr[i+1]; //filling hole
			}
			nElems--;
			return true;
		}
	}
	
	public void display() {
		for (int i=0; i<nElems; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println("");
	}
	
}
