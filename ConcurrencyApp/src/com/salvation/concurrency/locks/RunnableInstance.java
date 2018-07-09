/**
 * 
 */
package com.salvation.concurrency.locks;

import java.util.Random;

/**
 * @author sayanroy
 *
 */
public class RunnableInstance implements Runnable {
	
	private ConcurrentLock lock1;
	
	private ConcurrentLock lock2;

	public RunnableInstance(ConcurrentLock lock1, ConcurrentLock lock2) {
		super();
		this.lock1 = lock1;
		this.lock2 = lock2;
	}

	/* (non-Javadoc)
	 * @see java.lang.Runnable#run()
	 */
	@Override
	public void run() {
		Random random = new Random();
		while (true) {
			try {
				Thread.sleep(random.nextInt(500));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			lock1.first(lock2);
		}

	}

}
