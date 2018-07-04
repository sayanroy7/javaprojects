/**
 * 
 */
package com.harman;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

import com.harman.model.Hydrogen;
import com.harman.model.Oxygen;
import com.harman.worker.HydrogenProducer;
import com.harman.worker.OxygenProducer;
import com.harman.worker.PipelineConsumer;

/**
 * @author SAROY
 *
 */
public class WaterFactoryApplication {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		BlockingQueue<Hydrogen> hydrogenQ = new ArrayBlockingQueue<>(500);
		BlockingQueue<Oxygen> oxygenQ = new ArrayBlockingQueue<>(500);
		
		Runnable hydroProducer = new HydrogenProducer(hydrogenQ);
		Runnable oxyProducer = new OxygenProducer(oxygenQ);
		Thread hydroProducerThread = new Thread(hydroProducer);
		Thread oxyProducerThread = new Thread(oxyProducer);
		
		//starting the producers which will infinitely keep producinf Hydrogen and Oxygen
		hydroProducerThread.start();
		oxyProducerThread.start();
		
		Runnable waterConsumer = new PipelineConsumer(hydrogenQ, oxygenQ);
		for (int k=0; k<5; k++) {
			for (int i=0; i<10; i++) {
				Thread pc = new Thread(waterConsumer);
				pc.setName("Pipeline Consumer - "+ k + "_"+ i);
				pc.start();
			}
			try {
				//starting 10 threads after every one sec with 5 iterations
				Thread.sleep(1000);
			} catch (InterruptedException e) {				
				e.printStackTrace();
			}
		}
		
		System.out.println("Main ending ===================================================");
	}

}
