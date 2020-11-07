package com.algorithm;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;

public class PalindromeTest {

	@Test
	public void testIsPalindromeWithPalindromeString() {
		Palindrome palindrome = new Palindrome();
		assertTrue(palindrome.isPalindrome("WOW"));
	}
	
	@Test
	public void testIsPalindromeWithNotPalindromeString() {
		Palindrome palindrome = new Palindrome();
		assertFalse(palindrome.isPalindrome("W0"));
	}
	
}
