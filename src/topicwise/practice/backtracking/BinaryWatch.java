package topicwise.practice.backtracking;

import java.util.*;

// https://leetcode.com/problems/binary-watch/

public class BinaryWatch {
	
	    public List<String> readBinaryWatch(int num) {
	        List<String> result = new ArrayList<String>();
	        int[] hours = new int[]{1,2,4,8};
	        int[] minutes = new int[]{1,2,4,8,16,32};
	        for(int i=0;i<=num;i++){
	            List<Integer> hrlist = generateDigits(hours,i);
	            List<Integer> minlist = generateDigits(minutes,num-i);
	            for(int num1: hrlist) {
	                if(num1 >= 12) continue;
	                for(int num2: minlist) {
	                    if(num2 >= 60) continue;
	                    result.add(num1 + ":" + (num2 < 10 ? "0" + num2 : num2));
	                }
	            }
	        }
	        return result;
	    }
	    
	    public List<Integer> generateDigits(int[] nums, int count) {
	        
	        List<Integer> res = new ArrayList<Integer>();
	        generateDigitsHelper(nums,0,0,res,count);
	        return res;
	        
	    }
	    
	    public void generateDigitsHelper(int[] nums, int index, int sum, List<Integer> res, int count) {
	       
	    
	       if(count==0){
	           res.add(sum);
	           return;
	       }
	       if(index>=nums.length){
	           return;
	       }
	       generateDigitsHelper(nums,index+1,sum+nums[index],res,count-1);
	       generateDigitsHelper(nums,index+1,sum,res,count);
	        
	    }
}
