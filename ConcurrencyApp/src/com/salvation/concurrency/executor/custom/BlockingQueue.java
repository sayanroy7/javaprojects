/**
 * 
 */
package com.salvation.concurrency.executor.custom;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author sayanroy
 *
 */
public class BlockingQueue<T extends Runnable> {
	
	private final Queue<T> queue = new LinkedList<T>();
	
	//count == EMPTY means queue is empty
	private int EMPTY = 0;
	
	//-1 indicates unbounded queue.
	private int MAX_CAPACITY = -1;
	
	final ReentrantLock lock = new ReentrantLock();
	
	private final Condition notFull = lock.newCondition();
	
	private final Condition notEmpty = lock.newCondition();
	
	private int count;
	
	public BlockingQueue(int capacity) {
		this.MAX_CAPACITY = capacity;
	}
	
	public BlockingQueue() {
		//this is for unbounded blocking queue.
	}
	
	public void put(T task) {
		final ReentrantLock lock = this.lock;
		lock.lock();
		try {
			while (count == MAX_CAPACITY) {
				notFull.await();
			}
			queue.offer(task);
			count++;
			notEmpty.signalAll();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			lock.unlock();
		}
	}
	
	public T take() {
		T task = null;
		final ReentrantLock lock = this.lock;
		lock.lock();
		try {
			while (count == EMPTY) {
				notEmpty.await();
			}
			task = queue.poll();
			count--;
			notFull.signalAll();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			lock.unlock();
		}
		return task;
	}

}
