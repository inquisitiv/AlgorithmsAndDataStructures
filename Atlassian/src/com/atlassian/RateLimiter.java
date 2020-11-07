package com.atlassian;

import java.util.HashMap;

public class RateLimiter {
	
	HashMap<Integer,Customer> map ;
	int limit;
	int timeUnitInms;
	
	
	public RateLimiter() {
		map = new HashMap<>();
		this.limit = 10;
		this.timeUnitInms = 60000;
	}
	
	public RateLimiter(int limit, int timeUnitInms) {
		map = new HashMap<>();
		this.limit = limit;
		this.timeUnitInms = timeUnitInms;
	}

	public boolean rateLimit(int customerId) {
		// TODO Auto-generated method stub
		if(map.containsKey(customerId)) {
			Customer cust = map.get(customerId); 
			return isAccessAllowed(cust);
		} else {
			Customer cust = new Customer(customerId);
			map.put(customerId, cust);
			return true;
		}
	
	}

	public boolean isCutomerPresent(int newCustomerId) {
		// TODO Auto-generated method stub
		return map.containsKey(newCustomerId);
	}
	
	public boolean isAccessAllowed(Customer cust) {
		
		long currTime = System.currentTimeMillis();
		if(currTime - cust.lastAccessTime < timeUnitInms) {
			if(cust.accessCount<limit) {
		      cust.accessCount = cust.accessCount+1;	
			  return true;
			} else {
				return false;
			}
		} else {
			cust.accessCount = 1;	
			cust.lastAccessTime = currTime;
			return true;
		}
		
	}

}
