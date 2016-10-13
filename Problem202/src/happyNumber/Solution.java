package happyNumber;

import java.util.*;

public class Solution {

	public boolean isHappy(int n){
		//check if the number n is a happy number		

		HashSet<Integer> set = new HashSet<Integer>();
		while(n != 1){
			if(!set.contains(n)){
				set.add(n);
				n = digitsSquare(n);
			}
			else{
				return false;
			}
		}
		return true;
	}

	private int digitsSquare(int n){
		//compute the square sum of each digit
		int result = 0;
		while(n>0){
			int digit = n%10;
			result += digit*digit;
			n = n/10;
		}
		return result;
	}

	public boolean isHappy2(int n){
		HashSet<Integer> set = new HashSet<Integer>();
		set.add(n);
		while(true){
			n = getDigitSquares(n);
			if(n==1){
				return true;
			}
			if(set.contains(n)){
				return false;
			}
			set.add(n);
		}

	}

	public int getDigitSquares(int n){
		int result = 0;
		while(n>0){
			int digit = n%10;
			result += digit*digit;
			n = n/10;
		}
		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int n = 64;
		Solution sol = new Solution();
		System.out.println(sol.isHappy2(n));

	}

}
