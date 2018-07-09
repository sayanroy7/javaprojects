/**
 * 
 */
package com.salvation.probs;

/**
 * @author sayanroy
 *
 */
public class ArrayProbs {
	
	/**
	 * This is also known as Kadane's algorithm.
	 * 
	 * The alogrithm is to find the maximum sum subarray in the given array.
	 * A subarray in an array is collection of contiguous elements. Accroding to 
	 * kadanes' algo - for any array element X the maximum sum subarray would be
	 * either [X] or [M,X] where - M is the maximum subarray of the previous element of X
	 * 
	 * @param arr
	 * @return
	 */
	public static int maximumSubArraySum(int[] arr) {
		int length = arr.length;
		int prevMaxSum = arr[0], globalMaxSum = arr[0];
		for (int i = 1; i < length; i++) {
			int current = arr[i];
			int sum = current + prevMaxSum;
			prevMaxSum = sum > current ? sum : current;
			if (globalMaxSum < prevMaxSum) {
				globalMaxSum = prevMaxSum;
			}
		}
		return globalMaxSum;
	}
	
	public static int searchInSortedAndRotatedArray(int [] arr, int x) {
		int length = arr.length, low = 0, high = length - 1;
		while (low <= high) {
			int mid = (low + high) / 2;
			if (arr[mid] == x) {
				return mid;
			}
			//This right side of mid is sorted.
			if (arr[mid] < arr[high]) {
				//if the item 'x' lies in the right side
				if (x > arr[mid] && x <= arr[high]) {
					low = mid + 1;
				} else {
					high = mid - 1;
				}
			}
			//The left side of mid is sorted
			else /*if (arr[mid] > arr[low])*/ {
				//if the item 'x' lies in the left side
				if (x >= arr[low] && x < arr[mid]) {
					high = mid - 1;
				} else {
					low = mid + 1;
				}
			}
		}
		return -1;
	}
	
	
	public static void main(String[] args) {
		int [] arr = {1,-2,2,1,-3,2};
		System.out.println("Max sum: "+ maximumSubArraySum(arr));
		
		int [] arr1 = {40, 50, 60, 70, 80, 10, 20, 30};
		System.out.println("Item 50 is at - " + searchInSortedAndRotatedArray(arr1, 40));
	}

}
