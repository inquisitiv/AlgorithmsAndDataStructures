package javaproblems.singleton;

/*
 * https://www.oracle.com/technical-resources/articles/java/singleton.html
 * 
 * Double check locking - volatile keyword introduced in Java5 makes sure
 * value is always read from memory
 * 
 *  lazy loaded thread-safe Singleton
 * 
 */
public class Singleton3 {

	private static volatile Singleton3 instance;

	private Singleton3() {

	}

	public Singleton3 getInstance() {

		if (instance == null) {
			synchronized (Singleton3.class) {
				if (instance == null) {
					instance = new Singleton3();
				}
			}
		}
		return instance;

	}

}
