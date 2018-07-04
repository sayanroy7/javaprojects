/**
 * 
 */
package com.harman.worker;

import java.util.Random;
import java.util.concurrent.BlockingQueue;

import com.harman.model.Hydrogen;

/**
 * @author SAROY
 *
 */
public class HydrogenProducer implements Runnable {

	BlockingQueue<Hydrogen> hydrogenQ;

	public HydrogenProducer(BlockingQueue<Hydrogen> hydrogeQ) {
		this.hydrogenQ = hydrogeQ;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Runnable#run()
	 */
	@Override
	public void run() {
		Random r = new Random();
		while (true) {
			try {
				Hydrogen h = new Hydrogen(r.nextLong());
				Thread.sleep(1000);
				hydrogenQ.put(h);
				//System.out.println("HydrogenProducer.run().. Hydrogen produced :: " + h);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
