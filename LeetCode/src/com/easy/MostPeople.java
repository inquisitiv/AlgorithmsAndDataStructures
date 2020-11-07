package com.easy;

import java.util.*;

public class MostPeople {
	
	public static class Element implements Comparable<Element>{
		int year;
		boolean flag;
		
		
		public Element(int year, boolean flag) {
			
			this.year = year;
			this.flag = flag;
			
		}
		
		public String toString() {
			return String.valueOf(year);
		}

		@Override
		public int compareTo(Element o) {
			// TODO Auto-generated method stub
			if(this.year<o.year)
				return -1;
			if(this.year>o.year)
				return 1;
			if(this.year==o.year)
				return 0;
			return 0;
			
		}
	}
	
	public static void main(String[] args) {
		
		System.out.println(mostpeople(new int[][] {{1900,1956},{1910,1950},{1920,1955}}));
		
	}
	
	public static int mostpeople(int[][] people) {
		HashSet<Integer>[] cell = new HashSet<Integer>[9];
		 Element temp;
		List<Element> list = new ArrayList<Element>();
		for(int i=0; i< people.length ;i++) {
		    temp = new Element(people[i][0], true);
		    list.add(temp);
		    temp = new Element(people[i][1], false);
			list.add(temp);
		}
		System.out.println(list);
		Collections.sort(list);
	
		System.out.println(list);
		int year = 0;
		int max = 0;
		int count = 0;
		for(Element ele : list) {
		    
			if(ele.flag==true) {
				count++;
			} else {
				count--;
			}
			if(count>max) {
				max = count; 
				year = ele.year;
			}
			
		}
		int temp1 = (int)'2';
		System.out.println(temp1);
		return year;
	}

}
