package com.easy;

import java.util.*;

class Solution2Sum {

	public static void main(String[] args) {

		System.out.println(threeSum(new int[] {1,-1,-1,0}));

	}

    public static List<List<Integer>> threeSum(int[] nums) {
		HashSet<Integer> setInt = new HashSet<Integer>();
        HashSet<String> set = new HashSet<String>();
		List<List<Integer>> list = new ArrayList<List<Integer>>();
        
        for (int i = 0; i < nums.length; i++) {
            setInt.add(nums[i]);
        }

        if(setInt.size()==1 && nums.length>2){
            if (nums[0] == 0) {
            List<Integer> temp =new ArrayList<Integer>();
            temp.add(nums[0]);
            temp.add(nums[0]);
            temp.add(nums[0]);
            list.add(temp);
            return list;
            } else {
                return list;
            }
        }
        if(nums.length==3) {
            int sum =0;
            List<Integer> temp =new ArrayList<Integer>();
            for (int i = 0; i < nums.length; i++) {
              sum = sum + nums[i];
              temp.add(nums[i]);
            }
            if(sum==0){
                list.add(temp);
                return list;
            }
        }
        
		for (int i = 0; i < nums.length-1; i++) {

		       List<List<Integer>> twoSum = twoSum(nums, i + 1, nums.length - 1, -1 * nums[i]);
				if (!twoSum.isEmpty()) {
					for (List<Integer> temp : twoSum) {
						temp.add(nums[i]);
						Collections.sort(temp);
						String str = String.valueOf(temp);
                        if(!set.contains(str)) {
                        	set.add(str);
						    list.add(temp);
                        }
					}

				}
			

		}
		return list;
        
    }
    
    public static List<List<Integer>> twoSum(int[] nums, int i1, int j1, int sum) {

        List<List<Integer>> list = new ArrayList<List<Integer>>();
        if(j1-i1+1==2) {
           int sumN =0;
           List<Integer> temp =new ArrayList<Integer>();
          for(int i=i1;i<=j1;i++) {
             sumN = sumN + nums[i];
             temp.add(nums[i]);
           }
           if(sum==sumN){
               list.add(temp);
               return list;
           }
           return list;
       }

		HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
		for(int i=i1;i<=j1;i++) {
           if(map.containsKey(nums[i])) {
               List<Integer> temp =new ArrayList<Integer>();
               temp.add(nums[i]);
               temp.add(map.get(nums[i]));
               list.add(temp);
           } else {
               map.put(sum-nums[i],nums[i]);
           }
			
		}
		return list;
	}
	
	public static List<List<Integer>> threeSumSet(int[] nums) {

		HashSet<Integer> num = new HashSet<Integer>();
	
		List<List<Integer>> list = new ArrayList<List<Integer>>();
		
		HashSet<Integer> setInt = new HashSet<Integer>();

		for (int i = 0; i < nums.length ; i++) {
			
			setInt.add(nums[i]);
			
		}
		num.addAll(setInt);
        for(int val: setInt) {
        	num.remove(val);
				List<List<Integer>> twoSum = twoSumSet(num, -1 * val);
				if (!twoSum.isEmpty()) {
					for (List<Integer> temp : twoSum) {
						temp.add(val);
						Collections.sort(temp);
						
                       
						    list.add(temp);
                        
					}

				}
				
		}
	
		return list;
	}
	
	public static List<List<Integer>> twoSumSet(HashSet<Integer> nums, int sum) {

		HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
		List<List<Integer>> list = new ArrayList<List<Integer>>();
		for(int val : nums) {
            if(map.containsKey(val)) {
                List<Integer> temp =new ArrayList<Integer>();
                temp.add(val);
                temp.add(map.get(val));
                list.add(temp);
            } else {
                map.put(sum-val,val);
            }
			
		}
		return list;
	}
	
}