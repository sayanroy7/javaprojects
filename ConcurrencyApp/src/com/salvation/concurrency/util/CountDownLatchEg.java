/**
 * 
 */
package com.salvation.concurrency.util;

import java.util.concurrent.CountDownLatch;

/**
 * @author sayanroy
 *
 */
public class CountDownLatchEg {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		CountDownLatch latch = new CountDownLatch(3);
		
		Service catcheService = new Service(latch, "cache");
		Service alertService = new Service(latch, "alert");
		Service validatorService = new Service(latch, "Validator");
		
		new Thread(alertService).start();
		new Thread(catcheService).start();
		new Thread(validatorService).start();
		
		//main threading will await for all the services to be up.
		try {
			System.out.println( "Main is going to await...");
			latch.await();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("Main thread executing! all services are up");

	}

}
