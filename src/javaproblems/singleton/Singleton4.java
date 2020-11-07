package javaproblems.singleton;
/*
 * https://www.oracle.com/technical-resources/articles/java/singleton.html
 * 
 * By default creation of Enum instance is thread safe
 * but any other method on Enum is programmers responsibility.
 * Enum singleton
 * 
 * Serialization is gauranteed byJVM
 * 
 * 
 * *transient keyword*
 * 
 */
public enum Singleton4 {
	
	INSTANCE;
	
	public String getName() {
		return "MyName";
	}

}
