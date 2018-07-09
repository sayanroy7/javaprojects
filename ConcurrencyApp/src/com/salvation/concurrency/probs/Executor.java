/**
 * 
 */
package com.salvation.concurrency.probs;

/**
 * @author sayanroy
 *
 */
public class Executor {

	/**
	 * @param args
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws InterruptedException {
		Message mq = new Message();
		Runnable producer = new Producer(mq);
		Runnable consumer = new Consumer(mq);
		
		Thread t1 = new Thread(producer);
		Thread t2 = new Thread(consumer);
		
		t1.start();
		t2.start();
		
		System.out.println(Thread.currentThread().getName() + " is exiting!");
		//t1.join();
		//t2.join();
	}

}
