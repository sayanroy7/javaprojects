/**
 * 
 */
package com.sr.queue;

/**
 * @author sayanroy
 *
 */
public class FixedArrayQueue implements Queue {
	
	private static final int CAPACITY = 16;
	
	private int capacity;
	
	private int[] queue;
	
	private int size;
	
	private int front;
	
	private int rear;
	
	public FixedArrayQueue() {
		this(CAPACITY);
	}
	
	public FixedArrayQueue(int capacity) {
		this.capacity = capacity;
		queue = new int[capacity];
	}
	
	@Override
	public void enQueue(int data) {
		if (size == capacity) {
			throw new RuntimeException("Queue is full, Overflow!");
		} else {
			queue[rear] = data;
			rear = (rear + 1) % capacity;
			size++;
		}
	}
	
	@Override
	public int deQueue() {
		if (isEmpty()) {
			throw new RuntimeException("Queue is empty, underflow!");
		} else {
			int item = queue[front];
			queue[front] = Integer.MIN_VALUE;
			front = (front + 1) % capacity;
			size--;
			return item;
		}
	}
	
	@Override
	public int getSize() {
		return size;
	}
	
	@Override
	public boolean isEmpty() {
		return size == 0;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Queue is => [");		
		for (int i = 0; i < capacity; i++) {
			if (i == rear) {
				sb.append("REAR >> ");
			} if (i == front) {
				sb.append("FRONT >> ");
			}
			sb.append(queue[i]);
			if (i < capacity - 1) {
				sb.append(", ");
			}			
		}
		sb.append("]");
		return sb.toString();
	}

}
