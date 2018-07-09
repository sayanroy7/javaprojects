/**
 * 
 */
package com.salvation.concurrency.locks;

/**
 * @author sayanroy
 *
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		final ConcurrentLock lock1 = new ConcurrentLock("lock1");
		final ConcurrentLock lock2 = new ConcurrentLock("lock2");
		
		RunnableInstance ri = new RunnableInstance(lock1, lock2);
		RunnableInstance ri2 = new RunnableInstance(lock2, lock1);
		
		new Thread(ri).start();
		new Thread(ri2).start();

	}

}
