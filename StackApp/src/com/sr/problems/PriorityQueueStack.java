/**
 * 
 */
package com.sr.problems;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author sayanroy
 *
 */
public class PriorityQueueStack<V> {

	private PriorityQueue<Pair<Integer, V>> queue;

	int count;

	public PriorityQueueStack() {
		Comparator<Pair<Integer, V>> keyComparator = new Comparator<Pair<Integer, V>>() {
			public int compare(Pair<Integer, V> o1, Pair<Integer, V> o2) {
				return Math.negateExact(o1.getKey().compareTo(o2.getKey()));
			};
		};
		queue = new PriorityQueue<Pair<Integer, V>>(keyComparator);
	}

	public void push(V data) {
		queue.offer(new Pair<Integer, V>(++count, data));
	}

	public V pop() {
		if (queue.isEmpty()) {
			System.err.println("Nothing to pop! Stack uderflow");
			return null;
		}
		Pair<Integer, V> pair = queue.poll();
		count--;
		return pair.getValue();
	}

	private final class Pair<K, V1> {

		private K key;

		private V1 value;

		public Pair(K key, V1 value) {
			this.key = key;
			this.value = value;
		}

		public K getKey() {
			return key;
		}

		public V1 getValue() {
			return value;
		}
	}

}
