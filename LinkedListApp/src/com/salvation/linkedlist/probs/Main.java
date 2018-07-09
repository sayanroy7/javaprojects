/**
 * 
 */
package com.salvation.linkedlist.probs;

/**
 * @author sayanroy
 *
 */
public class Main {

	public static void main(String[] args) {
		System.out.println("hashcode: "+ hash(16));
		System.out.println("hashcode: "+ hash(20));
		System.out.println(4^16);
	}
	
	static final int hash(int h) {
        return (h) ^ (h >>> 16);
    }
}
