/**
 * 
 */
package com.salvation.concurrency.util;

import java.util.concurrent.CountDownLatch;

/**
 * @author sayanroy
 *
 */
public class Service implements Runnable {
	
	private CountDownLatch latch;
	
	private String serviceName;
	
	public Service(CountDownLatch latch, String serviceName) {
		super();
		this.serviceName = serviceName;
		this.latch = latch;
	}

	/* (non-Javadoc)
	 * @see java.lang.Runnable#run()
	 */
	@Override
	public void run() {
		try {
			System.out.println( "Bringing " + serviceName + "Up...");
			Thread.sleep(2500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println(serviceName + " Service is up ");
		latch.countDown();//reduce count of latch by 1.
	}

}
