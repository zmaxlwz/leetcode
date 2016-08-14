package TwoSum;

import java.util.*;

public class TwoSum {

	/**
	 * the method to perform Two Sum operation
	 * @param nums	input array
	 * @param target	input target
	 * @return	an array with two index
	 */
	public int[] twoSum(int[] nums, int target){
		int[] result = new int[2];
		//create a hash table, key is the integer value, value is the index
		HashMap<Integer, Integer> hash = new HashMap<Integer, Integer>();

		for(int i = 0; i < nums.length; i++){
			if(!hash.containsKey(nums[i])){
				//if the hash table doesn't contain the value, 
				//then insert the complement value into the hash table
				hash.put(target - nums[i], i);
			}
			else{
				//the hash table contains the value
				result[0] = hash.get(nums[i]) + 1;
				result[1] = i + 1;
			}
		}

		return result;
	}

	public int[] twoSum2(int[] nums, int target){
		if(nums == null || nums.length == 0){
			return null;
		}
		int[] resultIndex = new int[2];
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		int length = nums.length;
		for(int i =0; i<length;i++){
			if(map.containsKey(target-nums[i])){
				resultIndex[0] = map.get(target-nums[i]);
				resultIndex[1] = i+1;
				return resultIndex;
			}
			else{
				map.put(nums[i], i+1);
			}
		}
		return null;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//System.out.println("hello");

		int[] array = {2,7,11,15};
		int target = 22;
		int[] result;

		TwoSum a = new TwoSum();
		result = a.twoSum(array, target);

		System.out.println("index1: " + result[0] + ", index2: " + result[1]);
		
		

	}

}
