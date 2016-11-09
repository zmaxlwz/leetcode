package validAnagram;

import java.util.*;

public class Solution {

	public boolean isAnagram(String s, String t){
		if(s.length() != t.length()){
			return false;
		}
		char[] cs = s.toCharArray();
		char[] ct = t.toCharArray();
		Arrays.sort(cs);
		Arrays.sort(ct);
		for(int i=0;i<cs.length;i++){
			if(cs[i] != ct[i]){
				return false;
			}
		}
		return true;
	}

	public boolean isAnagram2(String s, String t){
		if(s.length() != t.length()){
			return false;
		}
		if(s.length()==0){
			return true;
		}
		int length = s.length();
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		for(int i=0;i<length;i++){
			char c = s.charAt(i);
			if(!map.containsKey(c)){
				map.put(c, 1);
			}
			else{
				map.put(c, map.get(c)+1);
			}
		}

		for(int i=0;i<length;i++){
			char c = t.charAt(i);
			if(!map.containsKey(c)){
				return false;
			}
			else{
				map.put(c, map.get(c)-1);
			}
		}

		for(char c: map.keySet()){
			if(map.get(c) != 0){
				return false;
			}
		}
		return true;
	}

	public boolean isAnagram3(String s, String t){
		if(s==null){
			return t==null;
		}
		if(t==null){
			return s==null;
		}
		int length1 = s.length();
		int length2 = t.length();
		if(length1 != length2){
			return false;
		}
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		for(int i = 0; i<length1;i++ ){
			char c = s.charAt(i);
			if(!map.containsKey(c)){
				map.put(c, 1);
			}
			else{
				map.put(c, map.get(c)+1);
			}
		}
		for(int j = 0;j<length2;j++){
			char c = t.charAt(j);
			if(!map.containsKey(c)){
				return false;
			}
			else if(map.get(c)>0){
				map.put(c, map.get(c)-1);
			}
			else{
				return false;
			}
		}
		return true;
	}



	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String s = "anagram";
		String t = "nagaram";		
		//String s = "rat";
		//String t = "car";

		Solution sol = new Solution();
		System.out.println(sol.isAnagram3(s, t));

	}

}
