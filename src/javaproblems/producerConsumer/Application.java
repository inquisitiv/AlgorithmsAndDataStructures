package javaproblems.producerConsumer;

/*
 * 1. You need to call wait() method on the object that you are locking on. it need not be the shared object
 * 2. Always call wait and notify from Loop Instead of If Block
 * 3. Access to shared data must be in the synchronized block
 */
public class Application {

	public static void main(String[] args) {

		ProducerConsumer pcObj = new ProducerConsumer();
		ProducerConsumerBlockingQueue pcObjBQ = new ProducerConsumerBlockingQueue();

		Thread producerThread = new Thread(new Runnable() {

			@Override
			public void run() {
				try {
					pcObj.produce();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		});

		Thread consumerThread = new Thread(new Runnable() {

			@Override
			public void run() {
				try {
					pcObj.consume();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		});

		Thread producerThreadBQ = new Thread(new Runnable() {

			@Override
			public void run() {
				try {
					pcObjBQ.produce();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		});

		Thread consumerThreadBQ = new Thread(new Runnable() {

			@Override
			public void run() {
				try {
					pcObjBQ.consume();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		});

		producerThread.start();
		consumerThread.start();
		
		producerThreadBQ.start();
		consumerThreadBQ.start();

		try {
			producerThread.join();
			consumerThread.join();
			producerThreadBQ.join();
			consumerThreadBQ.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
