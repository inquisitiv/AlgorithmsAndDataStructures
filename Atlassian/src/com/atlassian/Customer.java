package com.atlassian;


public class Customer {

	int id;
	long lastAccessTime;
	int accessCount;
	
	public Customer(int id) {
		this.id = id;
		this.lastAccessTime = System.currentTimeMillis();
		accessCount = 1;
	}
	
}
