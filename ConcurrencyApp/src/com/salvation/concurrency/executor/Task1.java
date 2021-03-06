/**
 * 
 */
package com.salvation.concurrency.executor;

import java.util.concurrent.ThreadLocalRandom;

/**
 * @author sayanroy
 *
 */
public class Task1 implements Runnable {
	
	private String task;
	
	public Task1(String task) {
		this.task = task;
	}
	
	public String getTask() {
		return task;
	}

	/* (non-Javadoc)
	 * @see java.lang.Runnable#run()
	 */
	@Override
	public void run() {
		ThreadLocalRandom random = ThreadLocalRandom.current();
		for (int i = 0; i < 5; i++) {
			System.out.println(Thread.currentThread().getId() + " : " + task + " run().. "+ i);
			try {
				Thread.sleep(random.nextLong(3000));
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
