/**
 * 
 */
package com.sr.queue;

/**
 * @author sayanroy
 *
 */
public class DynaArrayQueue implements Queue {

	private static final int CAPACITY = 16;

	private int capacity;

	private int[] queue;

	private int size;

	private int front, rear;

	public DynaArrayQueue() {
		this(CAPACITY);
	}

	public DynaArrayQueue(int capacity) {
		this.capacity = capacity;
		queue = new int[capacity];
	}

	@Override
	public void enQueue(int data) {
		if (isFull()) {
			expand();
		}

		queue[rear] = data;
		rear = (rear + 1) % capacity;
		size++;
	}

	private void expand() {
		int newCapacity = capacity << 1;
		int[] doubleQueue = new int[newCapacity];
		int index = front, i = front;
		while (i < capacity) {
			doubleQueue[i - front] = queue[index];
			index = (index + 1) % capacity;
			i++;
		}

		doubleQueue[i - front] = queue[rear]; // Copying the rear
		rear = capacity;
		front = 0;
		queue = doubleQueue;
		capacity = newCapacity;
	}

	@Override
	public int deQueue() {
		if (isEmpty()) {
			throw new RuntimeException("Queue is empty! Underflow");
		} else {
			int item = queue[front];
			queue[front] = Integer.MIN_VALUE;
			front = (front + 1) % capacity;
			size--;
			return item;
		}
	}

	@Override
	public boolean isEmpty() {
		return size == 0;
	}

	@Override
	public int getSize() {
		return size;
	}

	public boolean isFull() {
		return size == capacity;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("The queue is: [");
		for (int i = 0; i < capacity; i++) {
			if (i == front) {
				sb.append("FRONT >> ");
			}
			if (i == rear) {
				sb.append("REAR >> ");
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
