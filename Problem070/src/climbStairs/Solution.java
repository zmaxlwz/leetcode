package climbStairs;

public class Solution {

	public int climbStairs(int n){
		//there are n steps, each time can climb 1 or 2 steps
		//return the number of unique ways to reach step n
		//use Dynamic Programming

		if(n<=0)
			return 0;

		if(n==1)
			return 1;

		if(n==2)
			return 2;

		//the number of ways to reach step1
		int step1 = 1;
		//the number of ways to reach step2
		int step2 = 2;
		//the number of ways to reach step3
		int step3 = 0;

		for(int i=3;i<=n;i++){
			step3 = step1+step2;
			step1 = step2;
			step2 = step3;
		}

		return step3;
	}

	public int climbStairs2(int n){
		if(n<=0){
			return 0;
		}
		if(n==1){
			return 1;
		}
		if(n==2){
			return 2;
		}
		int numWays1 = 1;
		int numWays2 = 2;
		int numWays = 0;
		for(int i =3;i<=n;i++){
			numWays = numWays1 + numWays2;
			numWays1 = numWays2;
			numWays2 = numWays;
		}
		return numWays;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int n = 4;
		Solution sol = new Solution();
		System.out.println(sol.climbStairs(n));

	}

}
