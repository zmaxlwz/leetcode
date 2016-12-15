package slidingWindowMax;

import java.util.*;

public class Solution {

	public int[] maxSlidingWindow(int[] nums, int k){
		if(nums == null || nums.length == 0 || k<=0){
            return new int[0];
        }
		int length = nums.length;
		int[] maxArray = new int[length-k+1];
		PriorityQueue<Integer> queue = new PriorityQueue<Integer>(k, new maxComparator());
		for(int i =0;i<k;i++){
			queue.offer(nums[i]);
		}
		for(int i = k;i<length;i++){
			maxArray[i-k] = queue.peek();
			queue.remove(nums[i-k]);
			queue.offer(nums[i]);
		}
		maxArray[length-k] = queue.peek();
		return maxArray;
	}

	public int[] maxSlidingWindow2(int[] nums, int k){
		
		if(nums == null || nums.length == 0){
            return new int[0];
        }
		
		int length = nums.length;
		int[] result = new int[length-k+1];
		
		LinkedList<Integer> deque = new LinkedList<Integer>();
		for(int i=0;i<length;i++){
			while(!deque.isEmpty() && deque.getLast() < nums[i]){
				deque.removeLast();
			}
			deque.offer(nums[i]);
			
			if(i>=k){
				if(deque.peek() == nums[i-k]){
					deque.poll();
				}
			}
			
			if(i>=k-1){
				result[i-k+1] = deque.peek();
			}
		}
		
		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Solution sol = new Solution();
		int[] nums = {1,3,-1,-3,5,3,6,7};
		int k=3;
		int[] result = sol.maxSlidingWindow2(nums, k);
		for(int i=0;i<result.length;i++){
			System.out.print(result[i] + ", ");
		}
		System.out.println();
	}

}

class maxComparator implements Comparator<Integer>{

	public int compare(Integer a, Integer b){
		return b-a;
	}
}
