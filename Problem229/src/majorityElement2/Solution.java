package majorityElement2;

import java.util.*;

public class Solution {

	public List<Integer> majorityElement(int[] nums){
		List<Integer> result = new ArrayList<Integer>();
		if(nums==null || nums.length==0){
			return result;
		}
		Integer n1 = null;
		Integer n2 = null;
		int c1 = 0;
		int c2 = 0;
		int length = nums.length;
		for(int i=0;i<length;i++){
			int num = nums[i];
			if(c1 == 0 && c2 == 0){
				n1 = num;
				c1 = 1;
				continue;
			}
			else if(c1 == 0 && num != n2){
				n1 = num;
				c1 = 1;
				continue;
			}
			else if(c1== 0 && num == n2){
				c2++;
				continue;
			}
			else if(c2 == 0 && num != n1){
				n2 = num;
				c2 = 1;
				continue;
			}
			else if(c2 == 0 && num == n1){
				c1++;
				continue;
			}


			if(num == n1){
				c1++;
			}
			else if(num == n2){
				c2++;
			}
			else{
				c1--;
				c2--;

			}

		}
		if(c1>0 && check(nums, n1)){
			result.add(n1);
		}
		if(c2>0 && check(nums, n2)){
			result.add(n2);
		}
		return result;

	}

	private boolean check(int[] nums, int n){
		int length = nums.length;
		int count = 0;
		for(int i=0;i<length;i++){
			if(nums[i] == n){
				count++;
			}
		}
		if(count>length/3)
			return true;
		else
			return false;
	}

	public List<Integer> majorityElement2(int[] nums){
		List<Integer> result = new ArrayList<Integer>();
		if(nums == null || nums.length == 0){
			return result;
		}
		int length = nums.length;
		int limit = length/3+1;
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for(int i = 0; i<length;i++ ){
			if(!map.containsKey(nums[i])){
				map.put(nums[i], 1);
			}
			else{
				map.put(nums[i], map.get(nums[i])+1);
			}
			
		}
		int count = 0;
		for(Integer key: map.keySet()){
			count = map.get(key);
			if(count>=limit){
				result.add(key);
			}
		}
		return result;
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//int[] nums = {2,3,1,3,4,5,3,2,3,2,2};
		int[] nums = {1,2,2,3,2,1,1,3};

		Solution sol = new Solution();
		System.out.println(sol.majorityElement2(nums));

	}

}
