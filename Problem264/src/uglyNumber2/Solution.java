package uglyNumber2;

import java.util.*;

public class Solution {

	public int nthUglyNumber(int n){

		PriorityQueue<Long> queue = new PriorityQueue<Long>();
		HashSet<Long> set = new HashSet<Long>();
		queue.offer((long)1);
		set.add((long)1);
		long num = 0;
		for(int i =1;i<=n;i++){
			num = queue.poll();
			if(!set.contains(num*2)){
				queue.offer(num*2);
				set.add(num*2);
			}
			if(!set.contains(num*3)){
				queue.offer(num*3);
				set.add(num*3);
			}
			if(!set.contains(num*5)){
				queue.offer(num*5);
				set.add(num*5);
			}

		}
		return (int)num;
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Solution sol = new Solution();
		int n = 1;
		System.out.println(sol.nthUglyNumber(n));

	}

}
