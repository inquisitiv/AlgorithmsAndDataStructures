package javaproblems.producerConsumer;

import java.util.LinkedList;
import java.util.Random;

public class ProducerConsumer {

	LinkedList<Integer> buffer = new LinkedList<Integer>();
	int bufferSize = 15;
	Object lock = new Object();

	public void produce() throws InterruptedException {

		Random random = new Random();
		int count = 1;
		while (true) {

			synchronized (lock) {
				while (buffer.size() == bufferSize) {
					lock.wait();
				}
				buffer.add(count++);
				System.out.println("Produced : " + count);
				lock.notify();

			}
			Thread.sleep(random.nextInt(500));

		}

	}

	public void consume() throws InterruptedException {
		// TODO Auto-generated method stub

		Random random = new Random();
		while (true) {
			synchronized (lock) {
				while (buffer.size() == 0) {
					lock.wait();
				}

				System.out.println("Consumed : " + buffer.removeFirst());
				lock.notify();

			}
			Thread.sleep(random.nextInt(1000));
		}

	}
}
