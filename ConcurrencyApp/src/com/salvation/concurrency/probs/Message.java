/**
 * 
 */
package com.salvation.concurrency.probs;

import java.util.LinkedList;

/**
 * @author sayanroy
 *
 */
public class Message {

	private static final int MAX_SIZE = 5;

	// shared message queue
	private LinkedList<String> q = new LinkedList<String>();

	// If the size is 0, then consumer should wait until notified by the
	// producer
	// and check the size before consuming.
	// If the size is equal to MAX_SIZE then the producer should wait until
	// notified
	// by the consumer and check the size before producing.
	private volatile int size;

	public String get() {
		synchronized (this) {
			while (size == 0) {
				try {
					wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			size--;
			String message = q.poll();
			notifyAll();
			return message;
		}
	}

	public void put(String message) {
		synchronized (this) {
			while (size == MAX_SIZE) {
				try {
					wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			size++;
			q.offer(message);
			notifyAll();
		}
	}

}
