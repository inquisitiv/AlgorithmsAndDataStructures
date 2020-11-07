package javaproblems.producerConsumer;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

// no need of synchronization code, waiting and notify

public class ProducerConsumerBlockingQueue {

	private BlockingQueue<Integer> queue = new ArrayBlockingQueue<Integer>(10);
	
	public void produce() throws InterruptedException {
		int count = 0;
		while(true) {
			queue.put(count++); //put method waits on the lock if queue is full
			Thread.sleep(500);
		}
	}
	
    public void consume() throws InterruptedException {
    	while(true) {
			int val = queue.take(); //take method waits on the lock if queue is empty
			System.out.println("Value consumed: " + val +" Size of queue : " + queue.size());
			Thread.sleep(1000);
		}
	}	
	
	
	
	
}
