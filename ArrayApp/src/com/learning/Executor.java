/**
 * 
 */
package com.learning;

/**
 * @author sayanroy
 *
 */
public class Executor {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int max = 100;
		OrderedArray arr = new OrderedArray(max);
		arr.insert(70);
		arr.insert(110);
		arr.insert(30);
		arr.insert(90);
		arr.insert(210);
		arr.insert(57);
		arr.insert(3);
		arr.insert(88);
		arr.insert(192);
		
		arr.display(); //display all
		
		System.out.println(" Is 40 available? " + arr.find(192));
		
		
		System.out.println(arr.delete(88));
		
		arr.insert(-19);
		
		arr.display(); //display all

	}

}
