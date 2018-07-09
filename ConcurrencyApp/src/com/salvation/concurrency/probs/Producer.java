/**
 * 
 */
package com.salvation.concurrency.probs;

import java.util.Random;

/**
 * @author sayanroy
 *
 */
public class Producer implements Runnable {
	
	private Message messageQ;
	
	public Producer(Message messageQ) {
		super();
		this.messageQ = messageQ;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Runnable#run()
	 */
	@Override
	public void run() {
		String[] messages = { "mssg1", "mssg2", "mssg3", "mssg4", "mssg5",
				"mssg6", "mssg7", "mssg8", "mssg9", "mssg10" };
		Random random = new Random();
		int counter = 1;
		while(true) {
			messageQ.put("mssge - "+ counter++);
			try {
				Thread.sleep(random.nextInt(1000));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		//messageQ.put("END");

	}

}
