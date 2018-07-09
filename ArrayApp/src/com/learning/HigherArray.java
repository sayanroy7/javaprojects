/**
 * 
 */
package com.learning;

/**
 * @author sayanroy
 *
 */
public class HigherArray {
	
	private int [] arr;
	
	private int nElems;

	public HigherArray(int max) {
		super();
		this.arr = new int[max];
	}
	
	public void insert(int val){
		arr[nElems] = val;
		nElems++;
	}
	
	public boolean find(int key){
		int i;
		for (i=0; i<nElems ; i++) {
			if (arr[i] == key) 
				break;			
		}
		if (i == nElems){
			return false;
		}
		return true;
	}
	
	public boolean delete(int key) {
		int i,j;
		for (i=0; i<nElems ; i++) {
			if (arr[i] == key) 
				break;			
		}
		if (i == nElems){
			return false;
		}
		else {
			for (j=i ; j<nElems ; j++)
				arr[j] = arr[j + 1]; //Shifting elements to left side
			nElems--; //Reducing size
			return true;
		}
	}
	
	public void display() {
		for (int i = 0; i<nElems ; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println("");
	}
	
	
 
}
