/**
 * 
 */
package com.salvation.concurrency.executor.custom;

import com.salvation.concurrency.executor.Task;
import com.salvation.concurrency.executor.Task1;

/**
 * @author sayanroy
 *
 */
public class Main {

	/**
	 * @param args
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws InterruptedException {
		ThreadPool executor = new ThreadPool(2, 4);
		Task1 t1 = new Task1("t1");
		Task1 t2 = new Task1("t2");
		Task t3 = new Task("t3");
		Task t4 = new Task("t4");
		Task1 t5 = new Task1("t5");
		Task t6 = new Task("t6");
		Task1 t7 = new Task1("t7");
		Task t8 = new Task("t8");
		
		executor.submit(t1);
		executor.submit(t2);
		executor.submit(t3);
		executor.submit(t4);

		Thread.sleep(2500);

		executor.submit(t5);
		executor.submit(t6);
		Thread.sleep(15000);
		
		executor.submit(t7);
		executor.submit(t8);

	}

}
