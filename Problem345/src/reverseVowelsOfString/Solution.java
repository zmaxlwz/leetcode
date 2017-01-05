package reverseVowelsOfString;

import java.util.*;

public class Solution {
	
	public String reverseVowels(String s) {
		if(s == null || s.length() <= 1){
			return s;
		}
		
		HashSet<Character> set = new HashSet<Character>();
		set.add('a');
		set.add('e');
		set.add('i');
		set.add('o');
		set.add('u');
		set.add('A');
		set.add('E');
		set.add('I');
		set.add('O');
		set.add('U');
		
		
		char[] array = s.toCharArray();
		int length = s.length();
		int left = 0, right = length-1;
		while(left<right){
			if(!set.contains(array[left])){
				left++;
			}
			else if(!set.contains(array[right])){
				right--;
			}
			else{
				char temp = array[left];
				array[left] = array[right];
				array[right] = temp;
				left++;
				right--;
			}
		}
		
		return new String(array);
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Solution sol = new Solution();
		//String s = "hello";
		String s = "leetcode";
		System.out.println(sol.reverseVowels(s));

	}

}
