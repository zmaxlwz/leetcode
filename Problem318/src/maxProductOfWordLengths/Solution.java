package maxProductOfWordLengths;

import java.util.*;

public class Solution {
	
	public int maxProduct(String[] words) {
		if(words == null || words.length == 0){
			return 0;
		}
		int len = words.length;
		int maxProduct = 0;
		for(int i=0;i<len;i++){
			String s1 = words[i];
			for(int j=i+1;j<len;j++){
				String s2 = words[j];
				if(!hasCommonLetters(s1,s2)){
					int prod = s1.length()*s2.length();
					if(prod>maxProduct){
						maxProduct = prod;
					}
				}
			}
		}
		
		return maxProduct;
    }
	
	public boolean hasCommonLetters(String s1, String s2){
		if(s1 == null || s1.length() == 0 || s2 == null || s2.length() == 0){
			return false;
		}
		HashSet<Character> set = new HashSet<Character>();
		int length1 = s1.length();
		int length2 = s2.length();
		for(int i=0;i<length1;i++){
			set.add(s1.charAt(i));
		}
		for(int i=0;i<length2;i++){
			if(set.contains(s2.charAt(i))){
				return true;
			}
		}
		return false;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Solution sol = new Solution();
		String[] words = {"abcw", "baz", "foo", "bar", "xtfn", "abcdef"};
		System.out.println(sol.maxProduct(words));
		
	}

}
