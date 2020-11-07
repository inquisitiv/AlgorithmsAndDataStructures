package com.flowerBouqets;

import java.util.Arrays;

public class Solution {

	public static int[] t;

	public static void main(String[] args) {
		// Scanner input = new Scanner(System.in);
		// String s = input.nextLine();
		int p = 10;
		int q = 20;
		String s = "001101011";
		int n = s.length();
		t = new int[n];
		// Arrays.fill(t, -1);
		// System.out.println(maxFlowerBouqetsR(s,s.length(),p,q));
		Arrays.fill(t, 0);
		System.out.println(maxFlowerBouqetsT(s, s.length(), p, q));

	}

	public static boolean isType2(String s) {
		if (s.length() == 2) {
			if (s.charAt(0) != s.charAt(1)) {
				return true;
			}
		}
		return false;
	}

	public static boolean isType1(String s) {
		int count = 0;
		if (s.length() == 3) {
			for (int i = 0; i < s.length(); i++) {
				if (s.charAt(i) == '0') {
					count++;
				}
			}
		}
		if (count == 3) {
			return true;
		} else {
			return false;
		}
	}

	public static int maxFlowerBouqetsR(String s, int len, int p, int q) {

		if (s.length() < 2) {
			return 0;
		}
		if (s.length() == 2) {
			if (isType2(s)) {
				return q;
			} else {
				return 0;
			}
		} else if (s.length() == 3) {
			if (isType1(s)) {
				return p;
			} else {
				if (isType2(s.substring(1)) || isType2(s.substring(2))) {
					return q;
				} else {
					return 0;
				}
			}
		}
		if (t[len] != -1) {
			return t[len];
		}
		int n1 = 0;
		int n2 = 0;
		int n3 = 0;
		String st = "";

		st = s.substring(0, 3);
		if (isType1(st)) {
			n1 = p + maxFlowerBouqetsR(s.substring(3), s.length(), p, q);

		}
		st = s.substring(0, 2);
		if (isType2(st)) {
			n1 = q + maxFlowerBouqetsR(s.substring(2), s.length(), p, q);

		}
		n3 = maxFlowerBouqetsR(s.substring(1), s.length(), p, q);

		t[len] = Math.max(Math.max(n1, n2), n3);
		return t[len];

	}

	public static int maxFlowerBouqetsT(String s, int len, int p, int q) {

		if (s.length() < 1) {
			t[0] = 0;
		}
		t[len - 1] = 0;
		if (s.length() >= 2 && isType2(s.substring(len - 2))) {
			t[len - 2] = p;
		}
		if (s.length() >= 3) {
			if (isType1(s.substring(len - 3))) {
				t[len - 3] = p;
			} else {
				if (isType2(s.substring(len-3,len-1)) || isType2(s.substring(len-2))) {
					t[len - 3] = q;
				} else {
					t[len - 3] = 0;
				}
			}
            System.out.println(Arrays.toString(t));
			for (int i = len - 4; i >=0; i--) {
				int n1 = 0;
				int n2 = 0;
				int n3 = 0;
				if(isType1(s.substring(i,i+3))) {
					n3 = p + t[i+3];
				}
				if(isType2(s.substring(i,i+2))) {
					n2 = q + t[i+2];
				}
				n1 = t[i+1];
				
				t[i] = Math.max(Math.max(n1,n2), n3);
				System.out.println(Arrays.toString(t));
			}
		}
		return t[0];

	}

}
