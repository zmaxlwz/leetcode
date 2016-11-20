package superUglyNumber;

import java.util.*;

public class Solution {
	
	public int nthSuperUglyNumber(int n, int[] primes) {
		int k = primes.length;
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
		HashSet<Integer> set = new HashSet<Integer>();
		pq.offer(1);
		set.add(1);
		for(int i=0;i<n-1;i++){
			int num = pq.poll();
			//System.out.println(num);
			for(int j=0;j<k;j++){
				int newNum = num*primes[j];
				if(!set.contains(newNum)){
					set.add(newNum);
					pq.offer(newNum);
				}
				
			}
		}
		return pq.poll();
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Solution sol = new Solution();
		int[] primes = {2,7,13,19};
		int n = 12;
		System.out.println(sol.nthSuperUglyNumber(n, primes));
		
		
	}

}


