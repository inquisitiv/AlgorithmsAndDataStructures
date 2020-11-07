package com.atlassian;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;

import com.atlassian.RateLimiter;

public class RateLimiterTest {

	//10 calls
	@Test
	public void testRateLimitIsCustomerAllowed() {
		RateLimiter rt = new RateLimiter();
		int customerId = 123;
		for(int i=0;i<rt.limit;i++) {
		 assertTrue(rt.rateLimit(customerId));
		}
		assertFalse(rt.rateLimit(customerId));
	}
	
	@Test
	public void testRateLimitInsertNewCustomer() {
		RateLimiter rt = new RateLimiter();
		int customerId = 123;
		for(int i=0;i<rt.limit;i++) {
		 assertTrue(rt.rateLimit(customerId));
		}
		assertFalse(rt.rateLimit(customerId));
		
		int newCustomerId = 345;
		assertFalse(rt.isCutomerPresent(newCustomerId));
		assertTrue(rt.rateLimit(newCustomerId));
		assertTrue(rt.isCutomerPresent(newCustomerId));
	}
	
	@Test
	public void testRateLimitFiveRequestsPer100Millisecond() {
		RateLimiter rt = new RateLimiter(5,100);
		int customerId = 123;
		for(int i=0;i<rt.limit;i++) {
		 assertTrue(rt.rateLimit(customerId));
		}
		assertFalse(rt.rateLimit(customerId));
		try {
			Thread.sleep(101);
			assertTrue(rt.rateLimit(customerId));
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
}
