/**
 * 
 */
package com.harman.worker;

import java.util.concurrent.BlockingQueue;

import com.harman.model.Hydrogen;
import com.harman.model.Oxygen;
import com.harman.model.Water;

/**
 * @author SAROY
 *
 */
public class PipelineConsumer implements Runnable {
	
	private BlockingQueue<Hydrogen> hydrogenQ;
	
	private BlockingQueue<Oxygen> oxygenQ;
	
	public PipelineConsumer(BlockingQueue<Hydrogen> hydrogenQ, BlockingQueue<Oxygen> oxygenQ) {
		this.hydrogenQ = hydrogenQ;
		this.oxygenQ = oxygenQ;
	}

	@Override
	public void run () {
		while (true) {
			try {
				Thread.sleep(5000); //taking 5 secs
				Water w = new Water(hydrogenQ.take(), hydrogenQ.take(), oxygenQ.take());
				System.out.println(Thread.currentThread().getName() + " ::: PipelineConsumer.run().. Water produced ::: "+ w);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
