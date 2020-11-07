package javaproblems.singleton;

/*
 * https://www.oracle.com/technical-resources/articles/java/singleton.html
 * 
 * Lazy Initialization
 * 
 * 
 */
public class Singleton2 {
	
	private static Singleton2 instance;
	
	
	private Singleton2() {
		
	}
	
	public static synchronized Singleton2 getInstance() {
		if(instance==null) {
			instance = new Singleton2();
		}
		return instance;
	}

}
