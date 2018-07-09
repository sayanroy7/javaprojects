/**
 * 
 */
package com.salvation.heap;

/**
 * @author sayanroy
 *
 */
public class Executor {
	
	public static void main(String[] args) {
		System.out.println((2 - 1) / 2);
		
		Heap heap = new Heap(8);
		heap.insert(23);
		heap.insert(38);
		heap.insert(29);
		heap.insert(19);
		heap.insert(78);
		heap.insert(39);
		heap.insert(109);
		
		System.out.println(heap);
		System.out.println("Size: "+ heap.getSize());
		
		for (int i = 0; i < heap.getSize(); i++) {
			System.out.println("Parent index of "+ i + ": "+ heap.getParentIndex(i));
			System.out.println("Left child index of "+ i + ": "+ heap.getLeftChildIndex(i));
			System.out.println("Right child index of "+ i + ": "+ heap.getRightChildIndex(i));
		}
		
		System.out.println("heap max: "+ heap.getMaximum());
		heap.deleteMax();
		System.out.println("heap max: "+ heap.getMaximum());
		System.out.println(heap);
		
		for (int i = 0; i < heap.getSize(); i++) {
			System.out.println("Parent index of "+ i + ": "+ heap.getParentIndex(i));
			System.out.println("Left child index of "+ i + ": "+ heap.getLeftChildIndex(i));
			System.out.println("Right child index of "+ i + ": "+ heap.getRightChildIndex(i));
		}
	}

}
