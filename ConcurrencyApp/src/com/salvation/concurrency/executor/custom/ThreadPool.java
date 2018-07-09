/**
 * 
 */
package com.salvation.concurrency.executor.custom;

/**
 * @author sayanroy
 *
 */
public class ThreadPool {

	private BlockingQueue<Runnable> queue;

	public ThreadPool(int queueSize, int poolSize) {
		queue = new BlockingQueue<Runnable>(queueSize);
		String threadName = null;
		for (int i = 0; i < poolSize; i++) {
			threadName = "Thread - " + i;
			Worker worker = new Worker();
			Thread thread = new Thread(worker, threadName);
			thread.start();
		}
	}

	public ThreadPool(int poolSize) {
		// use this contructor for unbounded task queue.
		this(-1, poolSize);
	}

	public void submit(Runnable task) {
		queue.put(task);
	}

	private final class Worker implements Runnable {

		@Override
		public void run() {
			// continuous loop as long as the worker's are alive
			while (true) {
				String name = Thread.currentThread().getName();
				Runnable task = queue.take();
				System.out.println("Task started by thread: " + name);
				task.run();
				System.out.println("Task completed by thread: " + name);
			}
		}
	}
}
