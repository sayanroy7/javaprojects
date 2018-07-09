/**
 * 
 */
package com.sorting;

import java.util.Arrays;

/**
 * @author sayanroy
 *
 */
public class LinearSort {
	
	//Assuming the arr have all +ve integers and doesn't contain element < 0
	public static int[] countingSort(int [] arr, int k) {
		int [] c = new int[k];
		int length = arr.length;
		for (int i = 0; i < length; i++) {
			c[arr[i]] = c[arr[i]] + 1;
		}//adding the occurrence count to 'c' array.
		for (int i = 1; i < k; i++) {
			c[i] = c[i] + c[i - 1];
		}//adding up the previous value with the current and assigning it back to current.
		//now the 'c' array holds all the relative count of the possible occurrence.
		
		//assigning the element of arr according to it;s relative index value
		//in array 'c'. 
		int [] b = new int [length];
		for (int i = length - 1; i >= 0; i--) {
			b[c[arr[i]] - 1] = arr[i];
			//decrementing by 1 after arranging and assinging in the output array.
			c[arr[i]] = c[arr[i]] - 1; 
		}
		return b;
	}
	
	public static void main(String[] args) {
		int [] arr = {2,3,5,1,3,5,2,5,1,0};
		System.out.println("before sorting: " + Arrays.toString(arr));
		System.out.println("after sorting: "+ Arrays.toString(countingSort(arr, 6)));
	}

}
