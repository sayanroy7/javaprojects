/**
 * 
 */
package com.salvation.concurrency.util;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @author sayanroy
 *
 */
public class CyclicBarrierEg {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		CyclicBarrier barrier = new CyclicBarrier(3, new Runnable() {			
			@Override
			public void run() {
				System.out.println("Barrier has tripped! All parties arrived at the barrier");
			}
		});
		
		new Thread(new Worker(barrier), "Thread - 1").start();
		new Thread(new Worker(barrier), "Thread - 2").start();
		new Thread(new Worker(barrier), "Thread - 3").start();
		
		

	}
	
	private static final class Worker implements Runnable {
		
		private CyclicBarrier barrier;
		
		public Worker(CyclicBarrier barrier) {
			this.barrier = barrier;
		}

		@Override
		public void run() {
			System.out.println(Thread.currentThread().getName() + " is waiting on barrier!");
			try {
				Thread.sleep(2500);
				barrier.await();
				System.out.println(Thread.currentThread().getName() + " has crossed the barrier!");
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (BrokenBarrierException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}			
		}		
	}
}
