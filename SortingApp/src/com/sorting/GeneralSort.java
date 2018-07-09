/**
 * 
 */
package com.sorting;

import java.util.Random;

/**
 * @author sayanroy
 *
 */
public class GeneralSort {

	private int[] arr;

	public GeneralSort(int[] arr) {
		this.arr = arr;
	}

	public int[] getArr() {
		return arr;
	}

	public void bubbleSort() {
		int in, out, length = arr.length;
		if (length > 0) {
			for (out = length - 1; out > 0; out--) {
				for (in = 0; in < out; in++) {
					if (arr[in] > arr[in + 1])
						swap(in, in + 1);
				}
			}
		}
	}

	public void selectionSort() {
		int in, out, min, length = arr.length;

		for (out = 0; out < length - 1; out++) {
			min = out;
			for (in = out + 1; in < length; in++) {
				if (arr[in] < arr[min]) {
					min = in;
				}
			}
			swap(min, out);
		}
	}
	
	public void insertionSort() {
		int value, hole, length = arr.length;
		for (int i = 1; i < length; i++) {
			value = arr[i];
			hole = i;
			while (hole > 0 && arr[hole - 1] > value) {
				arr[hole] = arr[hole - 1];
				hole = hole - 1; //shifting the hole index pointer to left <--- side.
			}
			arr[hole] = value;
		}
	}
	
	public void mergeSort(int [] arr) {
		int length = arr.length;
		if (length < 2) {
			return;
		}
		int mid = length % 2 == 0 ? length / 2 : length / 2 + 1;
		int [] left = new int[mid];
		int [] right = new int[length - mid];
		for (int i = 0; i < mid; i++) {
			left[i] = arr[i];
		}
		for (int i = mid; i < length; i++) {
			right[i - mid] = arr[i]; 
		}
		mergeSort(left);
		mergeSort(right);
		merge(arr, left, right);
	}
	
	public void quicksort(int [] arr) {
		quicksort(arr, 0, arr.length - 1);
	}
	
	private void quicksort(int[] arr, int start, int end) {
		if (start < end) {
			int pivotIndex = randonPartition(arr, start, end);
			quicksort(arr, start, pivotIndex - 1);
			quicksort(arr, pivotIndex + 1, end);
		}
	}
	
	private int randonPartition(int [] arr, int start, int end) {
		int pivotIndex = new Random().ints(start, end).findAny().getAsInt();
		swap(arr, pivotIndex, end);
		return partition(arr, start, end);
	}
	
	private int partition(int[] arr, int start, int end) {
		int pivot = arr[end];
		int pivotIndex = start;
		for (int i = start; i < end; i++) {
			if (arr[i] <= pivot) {
				swap(arr, i, pivotIndex);
				pivotIndex++;
			}
		}
		swap(arr, pivotIndex, end);
		return pivotIndex;
	}

	private void merge(int[] arr, int[] left, int [] right) {
		int leftLength = left.length;
		int rightLength = right.length;
		int leftIndex = 0, rightIndex = 0, arrIndex = 0;
		while (leftIndex < leftLength && rightIndex < rightLength) {
			if (left[leftIndex] <= right[rightIndex]) {
				arr[arrIndex] = left[leftIndex];
				leftIndex++;
			} else {
				arr[arrIndex] = right[rightIndex];
				rightIndex++;
			}
			arrIndex++;
		}
		while (leftIndex < leftLength) {
			arr[arrIndex] = left[leftIndex];
			leftIndex++;
			arrIndex++;
		}
		while (rightIndex < rightLength) {
			arr[arrIndex] = right[rightIndex];
			rightIndex++;
			arrIndex++;
		}
	}

	private void swap(int one, int two) {
		int temp = arr[one];
		arr[one] = arr[two];
		arr[two] = temp;
	}
	
	private void swap(int[] arr, int one, int two) {
		int temp = arr[one];
		arr[one] = arr[two];
		arr[two] = temp;
	}

}
