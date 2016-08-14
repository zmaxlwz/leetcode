package threeSum;

import java.util.*;

public class Solution {

	public List<List<Integer>> threeSum(int[] nums){

		//result
		List<List<Integer>> result = new ArrayList<List<Integer>>();

		//sort the array
		Arrays.sort(nums);

		/*
		for(int i=0;i<nums.length;i++)
			System.out.println(nums[i]);
		 */

		//use two pointers to check

		//the left and right pointers
		int left, right;

		for(int i=0; i<nums.length-2; i++){
			//nums[i] is the first of the three elements

			//the element is duplicate, skip it
			if(i>0 && nums[i] == nums[i-1])
				continue;

			left = i+1;
			right = nums.length-1;

			while(left<right){

				if(nums[i]+nums[left]+nums[right] == 0){
					List<Integer> temp = new ArrayList<Integer>();
					temp.add(nums[i]);
					temp.add(nums[left]);
					temp.add(nums[right]);
					result.add(temp);
					//move left and right 
					left++;
					right--;
					//skip duplicates
					while(left < right && nums[left] == nums[left-1]){
						left++;
					}
					while(right > left && nums[right] == nums[right+1]){
						right--;
					}
				}
				else if(nums[i]+nums[left]+nums[right] < 0){
					left++;
				}
				else{
					right--;
				}

			}
		}

		return result;
	}

	public List<List<Integer>> threeSum2(int[] nums){
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		if(nums == null || nums.length <= 2){
			return result;
		}
		int length = nums.length;
		HashSet<List<Integer>> set = new HashSet<List<Integer>>();
		for(int i =0;i<length-2;i++){
			List<List<Integer>> twoLists = twoSum(nums, i+1, length-1, -nums[i]);
			for(List<Integer> list : twoLists){
				list.add(nums[i]);
				Collections.sort(list);
				if(!set.contains(list)){
					set.add(list);
					result.add(list);
				}
			}
		}
		return result;
	}

	public List<List<Integer>> twoSum(int[] nums, int start, int end, int sum){
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		HashSet<Integer> set = new HashSet<Integer>();
		if(nums == null || start>=end){
			return result;
		}
		for(int i =start;i<=end;i++){	
			if(set.contains(sum-nums[i])){
				List<Integer> list = new ArrayList<Integer>();
				list.add(sum-nums[i]);
				list.add(nums[i]);
				result.add(list);
			}
			else{
				set.add(nums[i]);
			}
		}
		return result;
	}

	public List<List<Integer>> threeSum3(int[] nums){
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		if(nums == null || nums.length<3){
			return result;
		}
		int length = nums.length;
		Arrays.sort(nums);
		int left, right;
		HashSet<List<Integer>> set = new HashSet<List<Integer>>();
		Integer lastNum = null;
		for(int i =0; i<length-2; i++ ){

			if(lastNum != null && lastNum == nums[i]){
				continue;
			}
			left = i+1;
			right = length-1;
			while(left<right){
				if(nums[i]+nums[left]+nums[right]<0){
					left++;
				}
				else if(nums[i]+nums[left]+nums[right]>0){
					right--;
				}
				else{
					List<Integer> list = new ArrayList<Integer>();
					list.add(nums[i]);
					list.add(nums[left]);
					list.add(nums[right]);
					if(!set.contains(list)){
						set.add(list);
						result.add(list);
					}
					left++;
					right--;
				}
			}
			lastNum = nums[i];
		}
		return result;
	}



	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//System.out.println("start...");
		/*
		List<Integer> list1 = new ArrayList<Integer>();
		list1.add(4);
		list1.add(3);
		System.out.println(list1);
		 */


		//int[] nums = {-1, 0, 1, 2, -1, -4};
		int[] nums = {0, 0, 0};
		Solution sol = new Solution();
		System.out.println(sol.threeSum3(nums));

		/*
		List<List<Integer>> result = sol.threeSum(nums);

		Iterator<List<Integer>> iter1 = result.iterator();
		while(iter1.hasNext()){
			List<Integer> list = iter1.next();
			Iterator<Integer> iter2 = list.iterator();
			while(iter2.hasNext()){
				System.out.print(iter2.next()+", ");
			}
			System.out.println();
		}
		 */

	}

}
