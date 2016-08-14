package phoneNumber2;

import java.util.*;

public class Solution {

	HashMap<Integer, String> map;

	public Solution(){
		map = new HashMap<Integer, String>();
		map.put(0, " ");
		map.put(2, "abc");
		map.put(3, "def");
		map.put(4, "ghi");
		map.put(5, "jkl");
		map.put(6, "mno");
		map.put(7, "pqrs");
		map.put(8, "tuv");
		map.put(9, "wxyz");


	}

	public List<String> letterCombinations(String digits){
		List<String> result = new ArrayList<String>();
		if(digits == null || digits.length() == 0){
			return result;
		}
		List<Character> temp = new ArrayList<Character>();
		dfs(result, temp, digits, 0);
		return result;

	}

	public void dfs(List<String> result, List<Character> temp, String digits, int index){
		if(index>=digits.length()){
			StringBuffer sb = new StringBuffer();
			for(Character c: temp){
				sb.append(c);
			}
			result.add(sb.toString());
			return;
		}
		int digit = digits.charAt(index) - '0';
		String choices = this.map.get(digit);
		int length = choices.length();
		for(int i=0; i<length;i++ ){
			temp.add(choices.charAt(i));
			dfs(result, temp, digits, index+1);
			temp.remove(temp.size()-1);
		}
		return;
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Solution sol = new Solution();
		String digits = "23";
		System.out.println(sol.letterCombinations(digits));

	}

}
