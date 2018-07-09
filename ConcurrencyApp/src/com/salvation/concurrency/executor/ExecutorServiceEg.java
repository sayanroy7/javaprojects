/**
 * 
 */
package com.salvation.concurrency.executor;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author sayanroy
 *
 */
public class ExecutorServiceEg {

	public static void main(String[] args) throws InterruptedException {
		cachedThreadPoolExecutor();
	}
	
	static void cachedThreadPoolExecutor() throws InterruptedException {
		ExecutorService executor = Executors.newCachedThreadPool();
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
	
	static void fixedTheadPoolExecutor() {
		ExecutorService executor = Executors.newFixedThreadPool(4);
		Task t1 = new Task("t1");
		Task t2 = new Task("t2");
		Task t3 = new Task("t3");
		Task t4 = new Task("t4");
		Task t5 = new Task("t5");
		Task t6 = new Task("t6");
		Task t7 = new Task("t7");
		Task t8 = new Task("t8");

		executor.submit(t1);
		executor.submit(t2);
		executor.submit(t3);
		executor.submit(t4);

		// Thread.sleep(2500);

		executor.submit(t5);
		executor.submit(t6);
		//Thread.sleep(2500);
		executor.shutdown();
		try {
			if (!executor.awaitTermination(10, TimeUnit.MILLISECONDS)) {
				List<Runnable> tasks = executor.shutdownNow();
				System.out.println("waiting task 1 " + tasks);
			}
		} catch (InterruptedException ie) {
			// (Re-)Cancel if current thread also interrupted
			System.out.println("waiting task 1 " + executor.shutdownNow());
		} finally {
			// preserve the interrupted status
			Thread.currentThread().interrupt();
		}
		executor.submit(t7);
		executor.submit(t8);
	}

}
