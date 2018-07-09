package com.salvation.concurrency.locks;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ConcurrentLock {

	private final String name;

	private final Lock lock = new ReentrantLock();

	public ConcurrentLock(String name) {
		super();
		this.name = name;
	}

	public void first(ConcurrentLock another) {
		Boolean myLock = lock.tryLock();
		Boolean anotherLock = another.lock.tryLock();
		try {
			if (myLock && anotherLock) {
				System.out.println(Thread.currentThread().getId() + " => "
						+ name + " : This is first");
				another.last(this);
			}
		} finally {
			if (myLock) {
				lock.unlock();
			}
			if (anotherLock) {
				another.lock.unlock();
			}
		}
	}

	public void last(ConcurrentLock another) {
		System.out.println(Thread.currentThread().getName() + " => " + name
				+ " : last");
	}

}
