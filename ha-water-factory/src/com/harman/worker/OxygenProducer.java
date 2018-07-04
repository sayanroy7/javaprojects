/**
 * 
 */
package com.harman.worker;

import java.util.Random;
import java.util.concurrent.BlockingQueue;

import com.harman.model.Hydrogen;
import com.harman.model.Oxygen;

/**
 * @author SAROY
 *
 */
public class OxygenProducer implements Runnable {
	
	BlockingQueue<Oxygen> oxygenQ;

	public OxygenProducer(BlockingQueue<Oxygen> oxygenQ) {
		this.oxygenQ = oxygenQ;
	}

	/* (non-Javadoc)
	 * @see java.lang.Runnable#run()
	 */
	@Override
	public void run() {
		Random r = new Random();
		while (true) {
			try {
				Oxygen o = new Oxygen(r.nextLong());
				Thread.sleep(1000);
				oxygenQ.put(o);
				//System.out.println("OxygenProducer.run().. Oxygen produced :: " + o);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
