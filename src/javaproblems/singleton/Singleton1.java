package javaproblems.singleton;

/*
 * https://www.oracle.com/technical-resources/articles/java/singleton.html
 * 
 * Static Class loading
 * 
 * 
 */
public class Singleton1 {
	
	private static final Singleton1 instance = new Singleton1();
	
	
	private Singleton1() {
		
	}
	
	// static func hence cannot be sub classed
	public static Singleton1 getInstance() {
		return instance;
	}

}
