/**
 * 
 */
package com.salvation.concurrency.probs;

import java.util.Random;

/**
 * @author sayanroy
 *
 */
public class Consumer implements Runnable {

	private Message messageQ;
	
	public Consumer(Message messageQ) {
		super();
		this.messageQ = messageQ;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Runnable#run()
	 */
	@Override
	public void run() {
		String message = null;
		Random random = new Random();
		do {
			message = messageQ.get();
			System.out.println(" Message recieved: "+ message);
			try {
				Thread.sleep(random.nextInt(1000));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		} while (!"END".equals(message));

	}

}
